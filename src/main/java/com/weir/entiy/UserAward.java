package com.weir.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserAward entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_award", catalog = "weir")
public class UserAward implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer activityId;
	private Integer awardId;
	private String lotteryTime;

	// Constructors

	/** default constructor */
	public UserAward() {
	}

	/** full constructor */
	public UserAward(Integer userId, Integer activityId, Integer awardId,
			String lotteryTime) {
		this.userId = userId;
		this.activityId = activityId;
		this.awardId = awardId;
		this.lotteryTime = lotteryTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "activity_id")
	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	@Column(name = "award_id")
	public Integer getAwardId() {
		return this.awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	@Column(name = "lottery_time", length = 30)
	public String getLotteryTime() {
		return this.lotteryTime;
	}

	public void setLotteryTime(String lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

	@Override
	public String toString() {
		return "UserAward [id=" + id + ", userId=" + userId + ", activityId="
				+ activityId + ", awardId=" + awardId + ", lotteryTime="
				+ lotteryTime + "]";
	}

}