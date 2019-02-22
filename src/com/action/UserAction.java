package com.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.po.User;
import com.service.UserServiceI;

public class UserAction extends ActionSupport {

	private String userAccount;
	private String password;
	private String xingming;
	private UserServiceI userServiceI;
	private String wpswd1;
	private int page;
	private int rows;
	private File upload;
	private String uploadFileName;
	private String savePath;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getWpswd1() {
		return wpswd1;
	}

	public void setWpswd1(String wpswd1) {
		this.wpswd1 = wpswd1;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserServiceI getUserServiceI() {
		return userServiceI;
	}

	public void setUserServiceI(UserServiceI userServiceI) {
		this.userServiceI = userServiceI;
	}

	public String updatepass() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		int res = 0;
		if (u != null && u.getPassword().equals(this.getPassword())) {
			res = userServiceI.updatepass(u.getId(), wpswd1);
		}
		if (res > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String upload() throws Exception {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null && Integer.parseInt(u.getLevel()) < 3) {
			// 生成上传的文件对象
			File target = new File(savePath, uploadFileName);
			// 如果文件已经存在，则删除原有文件
			if (target.exists()) {
				target.delete();
			}
			// 复制file对象，实现上传
			try {
				FileUtils.copyFile(upload, target);
				userServiceI.excelToDB(target);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String login() {
		User u = userServiceI.login(userAccount, password);
		if (u != null) {
			Map session = ActionContext.getContext().getSession();
			session.put("user", u);
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}
	
	public void userShow() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null && Integer.parseInt(u.getLevel()) < 3) {
			writeJson(userServiceI.userShow(page, rows, xingming));
		}
	}

	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
	
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
