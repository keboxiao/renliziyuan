package com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "waibao")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userAccount;
	private String password;
	private String department;
	private String tel;
	private String email;
	private String level;
	private String fullname;
	private String xingming;
	private Short areaid;
	private String firm;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userAccount) {
		this.userAccount = userAccount;
	}
	
	/** full upload */
	public User(String userAccount, String password, String department,
			String tel, String email, String level,
			String xingming, Short areaid) {
		this.userAccount = userAccount;
		this.password = password;
		this.department = department;
		this.tel = tel;
		this.email = email;
		this.level = level;
		this.xingming = xingming;
		this.areaid = areaid;
	}

	/** full constructor */
	public User(String userAccount, String password, String department,
			String tel, String email, String level, String fullname,
			String xingming, Short areaid, String firm) {
		this.userAccount = userAccount;
		this.password = password;
		this.department = department;
		this.tel = tel;
		this.email = email;
		this.level = level;
		this.fullname = fullname;
		this.xingming = xingming;
		this.areaid = areaid;
		this.firm = firm;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userAccount", nullable = false, length = 20)
	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "department", length = 20)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "tel", length = 20)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "email", length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "level", length = 10)
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "fullname", length = 20)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "xingming", length = 10)
	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	@Column(name = "areaid")
	public Short getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Short areaid) {
		this.areaid = areaid;
	}

	@Column(name = "firm", length = 20)
	public String getFirm() {
		return this.firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

}