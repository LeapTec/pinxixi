package com.pinxixi.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Adviertisement;

public class AdviertisementDao extends SuperOpr {

	public AdviertisementDao() {
		cm = new ConnectionManager();
	}
	
	public boolean UpdateAdviertisement(Adviertisement adviertisement) {// 更新广告
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Adviertisement set Grade=? ,ADDetails=? ,Path=? WHERE ADID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, adviertisement.getGrade());
			psmt.setString(2, adviertisement.getADDetails());
			psmt.setString(3, adviertisement.getPath());
			psmt.setInt(4, adviertisement.getADID());
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

	public List<Adviertisement> SelectAdviertisementAll() {// 查询广告
		List<Adviertisement> list = new ArrayList<>();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Adviertisement";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Adviertisement adviertisement = new Adviertisement();
				adviertisement.setADID(rs.getInt(1));
				adviertisement.setGrade(rs.getString(2));
				adviertisement.setADDetails(rs.getString(3));
				adviertisement.setPath(rs.getString(4));
				list.add(adviertisement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
