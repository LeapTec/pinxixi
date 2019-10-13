package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Address;

public class AddressDao extends SuperOpr {

	public AddressDao() {
		cm = new ConnectionManager();
	}

	public boolean AddAddress(Address address) {// 添加地址
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Address(UID,AName,Phone,Area,Address) VALUES(?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, address.getUID());
			psmt.setString(2, address.getAName());
			psmt.setString(3, address.getPhone());
			psmt.setString(4, address.getArea());
			psmt.setString(5, address.getAddress());
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

	public boolean DeletAddress(List<String> AIDList) {// 删除地址
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Address WHERE AID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String AID : AIDList) {
				psmt.setString(1, AID);
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

	public boolean UpdateAddress(Address address) {// 更新地址信息
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Address set UID=? ,AName=? ,Phone=? ,Area= ?,Address=? WHERE AID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, address.getUID());
			psmt.setString(2, address.getAName());
			psmt.setString(3, address.getPhone());
			psmt.setString(4, address.getArea());
			psmt.setString(5, address.getAddress());
			psmt.setInt(6, address.getAID());
			row = psmt.executeUpdate();
			if (row >= 1) {
				flag = true;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Address SelectAddressOne(int AID) {// 根据主键AID查询
		Address address = new Address();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Address WHERE AID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, AID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				address.setAID(rs.getInt(1));
				address.setUID(rs.getInt(2));
				address.setAName(rs.getString(3));
				address.setPhone(rs.getString(4));
				address.setArea(rs.getString(5));
				address.setAddress(rs.getString(6));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}

	public List<Address> SelectAddressAll(Integer UID) {// 查询地址
		List<Address> list = new ArrayList<Address>();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Address WHERE UID = ?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, UID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Address address = new Address();
				address.setAID(rs.getInt(1));
				address.setUID(rs.getInt(2));
				address.setAName(rs.getString(3));
				address.setPhone(rs.getString(4));
				address.setArea(rs.getString(5));
				address.setAddress(rs.getString(6));
				list.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
