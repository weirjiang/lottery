package com.weir.util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.weir.entiy.ActivityAward;



public class LotteryUtil {
    public static int lottery(List<Float> orignalRates) {
        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }

        int size = orignalRates.size();

        double sumRate = 0d;
        for (double rate : orignalRates) {
            sumRate += rate;
        }

        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (double rate : orignalRates) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        double nextDouble = Math.random();
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);

        return sortOrignalRates.indexOf(nextDouble);
    }
    
    public  List sortAWardByprobiblity(List<ActivityAward> awardList){
    	Collections.sort(awardList, new Comparator<ActivityAward>(){
    		@Override  
            public int compare(ActivityAward a1, ActivityAward a2) {  
                return a1.getAwardProbability().compareTo(a2.getAwardProbability());  
            } 
    	});
    	List sortedList = awardList;
    	return sortedList;
    }
    
    public static void main(String args[]){
    	LotteryUtil util =  new LotteryUtil();
    	ActivityAward a1=new ActivityAward(2, "a2", "a2", 5, 0.2f);
    	ActivityAward a2=new ActivityAward(3, "a3", "a3", 5, 0.5f);
    	ActivityAward a3=new ActivityAward(1, "a1", "a1", 5, 0.4f);
    	List<ActivityAward> list = new ArrayList<ActivityAward>();
    	list.add(a1);
    	list.add(a2);
    	list.add(a3);
    	List sortedList =util.sortAWardByprobiblity(list);
    	System.out.println(sortedList.size());
    	for(int i=0;i<sortedList.size();i++){
    		ActivityAward aa = (ActivityAward) sortedList.get(0);
    		System.out.println(aa.toString());
    	}
    }
}