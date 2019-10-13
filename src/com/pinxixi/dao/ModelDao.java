package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Model;
import com.pinxixi.vo.page.*;

public class ModelDao extends SuperOpr {

	public ModelDao() {
		cm = new ConnectionManager();
	}

	public boolean AddModel(Model model) {// 添加型号
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Model(SID,Size,Resolution,OS,RAM,ROM,FrontCamera,RearCamera,Battery,SOC,Thickness,SIMType,Details) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, model.getSID());
			psmt.setFloat(2, model.getSize());
			psmt.setString(3, model.getResolution());
			psmt.setString(4, model.getOS());
			psmt.setInt(5, model.getRAM());
			psmt.setInt(6, model.getROM());
			psmt.setString(7, model.getFrontCamera());
			psmt.setString(8, model.getRearCamera());
			psmt.setInt(9, model.getBattery());
			psmt.setString(10, model.getSOC());
			psmt.setFloat(11, model.getThickness());
			psmt.setString(12, model.getSIMType());
			psmt.setString(13, model.getDetails());
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

	public boolean DeletModel(List<String> MIDList) {// 删除型号
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Model WHERE MID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String MID : MIDList) {
				psmt.setString(1, MID);
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

	public boolean UpdateModel(Model model) {// 更新型号
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Model set SID=? ,Size=? ,Resolution=? ,OS=? ,RAM=? ,ROM=? ,FrontCamera=? ,RearCamera=? ,Battery=? ,SOC=? ,Thickness=? ,SIMType=? ,Details=?  WHERE MID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, model.getSID());
			psmt.setFloat(2, model.getSize());
			psmt.setString(3, model.getResolution());
			psmt.setString(4, model.getOS());
			psmt.setInt(5, model.getRAM());
			psmt.setInt(6, model.getROM());
			psmt.setString(7, model.getFrontCamera());
			psmt.setString(8, model.getRearCamera());
			psmt.setInt(9, model.getBattery());
			psmt.setString(10, model.getSOC());
			psmt.setFloat(11, model.getThickness());
			psmt.setString(12, model.getSIMType());
			psmt.setString(13, model.getDetails());
			psmt.setInt(14, model.getMID());
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

	public Model SelectModelOne(String MID) {// 根据MID查询型号
		Model model = new Model();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Model WHERE MID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, MID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				model.setMID(rs.getInt(1));
				model.setSID(rs.getInt(2));
				model.setSize(rs.getFloat(3));
				model.setResolution(rs.getString(4));
				model.setOS(rs.getString(5));
				model.setRAM(rs.getInt(6));
				model.setROM(rs.getInt(7));
				model.setFrontCamera(rs.getString(8));
				model.setRearCamera(rs.getString(9));
				model.setBattery(rs.getInt(10));
				model.setSOC(rs.getString(11));
				model.setThickness(rs.getFloat(12));
				model.setSIMType(rs.getString(13));
				model.setDetails(rs.getString(14));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public List<Model> SelectModelAll(String Concondition) {// 查询型号
		List<Model> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Model WHERE SID LIKE ? OR Size LIKE ? OR Resolution LIKE ? OR OS LIKE ? OR RAM LIKE ? OR ROM LIKE ? OR FrontCamera LIKE ? OR RearCamera LIKE ? OR Battery LIKE ? OR SOC LIKE ? OR Thickness LIKE ? OR SIMType LIKE ? OR Details LIKE ?";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 13; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Model model = new Model();
				model.setMID(rs.getInt(1));
				model.setSID(rs.getInt(2));
				model.setSize(rs.getFloat(3));
				model.setResolution(rs.getString(4));
				model.setOS(rs.getString(5));
				model.setRAM(rs.getInt(6));
				model.setROM(rs.getInt(7));
				model.setFrontCamera(rs.getString(8));
				model.setRearCamera(rs.getString(9));
				model.setBattery(rs.getInt(10));
				model.setSOC(rs.getString(11));
				model.setThickness(rs.getFloat(12));
				model.setSIMType(rs.getString(13));
				model.setDetails(rs.getString(14));
				list.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<ModelAndSname> SelectModelSname(String Concondition) {
		List<ModelAndSname> list= new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "Select Model.MID, Model.SID, Model.Size, Model.Resolution, Model.OS, Model.RAM, Model.ROM, Model.FrontCamera, Model.RearCamera, Model.Battery, Model.SOC, Model.Thickness, Model.SIMType, Model.Details, SName From Model,Series Where Model.SID=Series.SID AND ( Series.SName LIKE ? OR Model.OS LIKE ? OR Model.SOC LIKE ? OR Model.SIMType LIKE ? OR Model.Details LIKE ?) ";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 5; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				ModelAndSname modelAndSname=new ModelAndSname();
				Model model = new Model();
				model.setMID(rs.getInt(1));
				model.setSID(rs.getInt(2));
				model.setSize(rs.getFloat(3));
				model.setResolution(rs.getString(4));
				model.setOS(rs.getString(5));
				model.setRAM(rs.getInt(6));
				model.setROM(rs.getInt(7));
				model.setFrontCamera(rs.getString(8));
				model.setRearCamera(rs.getString(9));
				model.setBattery(rs.getInt(10));
				model.setSOC(rs.getString(11));
				model.setThickness(rs.getFloat(12));
				model.setSIMType(rs.getString(13));
				model.setDetails(rs.getString(14));
				modelAndSname.setModel(model);
				modelAndSname.setSName(rs.getString(15));
				list.add(modelAndSname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}