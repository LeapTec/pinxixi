package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Commodity;

public class CommodityDao extends SuperOpr {

	public CommodityDao() {
		cm = new ConnectionManager();
	}

	public boolean AddCommodity(Commodity commodity) {// 添加商品
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Commodity(MID,Color,Price,Stock) VALUES(?,?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, commodity.getMID());
			psmt.setString(2, commodity.getColor());
			psmt.setFloat(3, commodity.getPrice());
			psmt.setInt(4, commodity.getStock());
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
	
	public boolean AddCommodity(Commodity c,String[][] result){
		boolean flag = false;
		boolean rollback = true;
		Integer CID = 0;
		try {
			con = cm.getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			rollback = false;
		}
		if (rollback) {
			sql = "INSERT INTO Commodity(MID,Color,Price,Stock) VALUES(?,?,?,?)";
			try {
				psmt = con.prepareStatement(sql, this.statement.RETURN_GENERATED_KEYS);
				psmt.setInt(1, c.getMID());
				psmt.setString(2, c.getColor());
				psmt.setFloat(3, c.getPrice());
				psmt.setInt(4, c.getStock());
				row = psmt.executeUpdate();
				if (row == 1) {
					rs = psmt.getGeneratedKeys();
					if (rs.next()) {
						CID = rs.getInt(1);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (CID > 0) {
				sql = "INSERT INTO ComPicture(CID,Path) VALUES(?,?)";
				try {
					psmt = con.prepareStatement(sql);
					for (String[] path : result) {
						psmt.setInt(1, CID);
						psmt.setString(2, path[1]);
						row = psmt.executeUpdate();
						if (row != 1) {
							throw new SQLException();
						}
					}
					con.commit();
					flag = true;
					rollback = false;
				} catch (SQLException e) {
					e.printStackTrace();
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

	public boolean DeletCommodity(List<Integer> CIDList) {// 删除商品
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Commodity WHERE CID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (Integer CID : CIDList) {
				psmt.setInt(1, CID);
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

	public boolean UpdateCommodity(Commodity commodity) {// 更新商品信息
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Commodity set MID=? ,Color=? ,Price=?,Stock=? WHERE CID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, commodity.getMID());
			psmt.setString(2, commodity.getColor());
			psmt.setFloat(3, commodity.getPrice());
			psmt.setInt(4, commodity.getStock());
			psmt.setInt(5, commodity.getCID());
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

	public Commodity SelectCommodityOne(String CID) {// 根据主键CID查询
		Commodity commodity = new Commodity();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Commodity WHERE CID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, CID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				commodity.setCID(rs.getInt(1));
				commodity.setMID(rs.getInt(2));
				commodity.setColor(rs.getString(3));
				commodity.setPrice(rs.getFloat(4));
				commodity.setStock(rs.getInt(5));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commodity;
	}

	public List<Commodity> SelectCommodityAll(String Concondition) {// 查询商品
		List<Commodity> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Commodity WHERE MID LIKE ? OR Color LIKE ?";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 2; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setCID(rs.getInt(1));
				commodity.setMID(rs.getInt(2));
				commodity.setColor(rs.getString(3));
				commodity.setPrice(rs.getFloat(4));
				commodity.setStock(rs.getInt(5));
				list.add(commodity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
