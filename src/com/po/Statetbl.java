package com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Statetbl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "statetbl", catalog = "waibao")
public class Statetbl implements java.io.Serializable {

	// Fields

	private Short state;
	private String zhuangtai;

	// Constructors

	/** default constructor */
	public Statetbl() {
	}

	public Statetbl(Short state) {
		this.state = state;
	}
	
	/** full constructor */
	public Statetbl(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "state", unique = true, nullable = false)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "zhuangtai", length = 10)
	public String getZhuangtai() {
		return this.zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

}