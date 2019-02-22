package com.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.BaseDaoI;
import com.page.DataGrid;
import com.po.User;
import com.service.UserServiceI;

@Service("userServiceI")
public class UserServiceImpl implements UserServiceI {

	private BaseDaoI<User> baseDao;

	public BaseDaoI<User> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDaoI<User> baseDao) {
		this.baseDao = baseDao;
	}

	@Transactional
	public User login(String username, String password) {
		String hql = "from User where userAccount= :username and password= :password";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		params.put("password", password);
		return baseDao.get(hql, params);
	}

	@Transactional
	public int excelToDB(File f) {
		int rowsum = 0;
		try {
			Workbook rwb = Workbook.getWorkbook(f);
			Sheet sheet = rwb.getSheet(0);
			int columns = sheet.getColumns();
			int c = sheet.getRows();
			int row = 0;
			for (row = 0; row <= c; row++) {
				LinkedList<String> list = new LinkedList<String>();
				for (int i = 0; i < columns; i++) {
					Cell cel = sheet.getCell(i, row + 1);
					String strc = cel.getContents().toString();
					list.add(strc);
				}
				User tuser = new User(list.get(0), list.get(1), list.get(2),
						list.get(3), list.get(4), list.get(5), list.get(6),
						Short.parseShort(list.get(7)));
				baseDao.save(tuser);
				list.clear();
				rowsum++;
			}
			return rowsum;
		} catch (Exception e) {
			e.getStackTrace();
			return rowsum;
		} finally {
			f.delete();
		}
	}

	@Transactional
	public int updatepass(Integer id, String password) {
		String hql = "update User set password='" + password + "' where id="
				+ id;
		return baseDao.executeHql(hql);
	}

	@Transactional
	public DataGrid userShow(Integer page, Integer rows, String xingming) {
		String hql = "from User a";
		Map<String, Object> params = new HashMap<String, Object>();
		if (xingming != null && !xingming.equals("")) {
			hql = hql + " where a.xingming= :xingming";
			params.put("xingming", xingming);
		}
		DataGrid datagrid = new DataGrid();
		datagrid.setRows(baseDao.find(hql, params, page, rows));
		String count = "select count(*) " + hql;
		datagrid.setTotal(baseDao.count(count, params));
		return datagrid;
	}
}
