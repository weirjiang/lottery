package com.weir.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog="weir",name="activity_award")
public class ActivityAward {
	@Id
	@Column(name="award_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int awardId;
	@Column(name="activity_id")
	private int activityId;
	@Column(name="award_name",length=30)
	private String awardName;
	@Column(name="award_content",length=100)
	private String awardContent;
	@Column(name="award_count")
	private int awardCount;
	@Column(name="award_probability")
	private float awardProbability;
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
	public int getAwardCount() {
		return awardCount;
	}
	public void setAwardCount(int awardCount) {
		this.awardCount = awardCount;
	}
	public Float getAwardProbability() {
		return awardProbability;
	}
	public void setAwardProbability(float awardProbability) {
		this.awardProbability = awardProbability;
	}
	@Override
	public String toString() {
		return "ActivityAward [awardId=" + awardId + ", activityId="
				+ activityId + ", awardName=" + awardName + ", awardContent="
				+ awardContent + ", awardCount=" + awardCount
				+ ", awardProbability=" + awardProbability + "]";
	}
	public ActivityAward(int activityId, String awardName, String awardContent,
			int awardCount, float awardProbability) {
		super();
		this.activityId = activityId;
		this.awardName = awardName;
		this.awardContent = awardContent;
		this.awardCount = awardCount;
		this.awardProbability = awardProbability;
	}
	public ActivityAward(){}
}
