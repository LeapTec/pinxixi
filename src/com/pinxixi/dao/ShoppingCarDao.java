package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.ShoppingCar;

public class ShoppingCarDao extends SuperOpr {

	public ShoppingCarDao() {
		cm = new ConnectionManager();
	}

	public boolean AddShoppingCar(ShoppingCar shoppingCar) {// 添加购物车
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO ShoppingCar(UID,CID,Amount) VALUES(?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, shoppingCar.getUID());
			psmt.setInt(2, shoppingCar.getCID());
			psmt.setInt(3, shoppingCar.getAmount());
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

	public boolean DeletShoppingCar(List<String[]> UIDCIDList) {// 删除购物车
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM ShoppingCar WHERE UID = ? AND CID=?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String UIDCID[] : UIDCIDList) {
				psmt.setString(1, UIDCID[0]);
				psmt.setString(2, UIDCID[1]);
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

	public boolean UpdateShoppingCar(ShoppingCar shoppingCar) {// 更新购物车
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE ShoppingCar set Amount=? WHERE UID=? AND CID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, shoppingCar.getAmount());
			psmt.setInt(2, shoppingCar.getUID());
			psmt.setInt(3, shoppingCar.getCID());
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

	public ShoppingCar SelectShoppingCarOne(String UID,String CID) {// 根据UID和CID查询购物车
		ShoppingCar shoppingCar = new ShoppingCar();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM ShoppingCar WHERE UID=? AND CID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, UID);
			psmt.setString(2, CID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				shoppingCar.setUID(rs.getInt(1));
				shoppingCar.setCID(rs.getInt(2));
				shoppingCar.setAmount(rs.getInt(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shoppingCar;
	}

	public List<ShoppingCar> SelectShoppingCarAll(String Concondition) {// 查询购物车
		List<ShoppingCar> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM ShoppingCar WHERE UID LIKE ? ";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 1; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				ShoppingCar shoppingCar = new ShoppingCar();
				shoppingCar.setUID(rs.getInt(1));
				shoppingCar.setCID(rs.getInt(2));
				shoppingCar.setAmount(rs.getInt(3));
				list.add(shoppingCar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

