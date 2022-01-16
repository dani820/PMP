package com.dani.spring.member.domain;

import java.sql.Date;

public class Member {

	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private int userAge;
	private String userPhone;
	private String userAddr;
	private Date enrollDate;
	private Date updateDate;
	private String mStatus;
	
	public Member() {}
	
	public Member(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public Member(String userId, String userPw, String userName, String userEmail, int userAge, String userPhone,
			String userAddr, Date enrollDate, Date updateDate, String mStatus) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.mStatus = mStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userAge=" + userAge + ", userPhone=" + userPhone + ", userAddr=" + userAddr + ", enrollDate="
				+ enrollDate + ", updateDate=" + updateDate + ", mStatus=" + mStatus + "]";
	}
	
	
	
}
