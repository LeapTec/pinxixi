package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Orders;

public class OrdersDao extends SuperOpr {

	public OrdersDao() {
		cm = new ConnectionManager();
	}

	public boolean AddOrders(Orders orders) {// 添加订单
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Orders(UID,AID,CID,Quantity,OrderTime,PayTime,DeliveryTime,Status,ExpressFee,TrackNum) VALUES(?,?,?,?,?,?,?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, orders.getUID());
			psmt.setInt(2, orders.getAID());
			psmt.setInt(3, orders.getCID());
			psmt.setInt(4, orders.getQuantity());
			psmt.setString(5, orders.getOrderTime());
			psmt.setString(6, orders.getPayTime());
			psmt.setString(7, orders.getDeliveryTime());
			psmt.setString(8, orders.getStatus());
			psmt.setFloat(9, orders.getExpressFee());
			psmt.setString(10, orders.getTrackNum());
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

	public boolean DeletOrders(List<String> OIDList) {// 删除订单
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Orders WHERE OID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String OID : OIDList) {
				psmt.setString(1, OID);
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

	public boolean UpdateOrders(Orders orders) {// 更新订单
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Orders set Quantity=?,OrderTime=?,PayTime=?,DeliveryTime=?,Status=?,ExpressFee=?,TrackNum=?  WHERE OID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, orders.getQuantity());
			psmt.setString(2, orders.getOrderTime());
			psmt.setString(3, orders.getPayTime());
			psmt.setString(4, orders.getDeliveryTime());
			psmt.setString(5, orders.getStatus());
			psmt.setFloat(6, orders.getExpressFee());
			psmt.setString(7, orders.getTrackNum());
			psmt.setInt(8, orders.getOID());
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
	
	public boolean UpdateOrders(Orders orders,Integer check) {// 审核订单
		boolean flag = false;
		boolean rollback = true;
		try {
			con = cm.getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			rollback = false;
		}
		if (rollback) {
			sql = "UPDATE Orders set Quantity=?,OrderTime=?,PayTime=?,DeliveryTime=?,Status=?,ExpressFee=?,TrackNum=?  WHERE OID=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setInt(1, orders.getQuantity());
				psmt.setString(2, orders.getOrderTime());
				psmt.setString(3, orders.getPayTime());
				psmt.setString(4, orders.getDeliveryTime());
				psmt.setString(5, orders.getStatus());
				psmt.setFloat(6, orders.getExpressFee());
				psmt.setString(7, orders.getTrackNum());
				psmt.setInt(8, orders.getOID());
				row = psmt.executeUpdate();
				if (row != 1) {
					throw new SQLException();
				}
				rollback = false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (!rollback) {// false
				// 修改状态成功
				if (check == 1) {
					// 审核通过,删除评论
					sql = "DELETE FROM Evaluation WHERE OID = ?";
					try {
						psmt = con.prepareStatement(sql);
						psmt.setInt(1, orders.getOID());
						psmt.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
						rollback = true;
					}
				}
			}
			if (!rollback) {// false
				try {
					con.commit();
					flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
					rollback = true;
					flag = false;
				}
			}
		}
		if (rollback) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public Orders SelectOrdersOne(String OID) {// 根据OID查询订单
		Orders orders = new Orders();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Orders WHERE OID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, OID);
			rs = psmt.executeQuery();
			while (rs.next()) {
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
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public List<Orders> SelectOrdersAll(String Concondition) {// 查询订单
		List<Orders> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Orders WHERE UID LIKE ? OR Status LIKE ? ORDER BY OID DESC";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 2; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Orders orders = new Orders();
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
				list.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
