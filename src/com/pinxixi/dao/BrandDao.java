package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Brand;

public class BrandDao extends SuperOpr {

	public BrandDao() {
		cm = new ConnectionManager();
	}

	public boolean AddBrand(Brand brand) {// 添加品牌
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Brand(BName) VALUES(?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, brand.getBName());
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

	public boolean DeletBrand(List<String> BIDList) {// 删除品牌
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Brand WHERE BID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String BID : BIDList) {
				psmt.setString(1, BID);
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

	public boolean UpdateBrand(Brand brand) {// 更新用户信息
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Brand set BName=? WHERE BID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, brand.getBName());
			psmt.setInt(2, brand.getBID());
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

	public Brand SelectBrandOne(String BID) {// 根据主键BID查询
		Brand brand = new Brand();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Brand WHERE BID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, BID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				brand.setBID(rs.getInt(1));
				brand.setBName(rs.getString(2));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brand;
	}

	public List<Brand> SelectBrandAll(String Concondition) {// 查询品牌
		List<Brand> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Brand WHERE BName LIKE ?";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 1; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Brand brand = new Brand();
				brand.setBID(rs.getInt(1));
				brand.setBName(rs.getString(2));
				list.add(brand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
