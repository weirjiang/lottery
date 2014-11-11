package com.weir.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog="weir",name="activity")
public class Activity {
	@Id
	@Column(name="activity_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int activityId;
	@Column(name="activity_name",length=100)
	private String activityName;
	@Column(name="start_time",length=30)
	private String startTime;
	@Column(name="end_time",length=30)
	private String endTime;
	@Column(name="consolation",length=30)
	private String consolation;
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getConsolation() {
		return consolation;
	}
	public void setConsolation(String consolation) {
		this.consolation = consolation;
	}
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName="
				+ activityName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", consolation=" + consolation + "]";
	}
	public Activity(int activityId, String activityName, String startTime,
			String endTime) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Activity( String activityName, String startTime,
			String endTime) {
		super();
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Activity( String activityName, String startTime,
			String endTime,String consolation) {
		super();
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.consolation = consolation;
	}
	
	public Activity(int activityId, String activityName, String startTime,
			String endTime, String consolation) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.consolation = consolation;
	}
	public Activity(){}
}
