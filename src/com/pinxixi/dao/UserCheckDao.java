package com.pinxixi.dao;

import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;

public class UserCheckDao extends SuperOpr {

	public UserCheckDao() {
		cm=new ConnectionManager();
	}
	public boolean UserCheck(String UName,String UPassword) {
		boolean flag=false;
		try {
			sql="Select * From Users Where Users.UName=? AND Users.UPassword=?";
			con=cm.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, UName);
			psmt.setString(2, UPassword);
			rs=psmt.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			cm.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
}
