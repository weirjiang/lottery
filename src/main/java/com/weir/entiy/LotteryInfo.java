package com.weir.entiy;

public class LotteryInfo {
	private String activityName;
	private String awardName;
	private String awardContent;
	private String lotteryTime;
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getAwardContent() {
		return awardContent;
	}
	public void setAwardContent(String awardContent) {
		this.awardContent = awardContent;
	}
	public String getLotteryTime() {
		return lotteryTime;
	}
	public void setLotteryTime(String lotteryTime) {
		this.lotteryTime = lotteryTime;
	}
	public LotteryInfo(String activityName, String awardName,
			String awardContent, String lotteryTime) {
		super();
		this.activityName = activityName;
		this.awardName = awardName;
		this.awardContent = awardContent;
		this.lotteryTime = lotteryTime;
	}
	public LotteryInfo() {
		super();
	}
	@Override
	public String toString() {
		return "LotteryInfo [activityName=" + activityName + ", awardName="
				+ awardName + ", awardContent=" + awardContent
				+ ", lotteryTime=" + lotteryTime + "]";
	}
	
}
