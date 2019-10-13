package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Series;

public class SeriesDao extends SuperOpr {

	public SeriesDao() {
		cm = new ConnectionManager();
	}

	public boolean AddSeries(Series series) {// 添加系列
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Series(BID,SName) VALUES(?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, series.getBID());
			psmt.setString(2, series.getSName());
			row = psmt.executeUpdate();
			if (row >= 1) {
				cm.close();
				flag = true;
			} else {
				cm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean DeletSeries(List<String> SIDList) {// 删除系列
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Series WHERE SID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String SID : SIDList) {
				psmt.setString(1, SID);
				psmt.addBatch();
			}
			psmt.executeBatch();
			con.commit();
			flag = true;
		} catch (SQLException e) {
			try {
				con.rollback();
				cm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}

	public boolean UpdateSeries(Series series) {// 更新系列信息
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Series set BID=? ,SName=? WHERE SID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, series.getBID());
			psmt.setString(2, series.getSName());
			psmt.setInt(3, series.getSID());
			row = psmt.executeUpdate();
			if (row >= 1) {
				con.close();
				flag = true;
			} else {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Series SelectSeriesOne(String SID) {// 根据主键SID查询
		Series series = new Series();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Series WHERE SID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, SID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				series.setSID(rs.getInt(1));
				series.setBID(rs.getInt(2));
				series.setSName(rs.getString(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return series;
	}

	public List<Series> SelectSeriesAll(String Concondition) {// 查询系列
		List<Series> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Series WHERE BID LIKE ? OR SName LIKE ?";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 2; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Series series = new Series();
				series.setSID(rs.getInt(1));
				series.setBID(rs.getInt(2));
				series.setSName(rs.getString(3));
				list.add(series);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Series[]> SelectSeriesAll(String conditions,String back) {// 查询系列
		List<Series[]> list = new ArrayList<Series[]>();
		conditions = "%" + conditions + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Series as s,Brand as b WHERE (b.BName LIKE ? OR s.SName LIKE ?) and s.BID = b.BID ";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 2; i++) {
				psmt.setString(i, conditions);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Series[] SB = new Series[2];
				Series series = new Series();
				series.setSID(rs.getInt(1));
				series.setBID(rs.getInt(2));
				series.setSName(rs.getString(3));
				SB[0] = series;
				series = new Series();
				series.setSName(rs.getString(5));
				SB[1] = series;
				list.add(SB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}