package com.weir.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.DateFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weir.dao.IActivityAwardDao;
import com.weir.dao.IActivityDao;
import com.weir.dao.IAdminDao;
import com.weir.dao.IUserAwardDao;
import com.weir.dao.IUserDao;
import com.weir.entiy.Activity;
import com.weir.entiy.ActivityAward;
import com.weir.entiy.LotteryInfo;
import com.weir.entiy.User;
import com.weir.entiy.UserAward;
import com.weir.service.IUserService;
import com.weir.util.LotteryUtil;
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IAdminDao adminDao;
	@Resource
	private IUserDao userDao;
	@Resource
	private IActivityAwardDao activityAwardDao;	
	@Resource
	private IActivityDao activityDao;
	@Resource
	private IUserAwardDao userAwardDao;
	@Override
	public List getUser() {
		// TODO Auto-generated method stub
		return adminDao.getAdmin();
	}
	@Override
	public User getUSer(Integer user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(user_id);
	}
	@Override
	public boolean userLogin(Integer user_id, String password, String userType) {
		// TODO Auto-generated method stub
		User u = getUSer(user_id);
		if(u==null){
			return false;
		}else{
			if((u.getPassword().equals(password))&&(u.getUserType().equals(userType))){
				return true;
			}
			return false;
		}
	
	}
	@Override
	public List getActivityRuleById(Integer activityId) {
		// TODO Auto-generated method stub
		return activityAwardDao.getActivityAwardById(activityId);
	}
	@Override
	public Activity getActivityById(Integer activityId) {
		// TODO Auto-generated method stub
		return activityDao.getActivityById(activityId);
	}
	@Override
	public List getAwardByActivityId(Integer activityId) {
		// TODO Auto-generated method stub
		return activityAwardDao.getActivityAwardById(activityId);
	}
	@Override
	public UserAward lottery(Integer activityId,Integer userId,String lottery_time) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<ActivityAward> awardList = getAwardByActivityId(activityId);
		LotteryUtil util = new LotteryUtil();
		@SuppressWarnings("unchecked")
		List<ActivityAward> sortedList = util.sortAWardByprobiblity(awardList);
		List<Float> orignProbiblity = new ArrayList<Float>(sortedList.size());
		for(int i=0;i<sortedList.size();i++){
			orignProbiblity.add(sortedList.get(i).getAwardProbability());
		}
		UserAward ua=null;
	
			int i = util.lottery(orignProbiblity);
			ActivityAward aa = sortedList.get(i);
			int count = userAwardDao.getAwardCountById(aa.getActivityId(), aa.getAwardId());
			if(aa.getAwardProbability()!=0&&(count>=aa.getAwardCount())){
				//如果已达到某个奖项的最大次数，则转安慰奖
//				int awardId = activityAwardDao.getAwardIdByProbility(0f, activityId);
				//设置安慰奖的奖项编号为0
				ua=new UserAward(userId, activityId, 0, lottery_time);
			}else{
			ua = new UserAward(userId, activityId, aa.getAwardId(), lottery_time);
			}        
		return ua;
	}
	@Override
	public List<ActivityAward> getLottrtyAward(Integer activityId) {
		// TODO Auto-generated method stub
		List<ActivityAward> list = getAwardByActivityId(activityId);
		List<ActivityAward> removeList = new ArrayList<ActivityAward>(list.size());
		Iterator<ActivityAward> it = list.iterator();
		ActivityAward aa = new ActivityAward();
		while(it.hasNext()){
			aa = it.next();
			int count = userAwardDao.getAwardCountById(activityId, aa.getAwardId());
			if(aa.getAwardProbability()!=0&&(count==aa.getAwardCount())){
				removeList.add(aa);
			}
		}
		list.removeAll(removeList);
		return list;
	}
	@Override
	public int getLotteryCount(Integer userId, String time) {
		// TODO Auto-generated method stub
		return userDao.getLotteryCount(userId, time);
	}
	@Override
	@Transactional
	public void save(UserAward ua) {
		// TODO Auto-generated method stub
		userAwardDao.save(ua);
	}
	@Override
	public ActivityAward getaward(Integer activityId, Integer awardId) {
		// TODO Auto-generated method stub
		return activityAwardDao.getAward(activityId, awardId);
	}
	@Override
	public List<LotteryInfo> getLotteryInfo(Integer userId) {
		List<UserAward> userAwardList = userAwardDao.getUserAward(userId);
		Iterator<UserAward> it = userAwardList.iterator();
		List<LotteryInfo> infoList = new ArrayList<LotteryInfo>(userAwardList.size());
		UserAward ua = new UserAward();
		Activity act = new Activity();
		LotteryInfo info = new LotteryInfo();
		ActivityAward aa = new ActivityAward();
		while(it.hasNext()){
			ua = it.next();
			act = activityDao.getActivityById(ua.getActivityId());
			//判断是否安慰奖
			if(ua.getAwardId()==0){
				info = info = new LotteryInfo(act.getActivityName(),"安慰奖", act.getConsolation(), ua.getLotteryTime());
				infoList.add(info);
			}else{
				aa = activityAwardDao.getAward(ua.getActivityId(), ua.getAwardId());
				info = new LotteryInfo(act.getActivityName(), aa.getAwardName(), aa.getAwardContent(), ua.getLotteryTime());
				infoList.add(info);
			}
		
		}
		return infoList;
	}

}
