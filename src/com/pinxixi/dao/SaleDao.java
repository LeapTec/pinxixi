package com.pinxixi.dao;

import java.sql.SQLException;

import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;

public class SaleDao extends SuperOpr {

	public SaleDao() {
		cm = new ConnectionManager();
	}
	public double SelectSale(String BID,String  firstTime,String secondTime) {
		double sum=0;
		boolean flag1 = false,flag2 = false;
		try {
			con=cm.getConnection();
			sql="Select SUM(Commodity.Price*Orders.Quantity) From Orders,Commodity,Model,Series,Brand "
					+"Where Orders.Status != '已取消' AND Orders.CID=Commodity.CID AND Commodity.MID=Model.MID AND Model.SID=Series.SID AND Series.BID=Brand.BID ";
			if(!BID.equals("0")) {
				sql += " AND Brand.BID=?";
				flag1 = true;
			}
			if(firstTime != null && secondTime != null){
				sql += " AND Orders.PayTime Between ? And ?";
				flag2 = true;
			}
			psmt=con.prepareStatement(sql);
			if(flag1){
				psmt.setString(1, BID);
			}
			if(flag2){
				if(flag1){
					psmt.setString(2, firstTime);
					psmt.setString(3, secondTime);
				}else{
					psmt.setString(1, firstTime);
					psmt.setString(2, secondTime);
				}
			}
			rs=psmt.executeQuery();
			while (rs.next()) {
				sum = rs.getDouble(1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
