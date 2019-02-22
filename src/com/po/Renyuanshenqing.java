package com.po;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Renyuanshenqing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "renyuanshenqing", catalog = "waibao")
public class Renyuanshenqing implements java.io.Serializable {

	// Fields

	private Integer id;
	private Areas areas;
	private User userByShenpirenid;
	private Statetbl statetbl;
	private User userByShenqingrenid;
	private String waibaogongsi;
	private Integer renyuanbianhao;
	private Date shenqingriqi;
	private Date shenheriqi;
	private String xingming;
	private String xb;
	private Date shengri;
	private String zgxl;
	private String zgxlbyyx;
	private String ywdymc;
	private String banzu;
	private String ywfw;
	private String shenfenzheng;
	private String shenqingliyou;
	private String rollbackrs;
	private String chushenyijian;

	// Constructors

	/** default constructor */
	public Renyuanshenqing() {
	}
	
	public Renyuanshenqing(Areas areas,
			Statetbl statetbl, 
			String xingming, String xb, Date shengri, String zgxl,
			String zgxlbyyx, String ywdymc, String banzu, String ywfw,
			String shenfenzheng, String shenqingliyou) {
		this.areas = areas;
		this.statetbl = statetbl;
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = shengri;
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
		this.shenqingliyou = shenqingliyou;
	}

	/** full constructor */
	public Renyuanshenqing(Areas areas, User userByShenpirenid,
			Statetbl statetbl, User userByShenqingrenid, String waibaogongsi,
			Integer renyuanbianhao, Date shenqingriqi, Date shenheriqi,
			String xingming, String xb, Date shengri, String zgxl,
			String zgxlbyyx, String ywdymc, String banzu, String ywfw,
			String shenfenzheng, String shenqingliyou, String rollbackrs,
			String chushenyijian) {
		this.areas = areas;
		this.userByShenpirenid = userByShenpirenid;
		this.statetbl = statetbl;
		this.userByShenqingrenid = userByShenqingrenid;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = shenqingriqi;
		this.shenheriqi = shenheriqi;
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = shengri;
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
		this.shenqingliyou = shenqingliyou;
		this.rollbackrs = rollbackrs;
		this.chushenyijian = chushenyijian;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "areaid")
	public Areas getAreas() {
		return this.areas;
	}

	public void setAreas(Areas areas) {
		this.areas = areas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shenpirenid")
	public User getUserByShenpirenid() {
		return this.userByShenpirenid;
	}

	public void setUserByShenpirenid(User userByShenpirenid) {
		this.userByShenpirenid = userByShenpirenid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state")
	public Statetbl getStatetbl() {
		return this.statetbl;
	}

	public void setStatetbl(Statetbl statetbl) {
		this.statetbl = statetbl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shenqingrenid")
	public User getUserByShenqingrenid() {
		return this.userByShenqingrenid;
	}

	public void setUserByShenqingrenid(User userByShenqingrenid) {
		this.userByShenqingrenid = userByShenqingrenid;
	}

	@Column(name = "waibaogongsi", length = 20)
	public String getWaibaogongsi() {
		return this.waibaogongsi;
	}

	public void setWaibaogongsi(String waibaogongsi) {
		this.waibaogongsi = waibaogongsi;
	}

	@Column(name = "renyuanbianhao")
	public Integer getRenyuanbianhao() {
		return this.renyuanbianhao;
	}

	public void setRenyuanbianhao(Integer renyuanbianhao) {
		this.renyuanbianhao = renyuanbianhao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "shenqingriqi", length = 10)
	public Date getShenqingriqi() {
		return this.shenqingriqi;
	}

	public void setShenqingriqi(Date shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "shenheriqi", length = 10)
	public Date getShenheriqi() {
		return this.shenheriqi;
	}

	public void setShenheriqi(Date shenheriqi) {
		this.shenheriqi = shenheriqi;
	}

	@Column(name = "xingming", length = 10)
	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	@Column(name = "xb", length = 5)
	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "shengri", length = 10)
	public Date getShengri() {
		return this.shengri;
	}

	public void setShengri(Date shengri) {
		this.shengri = shengri;
	}

	@Column(name = "zgxl", length = 20)
	public String getZgxl() {
		return this.zgxl;
	}

	public void setZgxl(String zgxl) {
		this.zgxl = zgxl;
	}

	@Column(name = "zgxlbyyx", length = 30)
	public String getZgxlbyyx() {
		return this.zgxlbyyx;
	}

	public void setZgxlbyyx(String zgxlbyyx) {
		this.zgxlbyyx = zgxlbyyx;
	}

	@Column(name = "ywdymc", length = 100)
	public String getYwdymc() {
		return this.ywdymc;
	}

	public void setYwdymc(String ywdymc) {
		this.ywdymc = ywdymc;
	}

	@Column(name = "banzu", length = 30)
	public String getBanzu() {
		return this.banzu;
	}

	public void setBanzu(String banzu) {
		this.banzu = banzu;
	}

	@Column(name = "ywfw", length = 30)
	public String getYwfw() {
		return this.ywfw;
	}

	public void setYwfw(String ywfw) {
		this.ywfw = ywfw;
	}

	@Column(name = "shenfenzheng", length = 20)
	public String getShenfenzheng() {
		return this.shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}

	@Column(name = "shenqingliyou")
	public String getShenqingliyou() {
		return this.shenqingliyou;
	}

	public void setShenqingliyou(String shenqingliyou) {
		this.shenqingliyou = shenqingliyou;
	}

	@Column(name = "rollbackrs", length = 50)
	public String getRollbackrs() {
		return this.rollbackrs;
	}

	public void setRollbackrs(String rollbackrs) {
		this.rollbackrs = rollbackrs;
	}

	@Column(name = "chushenyijian", length = 100)
	public String getChushenyijian() {
		return this.chushenyijian;
	}

	public void setChushenyijian(String chushenyijian) {
		this.chushenyijian = chushenyijian;
	}

}