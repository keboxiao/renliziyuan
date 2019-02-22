package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.page.Json;
import com.po.User;
import com.service.RenyuanServiceI;

public class RenyuanAction extends ActionSupport {

	private RenyuanServiceI renyuanService;
	private String xingming;
	private String begintime;
	private String endtime;
	private File upload;
	private String uploadFileName;
	private String savePath;
	private String ids;
	private int page;
	private int rows;
	private Integer id;
	private String csyj;
	private String wbgs;
	private String fileName;
	private InputStream excelFile;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}

	public String getWbgs() {
		return wbgs;
	}

	public void setWbgs(String wbgs) {
		this.wbgs = wbgs;
	}

	public String getCsyj() {
		return csyj;
	}

	public void setCsyj(String csyj) {
		this.csyj = csyj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public RenyuanServiceI getRenyuanService() {
		return renyuanService;
	}

	public void setRenyuanService(RenyuanServiceI renyuanService) {
		this.renyuanService = renyuanService;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public void search() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			writeJson(renyuanService.find(u.getAreaid(), xingming, begintime,
					endtime, page, rows));
		}
	}

	public void lindaoshow() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			writeJson(renyuanService.lindaoshenheshow(page, rows));
		}
	}

	public void jieguoshow() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			writeJson(renyuanService.jieguoshow(page, rows, u.getId()));
		}
	}

	public void chushenshow() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			writeJson(renyuanService.xinzengshenheshow(page, rows));
		}
	}

	public void daibanshow() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			writeJson(renyuanService.daibanshow(page, rows, u.getAreaid()));
		}
	}

	public String upload() throws Exception {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			// 生成上传的文件对象
			File target = new File(savePath, uploadFileName);
			// 如果文件已经存在，则删除原有文件
			if (target.exists()) {
				target.delete();
			}
			// 复制file对象，实现上传
			try {
				FileUtils.copyFile(upload, target);
				renyuanService.excelToDB(target, u.getAreaid());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}

	public void remove() {
		int res = renyuanService.remove(ids);
		Json j = new Json();
		j.setSuccess(true);
		String msg = "成功删除" + res + "条记录";
		j.setMsg(msg);
		writeJson(j);
	}

	public void submit() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		Json j = new Json();
		if (u != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			int res = renyuanService.submit(ids, u.getId(), sdf.format(d));
			String msg = "成功提交" + res + "条记录";
			j.setSuccess(true);
			j.setMsg(msg);
		} else {
			j.setSuccess(false);
			j.setMsg("提交失败！");
		}
		writeJson(j);
	}

	public void rollback() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		Json j = new Json();
		int level = Integer.parseInt(u.getLevel());
		if (u != null && level < 3) {
			int res = renyuanService.rollback(ids);
			j.setSuccess(true);
			String msg = "成功回退" + res + "条记录";
			j.setMsg(msg);
		} else {
			j.setSuccess(false);
			j.setMsg("回退失败！");
		}
		writeJson(j);
	}

	public void lindaorollback() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		Json j = new Json();
		if (u != null && u.getLevel().equals("1")) {
			int res = renyuanService.lindaorollback(ids);
			j.setSuccess(true);
			String msg = "成功回退" + res + "条记录";
			j.setMsg(msg);
		} else {
			j.setSuccess(false);
			j.setMsg("回退失败！");
		}
		writeJson(j);
	}

	public void xinzengshenhe() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		Json j = new Json();
		int level = Integer.parseInt(u.getLevel());
		if (u != null && level < 3) {
			int res = renyuanService.xinzengshenhe(ids, csyj);
			j.setSuccess(true);
			String msg = "成功审核" + res + "条记录";
			j.setMsg(msg);
		} else {
			j.setSuccess(false);
			j.setMsg("审核失败！");
		}
		writeJson(j);
	}

	public void lindaoshenhe() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		Json j = new Json();
		if (u != null && u.getLevel().equals("1")) {
			int res = renyuanService.lindaoshenhe(ids, u.getId(), wbgs);
			j.setSuccess(true);
			String msg = "成功审核" + res + "条记录";
			j.setMsg(msg);
		} else {
			j.setSuccess(false);
			j.setMsg("审核失败！");
		}
		writeJson(j);
	}

	public void guidang() {
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		Json j = new Json();
		if (u != null) {
			int res = renyuanService.guidang(ids);
			j.setSuccess(true);
			String msg = "成功归档" + res + "条记录";
			j.setMsg(msg);
		} else {
			j.setSuccess(false);
			j.setMsg("归档失败！");
		}
		writeJson(j);
	}

	public void showinfo() {
		writeJson(renyuanService.showInfo(id));
	}

	public String daochu() throws Exception {
		//String path = "E://uploadfile//downloadfile.xls";
		Map session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		if (u != null) {
			File f = new File(savePath);
			f.createNewFile();
			this.setFileName("downloadfile.xls");
			renyuanService.dbToExcel(new FileOutputStream(f), u.getAreaid(),
					xingming, begintime, endtime);
			excelFile = new FileInputStream(savePath);
		}
		return "excel";
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
