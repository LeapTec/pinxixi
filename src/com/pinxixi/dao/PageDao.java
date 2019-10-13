package com.pinxixi.dao;

import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Commodity;
import com.pinxixi.vo.Evaluation;
import com.pinxixi.vo.ShoppingCar;
import com.pinxixi.vo.Model;
import com.pinxixi.vo.page.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class PageDao extends SuperOpr {
	public PageDao() {
		cm = new ConnectionManager();
	}
	public List<Search> SearchPage(String Conditions,int BID,int SorType,int Sort){//获取搜索页面的系列展示
		List<Search> list = new ArrayList<>();
		sql="Select Series.SID,Series.SName,MIN(Commodity.Price),Model.SOC,Model.Size,MAX(Model.RAM),MAX(Model.ROM)"
				+" From Brand,Series,Model,Commodity"
				+" Where Brand.BID=Series.BID AND Series.SID=Model.SID AND Commodity.MID=Model.MID ";
		if((!Conditions.equals(""))&&BID<1) {
			sql=sql+" AND (Brand.BName='"+Conditions+"' OR Series.SName='"+Conditions+"' OR Model.OS='"+Conditions+"' )";
		}
		if(BID>=1) {
			sql=sql+" AND Brand.BID="+BID;
		}
		sql=sql+" GROUP BY Series.SID,Series.SName,Model.SOC,Model.Size";
		if(SorType==0) {
			sql=sql+" ORDER BY Series.SID";
		}else {
			sql=sql+" ORDER BY MIN(Commodity.Price)";
		}
		if(Sort==0) {
			sql=sql+" ASC";
		}else {
			sql=sql+" DESC";
		}
		try {
			con = cm.getConnection();
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Search search=new Search();
				search.setSID(rs.getInt(1));
				search.setSName(rs.getString(2));
				search.setLowestPrice(rs.getInt(3));
				search.setSummary(rs.getString(4)+" "+rs.getString(5)+" 寸高清屏幕  "+rs.getString(6)+"G RAM "+rs.getString(7)+"G ROM");
				list.add(search);
			}
			for(Search search: list) {
				sql="Select ComPicture.Path From Series,Model,Commodity,ComPicture "
						+" Where Series.SID=Model.SID AND Model.MID=Commodity.MID AND Commodity.CID=ComPicture.CID AND Series.SID="+search.getSID();
				psmt=con.prepareStatement(sql);
				rs=psmt.executeQuery();
				rs.next();
				search.setPath(rs.getString(1));
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public  List<Details> DetailsPage(int SID){
		List<Details> list= new ArrayList<>();
		try {
			sql="Select Commodity.CID,Series.SID,Series.SName,Model.MID,Commodity.Color,Commodity.Price,Commodity.Stock,Brand.BName,Model.Size,Model.Resolution,Model.OS,"
		        +"Model.RAM,Model.ROM,Model.FrontCamera,Model.RearCamera,Model.Battery,Model.SOC,Model.Thickness,Model.SIMType,Model.Details "
                +"From Series,Model,Commodity,Brand "
		        +"Where Series.BID=Brand.BID AND Series.SID=Model.SID AND Model.MID=Commodity.MID AND Series.SID=?";	
			con = cm.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, SID);
			rs=psmt.executeQuery();
			while(rs.next()) {
				Details details=new Details();
				details.setCID(rs.getInt(1));
				details.setSID(rs.getInt(2));
				details.setSName(rs.getString(3));
				details.setColor(rs.getString(5));
				details.setPrice(rs.getFloat(6));
				details.setStock(rs.getInt(7));
				details.setSpecification(rs.getInt(12)+"G  "+rs.getInt(13)+"G");
				details.setSeriesSummary(rs.getString(17)+" "+rs.getString(9)+" 寸高清屏幕  "+rs.getString(12)+"G RAM "+rs.getString(13)+"G ROM");
				Model model=new Model();
				model.setMID(rs.getInt(4));
				model.setSID(rs.getInt(2));
				model.setSize(rs.getFloat(9));
				model.setResolution(rs.getString(10));
				model.setOS(rs.getString(11));
				model.setRAM(rs.getInt(12));
				model.setROM(rs.getInt(13));
				model.setFrontCamera(rs.getString(14));
				model.setRearCamera(rs.getString(15));
				model.setBattery(rs.getInt(16));
				model.setSOC(rs.getString(17));
				model.setThickness(rs.getFloat(18));
				model.setSIMType(rs.getString(19));
				model.setDetails(rs.getString(20));
				details.setModel(model);
				list.add(details);
			}
			for(Details de:list) {
				sql="Select * From ComPicture Where ComPicture.CID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, de.getCID());
				rs=psmt.executeQuery();
				List<String> listString=new ArrayList<>();
				while (rs.next()) {
					listString.add(rs.getString(3));
				}
				de.setComPicture(listString);
			}
			for(Details de:list) {
				sql="Select Evaluation.EID,Evaluation.OID,Evaluation.PublishDate,Evaluation.EvaDetails"
					+" From Commodity,Orders,Evaluation"
					+" Where Commodity.CID=Orders.CID AND Orders.OID=Evaluation.OID AND Commodity.CID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, de.getCID());
				rs=psmt.executeQuery();
				List<Evaluation> listString=new ArrayList<>();
				while (rs.next()) {
					Evaluation evaluation=new Evaluation();
					evaluation.setEID(rs.getInt(1));
					evaluation.setOID(rs.getInt(2));
					evaluation.setPublishDate(rs.getString(3));
					evaluation.setEvaDetails(rs.getString(4));
					listString.add(evaluation);
				}
				de.setEvaluations(listString);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public List<Car> CarPage(String LoginName){
		List<Car> list = new ArrayList<>();
		try {
			sql="Select ShoppingCar.CID,ShoppingCar.Amount,Users.UID From ShoppingCar,Users Where ShoppingCar.UID=Users.UID AND Users.UName=?";
			con=cm.getConnection();
			psmt=con.prepareStatement(sql);
			psmt.setString(1, LoginName);
			rs=psmt.executeQuery();
			while (rs.next()) {
				Car car= new Car();
				ShoppingCar shoppingCar=new ShoppingCar();
				shoppingCar.setCID(rs.getInt(1));
				shoppingCar.setAmount(rs.getInt(2));
				shoppingCar.setUID(rs.getInt(3));
				car.setShoppingCar(shoppingCar);
				list.add(car);
			}
			for(Car car : list) {
				sql="Select * From Commodity Where Commodity.CID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, car.getShoppingCar().getCID());
				rs=psmt.executeQuery();
				Commodity commodity=new Commodity();
				while (rs.next()) {
					commodity.setCID(rs.getInt(1));
					commodity.setMID(rs.getInt(2));
					commodity.setColor(rs.getString(3));
					commodity.setPrice(rs.getFloat(4));
					commodity.setStock(rs.getInt(5));
				}
				car.setCommodity(commodity);
				sql="Select Brand.BName,Series.SName,Model.SIMType,Model.RAM,Model.ROM From Model,Brand,Series "+
				    " Where Brand.BID=Series.BID AND  Series.SID=Model.SID AND Model.MID=?";
				psmt=con.prepareStatement(sql);
				psmt.setInt(1, commodity.getMID());
				rs=psmt.executeQuery();
				while (rs.next()) {
					car.setBName(rs.getString(1));
					car.setSName(rs.getString(2));
					car.setSIMType(rs.getString(3));
					car.setStorage(rs.getString(4)+"G "+rs.getString(5)+"G");
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<UserOrders> GetMyOrders(int UID){
		List<UserOrders> list = new ArrayList<>();
		return list;
	}
	public String CIDtoCName(String CID){
		try {
			con=cm.getConnection();
		}catch (SQLException e) {}
		String t="";
		try {
			sql="Select Brand.BName,Series.SName,Model.SIMType,Model.RAM,Model.ROM From Commodity,Model,Series,Brand Where Commodity.MID=Model.MID AND Model.SID=Series.SID AND Series.BID=Brand.BID AND Commodity.CID=?";
			psmt=con.prepareStatement(sql);
			psmt.setString(1, CID);
			rs=psmt.executeQuery();
			while (rs.next()) {
				t=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"G+"+rs.getString(5)+"G";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
}