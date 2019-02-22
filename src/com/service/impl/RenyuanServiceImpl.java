package com.service.impl;

import java.io.File;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.WritableFont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BaseDaoI;
import com.dto.RenyuanDTO;
import com.page.DataGrid;
import com.po.Areas;
import com.po.Renyuanshenqing;
import com.po.Statetbl;
import com.service.RenyuanServiceI;

@Service("renyuanService")
public class RenyuanServiceImpl implements RenyuanServiceI {

	private BaseDaoI baseDao;

	public BaseDaoI getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDaoI baseDao) {
		this.baseDao = baseDao;
	}

	@Transactional
	public DataGrid find(Short area, String xingming, String begintimes,
			String endtimes, int page, int rows) {
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		Short state = 2;
		params.put("state", state);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (area == 1) {
			hql = "select new com.dto.RenyuanDTO(b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.shenheriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id> :state";

		} else {
			hql = "select new com.dto.RenyuanDTO(b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.shenheriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id> :state and b.id= :areaid";
			params.put("areaid", area);
		}

		if (xingming != null && !xingming.equals("")) {
			hql = hql + " and a.xingming= :xingming";
			params.put("xingming", xingming);
		}

		if (begintimes != null && !begintimes.equals("")) {
			hql = hql + " and a.shenheriqi >= :begintime";
			try {
				Date begintime = sdf.parse(begintimes);
				params.put("begintime", begintime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (endtimes != null && !endtimes.equals("")) {
			hql = hql + " and a.shenheriqi <= :endtime";
			try {
				Date endtime = sdf.parse(endtimes);
				params.put("endtime", endtime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		DataGrid datagrid = new DataGrid();
		datagrid.setRows(baseDao.find(hql, params, page, rows));
		String totalhql = "select count(*)"
				+ hql.subSequence(203, hql.length());
		datagrid.setTotal((Long) baseDao.count(totalhql, params));
		return datagrid;
	}

	@Transactional
	public DataGrid lindaoshenheshow(int page, int rows) {
		Map<String, Object> params = new HashMap<String, Object>();
		Short state = 2;
		params.put("state", state);
		String hql = "select new com.dto.RenyuanDTO(a.id,b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id= :state";

		DataGrid datagrid = new DataGrid();
		datagrid.setRows(baseDao.find(hql, params, page, rows));
		String totalhql = "select count(*)"
				+ hql.subSequence(195, hql.length());
		datagrid.setTotal((Long) baseDao.count(totalhql, params));
		return datagrid;
	}

	@Transactional
	public DataGrid jieguoshow(int page, int rows, Integer userid) {
		Map<String, Object> params = new HashMap<String, Object>();
		Short state = 3;
		params.put("state", state);
		params.put("userid", userid);
		String hql = "select new com.dto.RenyuanDTO(a.id,b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.shenheriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id= :state and c.id= :userid";

		DataGrid datagrid = new DataGrid();
		datagrid.setRows(baseDao.find(hql, params, page, rows));
		String totalhql = "select count(*)"
				+ hql.subSequence(208, hql.length());
		datagrid.setTotal((Long) baseDao.count(totalhql, params));
		return datagrid;
	}

	@Transactional
	public DataGrid xinzengshenheshow(int page, int rows) {
		Map<String, Object> params = new HashMap<String, Object>();
		Short state = 1;
		params.put("state", state);
		String hql = "select new com.dto.RenyuanDTO(a.id,b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id= :state";

		DataGrid datagrid = new DataGrid();
		datagrid.setRows(baseDao.find(hql, params, page, rows));
		String totalhql = "select count(*)"
				+ hql.subSequence(195, hql.length());
		datagrid.setTotal((Long) baseDao.count(totalhql, params));
		return datagrid;
	}

	@Transactional
	public DataGrid daibanshow(int page, int rows, Short areaid) {
		Map<String, Object> params = new HashMap<String, Object>();
		Short state = 0;
		params.put("state", state);
		params.put("areaid", areaid);
		String hql = "select new com.dto.RenyuanDTO(a.id,b.area,d.zhuangtai,a.waibaogongsi,a.renyuanbianhao,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng) from Renyuanshenqing a inner join a.areas b inner join a.statetbl d where d.id= :state and b.id= :areaid";
		DataGrid datagrid = new DataGrid();
		datagrid.setRows(baseDao.find(hql, params, page, rows));
		String totalhql = "select count(*)"
				+ hql.subSequence(169, hql.length());
		datagrid.setTotal((Long) baseDao.count(totalhql, params));
		return datagrid;
	}

	@Transactional
	public synchronized int excelToDB(File f, Short Areaid) {
		int rowsum = 0;
		try {
			// FileInputStream is = new FileInputStream(f);
			jxl.Workbook rwb = Workbook.getWorkbook(f);
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
				Short state = 0;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Renyuanshenqing rysq = new Renyuanshenqing(new Areas(Areaid),
						new Statetbl(state), list.get(0), list.get(1),
						sdf.parse(list.get(2)), list.get(3), list.get(4),
						list.get(5), list.get(6), list.get(7), list.get(8),
						list.get(9));
				baseDao.save(rysq);
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
	public int remove(String ids) {
		String hql = "delete Renyuanshenqing t where t.id in (" + ids + ")";
		return baseDao.executeHql(hql);
	}

	@Transactional
	public int submit(String ids, int shenqingrenid, String shenqingriqi) {
		String hql = "update Renyuanshenqing t set t.statetbl.id=1 ,t.userByShenqingrenid="
				+ shenqingrenid
				+ " , t.shenqingriqi='"
				+ shenqingriqi
				+ "' where t.id in (" + ids + ")";
		return baseDao.executeHql(hql);
	}

	@Transactional
	public int xinzengshenhe(String ids, String csyj) {
		String hql = "update Renyuanshenqing t set t.statetbl.id=2 ,t.chushenyijian='"
				+ csyj + "' where t.id in (" + ids + ")";
		return baseDao.executeHql(hql);
	}

	@Transactional
	public int lindaoshenhe(String ids, Integer shenpiid, String wbgs) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String maxhql = "select max(a.renyuanbianhao) from Renyuanshenqing a";
		Integer max = baseDao.getmax(maxhql);
		String[] strarr = ids.split(",");
		int i;
		for (i = 0; i < strarr.length; i++) {
			max++;
			String hql = "update Renyuanshenqing t set t.statetbl.id=3 , t.shenheriqi='"
					+ sdf.format(d)
					+ "' , t.userByShenpirenid="
					+ shenpiid
					+ " , t.waibaogongsi='"
					+ wbgs
					+ "' , t.renyuanbianhao="
					+ max + " where t.id =" + strarr[i];
			baseDao.executeHql(hql);
		}
		return i;
	}

	@Transactional
	public int rollback(String ids) {
		String hql = "update Renyuanshenqing t set t.statetbl.id=0 where t.id in ("
				+ ids + ")";
		return baseDao.executeHql(hql);
	}

	@Transactional
	public int guidang(String ids) {
		String hql = "update Renyuanshenqing t set t.statetbl.id=4 where t.id in ("
				+ ids + ")";
		return baseDao.executeHql(hql);
	}

	@Transactional
	public int lindaorollback(String ids) {
		String hql = "update Renyuanshenqing t set t.statetbl.id=1 where t.id in ("
				+ ids + ")";
		return baseDao.executeHql(hql);
	}

	@Transactional
	public RenyuanDTO showInfo(Integer id) {
		String hql = "select new com.dto.RenyuanDTO(a.id,b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng,a.shenqingliyou,a.chushenyijian) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where a.id= "
				+ id;
		return (RenyuanDTO) baseDao.get(hql);
	}

	@Transactional
	public int dbToExcel(OutputStream os, Short area, String xingming, String begintimes,
			String endtimes) {
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		Short state = 2;
		params.put("state", state);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (area == 1) {
			hql = "select new com.dto.RenyuanDTO(b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.shenheriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng,a.shenqingliyou) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id> :state";

		} else {
			hql = "select new com.dto.RenyuanDTO(b.area,d.zhuangtai,c.xingming,a.waibaogongsi,a.renyuanbianhao,a.shenqingriqi,a.shenheriqi,a.xingming,a.xb,a.shengri,a.zgxl,a.zgxlbyyx,a.ywdymc,a.banzu,a.ywfw,a.shenfenzheng,a.shenqingliyou) from Renyuanshenqing a inner join a.areas b inner join a.userByShenqingrenid c inner join a.statetbl d where d.id> :state and b.id= :areaid";
			params.put("areaid", area);
		}

		if (xingming != null && !xingming.equals("")) {
			hql = hql + " and a.xingming= :xingming";
			params.put("xingming", xingming);
		}

		if (begintimes != null && !begintimes.equals("")) {
			hql = hql + " and a.shenheriqi >= :begintime";
			try {
				Date begintime = sdf.parse(begintimes);
				params.put("begintime", begintime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (endtimes != null && !endtimes.equals("")) {
			hql = hql + " and a.shenheriqi <= :endtime";
			try {
				Date endtime = sdf.parse(endtimes);
				params.put("endtime", endtime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return writeExcelFile(os, baseDao.find(hql, params));

	}

	public synchronized int writeExcelFile(OutputStream os,
			List<RenyuanDTO> list) {
		int rowsum = 0;
		try {
			jxl.write.Label labelC;
			jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);

			jxl.write.WritableFont wfc = new jxl.write.WritableFont(
					WritableFont.ARIAL, 10, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(
					wfc);
			wcfFC.setBackground(jxl.format.Colour.YELLOW);
			wcfFC.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			wcfFC.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			wcfFC.setAlignment(jxl.format.Alignment.CENTRE);

			jxl.write.WritableFont wfc1 = new jxl.write.WritableFont(
					WritableFont.TIMES, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
			jxl.write.WritableCellFormat wcfFC1 = new jxl.write.WritableCellFormat(
					wfc1);
			wcfFC1.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLACK);
			wcfFC1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

			jxl.write.WritableSheet ws = wwb.createSheet("导出信息", 0);
			ws.setRowView(0, 500);
			labelC = new jxl.write.Label(0, 0, "分公司", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(1, 0, "外包公司", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(2, 0, "姓名", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(3, 0, "性别", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(4, 0, "身份证号码", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(5, 0, "出生年月", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(6, 0, "最高学历", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(7, 0, "毕业院校", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(8, 0, "拟安排部门", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(9, 0, "班组", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(10, 0, "拟安排岗位", wcfFC);
			ws.addCell(labelC);

			labelC = new jxl.write.Label(11, 0, "申请理由", wcfFC);
			ws.addCell(labelC);

			for (int i = 0; i < list.size(); i++) {
				rowsum = i + 1;
				labelC = new jxl.write.Label(0, rowsum, list.get(i).getAreas(),
						wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(1, rowsum, list.get(i)
						.getWaibaogongsi(), wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(2, rowsum, list.get(i)
						.getXingming(), wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(3, rowsum, list.get(i).getXb(),
						wcfFC1);
				ws.addCell(labelC);

				labelC = new jxl.write.Label(4, rowsum, list.get(i)
						.getShenfenzheng(), wcfFC1);
				ws.addCell(labelC);

				labelC = new jxl.write.Label(5, rowsum, list.get(i)
						.getShengri(), wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(6, rowsum, list.get(i).getZgxl(),
						wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(7, rowsum, list.get(i)
						.getZgxlbyyx(), wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(8, rowsum,
						list.get(i).getYwdymc(), wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(9, rowsum, list.get(i).getBanzu(),
						wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(10, rowsum, list.get(i).getYwfw(),
						wcfFC1);
				ws.addCell(labelC);
				labelC = new jxl.write.Label(11, rowsum, list.get(i)
						.getShenqingliyou(), wcfFC1);
				ws.addCell(labelC);

			}

			// 写入Exel工作表
			wwb.write();
			// 关闭Excel工作薄对象
			wwb.close();
			os.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return rowsum;
	}
}
