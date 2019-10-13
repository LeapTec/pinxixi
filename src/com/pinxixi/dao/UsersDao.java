
package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Users;

public class UsersDao extends SuperOpr {

	public UsersDao() {
		cm = new ConnectionManager();
	}

	public boolean Register(Users users) {// 注册用户
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Users(UName,UPassword,Sex,UNumber,UNType) VALUES(?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, users.getUName());
			psmt.setString(2, users.getUPassword());
			psmt.setString(3, users.getSex());
			psmt.setString(4, users.getUNumber());
			psmt.setString(5, users.getUNType());
			row = psmt.executeUpdate();
			if (row >= 1) {
				cm.close();
				flag=true;
			} else {
				cm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean DeletUsers(List<String> UIDList) {// 删除用户
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Users WHERE UID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String UID : UIDList) {
				psmt.setString(1, UID);
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

	public boolean UpdateUsers(Users users) {// 更新用户
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Users set UName=? ,Sex=? ,UNumber=? ,UNType=?  WHERE UID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, users.getUName());
			psmt.setString(2, users.getSex());
			psmt.setString(3, users.getUNumber());
			psmt.setString(4, users.getUNType());
			psmt.setInt(5, users.getUID());
			row = psmt.executeUpdate();
			if (row >= 1) {
				con.close();
				flag=true;
			} else {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean UpdateUsersPassword(String UName,String Password) {// 更新用户
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Users set UPassword=?  WHERE UName=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Password);
			psmt.setString(2, UName);
			row = psmt.executeUpdate();
			if (row >= 1) {
				con.close();
				flag=true;
			} else {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	public Users SelectUIDUser(String UID) {// 根据UID查询用户
		Users users = new Users();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Users WHERE UID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, UID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				users.setUID(rs.getInt(1));
				users.setUName(rs.getString(2));
				users.setUPassword(rs.getString(3));
				users.setSex(rs.getString(4));
				users.setUNumber(rs.getString(5));
				users.setUNType(rs.getString(6));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public Users SelectUNameUser(String UName) {// 根据UName查询用户
		Users users = new Users();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Users WHERE UName=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, UName);
			rs = psmt.executeQuery();
			while (rs.next()) {
				users.setUID(rs.getInt(1));
				users.setUName(rs.getString(2));
				users.setUPassword(rs.getString(3));
				users.setSex(rs.getString(4));
				users.setUNumber(rs.getString(5));
				users.setUNType(rs.getString(6));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Users> SelectUsersAll(String Concondition) {// 查询用户
		List<Users> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Users WHERE UName LIKE ? OR Sex LIKE ? OR UNumber LIKE ? OR UNType LIKE ?";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 4; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Users users = new Users();
				users.setUID(rs.getInt(1));
				users.setUName(rs.getString(2));
				users.setUPassword(rs.getString(3));
				users.setSex(rs.getString(4));
				users.setUNumber(rs.getString(5));
				users.setUNType(rs.getString(6));
				list.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
