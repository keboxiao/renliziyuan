package com.service;

import java.io.File;
import java.io.OutputStream;

import com.dto.RenyuanDTO;
import com.page.DataGrid;

public interface RenyuanServiceI {

	public DataGrid find(Short area, String xingming, String begintime, String endtime, int page, int rows);
	public DataGrid lindaoshenheshow(int page, int rows);
	public DataGrid xinzengshenheshow(int page, int rows);
	public int excelToDB(File f, Short Areaid);
	public DataGrid daibanshow(int page, int rows, Short areaid);
	public int remove(String ids);
	public int submit(String ids , int shenqingrenid , String shenqingriqi);
	public int rollback(String ids);
	public RenyuanDTO showInfo(Integer id);
	public int xinzengshenhe(String ids , String csyj);
	public int lindaoshenhe(String ids , Integer shenpiid, String wbgs);
	public int lindaorollback(String ids);
	public DataGrid jieguoshow(int page, int rows, Integer userid);
	public int guidang(String ids);
	public int dbToExcel(OutputStream os, Short area, String xingming, String begintimes, String endtimes);

}
