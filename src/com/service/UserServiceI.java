package com.service;

import java.io.File;

import com.page.DataGrid;
import com.po.User;

public interface UserServiceI {

	public User login(String username, String password);
	public int updatepass(Integer id, String password);
	public DataGrid userShow(Integer page, Integer rows, String xingming);
	public int excelToDB(File f);
}
