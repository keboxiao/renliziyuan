package com.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RenyuanDTO {
	private Integer id;
	private String areas;
	private String shenpiren;
	private String state;
	private String shenqingren;
	private String waibaogongsi;
	private Integer renyuanbianhao;
	private String shenqingriqi;
	private String shenheriqi;
	private String xingming;
	private String xb;
	private String shengri;
	private String zgxl;
	private String zgxlbyyx;
	private String ywdymc;
	private String banzu;
	private String ywfw;
	private String shenfenzheng;
	private String shenqingliyou;
	private String rollbackrs;
	private String chushenyijian;
	private Integer age;

	// Constructors

	/** default constructor */
	public RenyuanDTO() {
	}
	
	//for jieguoshow
	public RenyuanDTO(Integer id, String areas, String state,
			String shenqingren, String waibaogongsi, Integer renyuanbianhao,
			Date shenqingriqi, Date shenheriqi, String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.id = id;
		this.areas = areas;
		this.state = state;
		this.shenqingren = shenqingren;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = sdf.format(shenqingriqi);
		this.shenheriqi = sdf.format(shenheriqi);
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
	}

	
	//for dbToExcel
	public RenyuanDTO(String areas, String state,
			String shenqingren, String waibaogongsi, Integer renyuanbianhao,
			Date shenqingriqi, Date shenheriqi, String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng,String shenqingliyou) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.areas = areas;
		this.state = state;
		this.shenqingren = shenqingren;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = sdf.format(shenqingriqi);
		this.shenheriqi = sdf.format(shenheriqi);
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
		this.shenqingliyou = shenqingliyou;
	}
	//for show info
	public RenyuanDTO(Integer id,String areas, String state,
			String shenqingren, String waibaogongsi, Integer renyuanbianhao,
			Date shenqingriqi, String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng, String shenqingliyou, String chushenyijian) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.id=id;
		this.areas = areas;
		this.state = state;
		this.shenqingren = shenqingren;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = sdf.format(shenqingriqi);
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
		this.age=calAge(shengri);
		this.shenqingliyou=shenqingliyou;
		this.chushenyijian=chushenyijian;
	}
	
	public RenyuanDTO(Integer id,String areas, String state,
			 String waibaogongsi, Integer renyuanbianhao,
			 String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.id=id;
		this.areas = areas;
		this.state = state;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
		this.age=calAge(shengri);
	}

	public RenyuanDTO(Integer id,String areas, String state,
			String shenqingren, String waibaogongsi, Integer renyuanbianhao,
			Date shenqingriqi, String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.id=id;
		this.areas = areas;
		this.state = state;
		this.shenqingren = shenqingren;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = sdf.format(shenqingriqi);
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
		this.age=calAge(shengri);
	}

	//for find
	public RenyuanDTO(String areas, String state,
			String shenqingren, String waibaogongsi, Integer renyuanbianhao,
			Date shenqingriqi, Date shenheriqi, String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.areas = areas;
		this.state = state;
		this.shenqingren = shenqingren;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = sdf.format(shenqingriqi);
		this.shenheriqi = sdf.format(shenheriqi);
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
		this.zgxl = zgxl;
		this.zgxlbyyx = zgxlbyyx;
		this.ywdymc = ywdymc;
		this.banzu = banzu;
		this.ywfw = ywfw;
		this.shenfenzheng = shenfenzheng;
	}

	/** full constructor */
	public RenyuanDTO(String areas, String shenpiren, String state,
			String shenqingren, String waibaogongsi, Integer renyuanbianhao,
			Date shenqingriqi, Date shenheriqi, String xingming, String xb,
			Date shengri, String zgxl, String zgxlbyyx, String ywdymc,
			String banzu, String ywfw, String shenfenzheng,
			String shenqingliyou, String rollbackrs, String chushenyijian) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.areas = areas;
		this.shenpiren = shenpiren;
		this.state = state;
		this.shenqingren = shenqingren;
		this.waibaogongsi = waibaogongsi;
		this.renyuanbianhao = renyuanbianhao;
		this.shenqingriqi = sdf.format(shenqingriqi);
		this.shenheriqi = sdf.format(shenheriqi);
		this.xingming = xingming;
		this.xb = xb;
		this.shengri = sdf.format(shengri);
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

    public int calAge(Date dateOfBirth) {
        int age = 0;
        Calendar born = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        if (dateOfBirth != null) {
            now.setTime(new Date());
            born.setTime(dateOfBirth);
            if (born.after(now)) {
                throw new IllegalArgumentException("年龄不能超过当前日期");
            }
            age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
            int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
            int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
            if (nowDayOfYear < bornDayOfYear) {
                age -= 1;
            }
        }
        return age;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getShenpiren() {
		return shenpiren;
	}

	public void setShenpiren(String shenpiren) {
		this.shenpiren = shenpiren;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getShenqingren() {
		return shenqingren;
	}

	public void setShenqingren(String shenqingren) {
		this.shenqingren = shenqingren;
	}

	public String getWaibaogongsi() {
		return waibaogongsi;
	}

	public void setWaibaogongsi(String waibaogongsi) {
		this.waibaogongsi = waibaogongsi;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public Integer getRenyuanbianhao() {
		return renyuanbianhao;
	}

	public void setRenyuanbianhao(Integer renyuanbianhao) {
		this.renyuanbianhao = renyuanbianhao;
	}

	public String getShenqingriqi() {
		return shenqingriqi;
	}

	public void setShenqingriqi(String shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
	}

	public String getShenheriqi() {
		return shenheriqi;
	}

	public void setShenheriqi(String shenheriqi) {
		this.shenheriqi = shenheriqi;
	}

	public String getShengri() {
		return shengri;
	}

	public void setShengri(String shengri) {
		this.shengri = shengri;
	}

	public String getZgxl() {
		return zgxl;
	}

	public void setZgxl(String zgxl) {
		this.zgxl = zgxl;
	}

	public String getZgxlbyyx() {
		return zgxlbyyx;
	}

	public void setZgxlbyyx(String zgxlbyyx) {
		this.zgxlbyyx = zgxlbyyx;
	}

	public String getYwdymc() {
		return ywdymc;
	}

	public void setYwdymc(String ywdymc) {
		this.ywdymc = ywdymc;
	}

	public String getBanzu() {
		return banzu;
	}

	public void setBanzu(String banzu) {
		this.banzu = banzu;
	}

	public String getYwfw() {
		return ywfw;
	}

	public void setYwfw(String ywfw) {
		this.ywfw = ywfw;
	}

	public String getShenfenzheng() {
		return shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}

	public String getShenqingliyou() {
		return shenqingliyou;
	}

	public void setShenqingliyou(String shenqingliyou) {
		this.shenqingliyou = shenqingliyou;
	}

	public String getRollbackrs() {
		return rollbackrs;
	}

	public void setRollbackrs(String rollbackrs) {
		this.rollbackrs = rollbackrs;
	}

	public String getChushenyijian() {
		return chushenyijian;
	}

	public void setChushenyijian(String chushenyijian) {
		this.chushenyijian = chushenyijian;
	}

}
