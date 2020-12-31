package com.board.back.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//유저테이블 
@Entity
@Table(name = "member")
@DynamicInsert
@DynamicUpdate
public class Member {

	// 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;

	// 아이디
	@Column(name = "id")
	private String id;

	// 패스워드
	@Column(name = "password")
	private String password;

	// 이름
	@Column(name = "name")
	private String name;

	// 핸드폰번호
	@Column(name = "cp_number")
	private String cp_number;

	// 전화번호
	@Column(name = "phone_number")
	private String phone_number;

	// 국가
	@Column(name = "country")
	private String country;

	// 우편번호
	@Column(name = "postal_code")
	private String postal_code;

	// 주소1
	@Column(name = "address_1")
	private String address_1;

	// 주소2
	@Column(name = "address_2")
	private String address_2;

	// 주소3
	@Column(name = "address_3")
	private String address_3;

	// 주소4
	@Column(name = "address_4")
	private String address_4;

	// 성별
	@Column(name = "sex")
	private Integer sex;

	// 생일
	@Column(name = "birthday")
	private Date birthday;

	// 닉네임
	@Column(name = "nickname")
	private String nickname;

	// 가입날자
	@Column(name = "joined_date")
	private Date joinedDate;

	// 마지막로그인날자
	@Column(name = "last_login_date")
	private Date lastLoginDate;

	// 유저상태 0:정상유저,1:VIP유저,2:탈퇴유저,3:블럭유저
	@Column(name = "user_status")
	private Integer userStatus;

	// 레코드생성일
	@Column(name = "created_date")
	private Date createdDate;

	// 레코드갱신일
	@Column(name = "updated_date")
	private Date updatedDate;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCp_number() {
		return cp_number;
	}

	public void setCp_number(String cp_number) {
		this.cp_number = cp_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getAddress_3() {
		return address_3;
	}

	public void setAddress_3(String address_3) {
		this.address_3 = address_3;
	}

	public String getAddress_4() {
		return address_4;
	}

	public void setAddress_4(String address_4) {
		this.address_4 = address_4;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", cp_number="
				+ cp_number + ", phone_number=" + phone_number + ", country=" + country + ", postal_code=" + postal_code
				+ ", address_1=" + address_1 + ", address_2=" + address_2 + ", address_3=" + address_3 + ", address_4="
				+ address_4 + ", sex=" + sex + ", birthday=" + birthday + ", nickname=" + nickname + ", joinedDate="
				+ joinedDate + ", lastLoginDate=" + lastLoginDate + ", userStatus=" + userStatus + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}


	

}