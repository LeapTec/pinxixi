package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pinxixi.vo.Address;
import com.pinxixi.vo.Commodity;
import com.pinxixi.vo.Model;
import com.pinxixi.vo.Orders;
import com.pinxixi.vo.page.UserOrders;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;

public class UserOrdersDao extends SuperOpr {
	public UserOrdersDao() {
		cm = new ConnectionManager();
	}
	public List<UserOrders> UserOrders(int UID) {
		List<UserOrders> list = new ArrayList<>();
		try {
			con = cm.getConnection();
			sql="Select * From Orders Where Orders.UID=?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, UID);
			rs=psmt.executeQuery();
			while (rs.next()) {
				UserOrders userOrders = new UserOrders();
				Orders orders =new Orders();
				orders.setOID(rs.getInt(1));
				orders.setUID(rs.getInt(2));
				orders.setAID(rs.getInt(3));
				orders.setCID(rs.getInt(4));
				orders.setQuantity(rs.getInt(5));
				orders.setOrderTime(rs.getString(6));
				orders.setPayTime(rs.getString(7));
				orders.setDeliveryTime(rs.getString(8));
				orders.setStatus(rs.getString(9));
				orders.setExpressFee(rs.getFloat(10));
				orders.setTrackNum(rs.getString(11));
				userOrders.setOrders(orders);
				list.add(userOrders);
			}
			for(UserOrders userOrders: list) {
				sql="Select * From Address Where Address.AID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getAID());
				rs=psmt.executeQuery();
				Address address = new Address();
				while (rs.next()) {
					address.setAID(rs.getInt(1));
					address.setUID(rs.getInt(2));
					address.setAName(rs.getString(3));
					address.setPhone(rs.getString(4));
					address.setArea(rs.getString(5));
					address.setAddress(rs.getString(6));
				}
				userOrders.setAddress(address);
				sql="Select * From Commodity Where Commodity.CID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getCID());
				rs=psmt.executeQuery();
				Commodity commodity = new Commodity();
				while (rs.next()) {
					commodity.setCID(rs.getInt(1));
					commodity.setMID(rs.getInt(2));
					commodity.setColor(rs.getString(3));
					commodity.setPrice(rs.getFloat(4));
					commodity.setStock(rs.getInt(5));
				}
				userOrders.setCommodity(commodity);
				sql="Select * From Model Where Model.MID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getCommodity().getMID());
				rs=psmt.executeQuery();
				Model model =new Model();
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
				userOrders.setModel(model);
				int evaluationStatus;
				sql="Select * From Evaluation Where Evaluation.OID=?";
				psmt= con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getOID());
				rs=psmt.executeQuery();
				if(rs.next()) {
					evaluationStatus=1;
				}else {
					evaluationStatus=0;
				}
				userOrders.setEvaluationStatus(evaluationStatus);
				sql="Select Series.SName,Brand.BName " + 
						" From Commodity,Model,Series,Brand " + 
						" WHere Commodity.MID=Model.MID AND Model.SID=Series.SID AND Series.BID=Brand.BID AND Commodity.CID="+userOrders.getOrders().getCID();
				psmt=con.prepareStatement(sql);
				String sName=null,bName = null;
				rs=psmt.executeQuery();
				while (rs.next()) {
					sName=rs.getString(1);
					bName=rs.getString(2);
				}
				userOrders.setBName(bName);
				userOrders.setSName(sName);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public List<UserOrders> BackUserOrders() {
		List<UserOrders> list = new ArrayList<>();
		try {
			con = cm.getConnection();
			sql="Select * From Orders ";
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while (rs.next()) {
				UserOrders userOrders = new UserOrders();
				Orders orders =new Orders();
				orders.setOID(rs.getInt(1));
				orders.setUID(rs.getInt(2));
				orders.setAID(rs.getInt(3));
				orders.setCID(rs.getInt(4));
				orders.setQuantity(rs.getInt(5));
				orders.setOrderTime(rs.getString(6));
				orders.setPayTime(rs.getString(7));
				orders.setDeliveryTime(rs.getString(8));
				orders.setStatus(rs.getString(9));
				orders.setExpressFee(rs.getFloat(10));
				orders.setTrackNum(rs.getString(11));
				userOrders.setOrders(orders);
				list.add(userOrders);
			}
			for(UserOrders userOrders: list) {
				sql="Select * From Address Where Address.AID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getAID());
				rs=psmt.executeQuery();
				Address address = new Address();
				while (rs.next()) {
					address.setAID(rs.getInt(1));
					address.setUID(rs.getInt(2));
					address.setAName(rs.getString(3));
					address.setPhone(rs.getString(4));
					address.setArea(rs.getString(5));
					address.setAddress(rs.getString(6));
				}
				userOrders.setAddress(address);
				sql="Select * From Commodity Where Commodity.CID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getCID());
				rs=psmt.executeQuery();
				Commodity commodity = new Commodity();
				while (rs.next()) {
					commodity.setCID(rs.getInt(1));
					commodity.setMID(rs.getInt(2));
					commodity.setColor(rs.getString(3));
					commodity.setPrice(rs.getFloat(4));
					commodity.setStock(rs.getInt(5));
				}
				userOrders.setCommodity(commodity);
				sql="Select * From Model Where Model.MID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getCommodity().getMID());
				rs=psmt.executeQuery();
				Model model =new Model();
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
				userOrders.setModel(model);
				int evaluationStatus;
				sql="Select * From Evaluation Where Evaluation.OID=?";
				psmt= con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getOID());
				rs=psmt.executeQuery();
				if(rs.next()) {
					evaluationStatus=1;
				}else {
					evaluationStatus=0;
				}
				userOrders.setEvaluationStatus(evaluationStatus);
				sql="Select Series.SName,Brand.BName " + 
						" From Commodity,Model,Series,Brand " + 
						" WHere Commodity.MID=Model.MID AND Model.SID=Series.SID AND Series.BID=Brand.BID AND Commodity.CID="+userOrders.getOrders().getCID();
				psmt=con.prepareStatement(sql);
				String sName=null,bName = null;
				rs=psmt.executeQuery();
				while (rs.next()) {
					sName=rs.getString(1);
					bName=rs.getString(2);
				}
				userOrders.setBName(bName);
				userOrders.setSName(sName);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public List<UserOrders> BackSelectUserOrders(String conditions) {
		List<UserOrders> list = new ArrayList<>();
		conditions = "%"+conditions+"%";
		try {
			con = cm.getConnection();
			sql="Select * From Orders Where Orders.OID LIKE '"+conditions+"' OR Orders.Status LIKE '"+conditions+"'";
			psmt=con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while (rs.next()) {
				UserOrders userOrders = new UserOrders();
				Orders orders =new Orders();
				orders.setOID(rs.getInt(1));
				orders.setUID(rs.getInt(2));
				orders.setAID(rs.getInt(3));
				orders.setCID(rs.getInt(4));
				orders.setQuantity(rs.getInt(5));
				orders.setOrderTime(rs.getString(6));
				orders.setPayTime(rs.getString(7));
				orders.setDeliveryTime(rs.getString(8));
				orders.setStatus(rs.getString(9));
				orders.setExpressFee(rs.getFloat(10));
				orders.setTrackNum(rs.getString(11));
				userOrders.setOrders(orders);
				list.add(userOrders);
			}
			for(UserOrders userOrders: list) {
				sql="Select * From Address Where Address.AID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getAID());
				rs=psmt.executeQuery();
				Address address = new Address();
				while (rs.next()) {
					address.setAID(rs.getInt(1));
					address.setUID(rs.getInt(2));
					address.setAName(rs.getString(3));
					address.setPhone(rs.getString(4));
					address.setArea(rs.getString(5));
					address.setAddress(rs.getString(6));
				}
				userOrders.setAddress(address);
				sql="Select * From Commodity Where Commodity.CID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getCID());
				rs=psmt.executeQuery();
				Commodity commodity = new Commodity();
				while (rs.next()) {
					commodity.setCID(rs.getInt(1));
					commodity.setMID(rs.getInt(2));
					commodity.setColor(rs.getString(3));
					commodity.setPrice(rs.getFloat(4));
					commodity.setStock(rs.getInt(5));
				}
				userOrders.setCommodity(commodity);
				sql="Select * From Model Where Model.MID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getCommodity().getMID());
				rs=psmt.executeQuery();
				Model model =new Model();
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
				userOrders.setModel(model);
				int evaluationStatus;
				sql="Select * From Evaluation Where Evaluation.OID=?";
				psmt= con.prepareStatement(sql);
				psmt.setInt(1, userOrders.getOrders().getOID());
				rs=psmt.executeQuery();
				if(rs.next()) {
					evaluationStatus=1;
				}else {
					evaluationStatus=0;
				}
				userOrders.setEvaluationStatus(evaluationStatus);
				sql="Select Series.SName,Brand.BName " + 
						" From Commodity,Model,Series,Brand " + 
						" WHere Commodity.MID=Model.MID AND Model.SID=Series.SID AND Series.BID=Brand.BID AND Commodity.CID="+userOrders.getOrders().getCID();
				psmt=con.prepareStatement(sql);
				String sName=null,bName = null;
				rs=psmt.executeQuery();
				while (rs.next()) {
					sName=rs.getString(1);
					bName=rs.getString(2);
				}
				userOrders.setBName(bName);
				userOrders.setSName(sName);
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
