package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.ComPicture;

public class ComPictureDao extends SuperOpr {

	public ComPictureDao() {
		cm = new ConnectionManager();
	}

	public boolean AddComPicture(ComPicture comPicture) {// 添加商品图片
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO ComPicture(CID,Path) VALUES(?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, comPicture.getCID());
			psmt.setString(2, comPicture.getPath());
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

	public boolean DeletComPicture(List<String> CPIDList) {// 删除商品图片
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM ComPicture WHERE CPID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String CPID : CPIDList) {
				psmt.setString(1, CPID);
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

	public boolean UpdateComPicture(ComPicture comPicture) {// 更新商品图片
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE ComPicture set CID=? ,Path=? WHERE CPID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, comPicture.getCID());
			psmt.setString(2, comPicture.getPath());
			psmt.setInt(3, comPicture.getCPID());
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

	public ComPicture SelectComPictureOne(String CPID) {// 根据主键CPID查询
		ComPicture comPicture = new ComPicture();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM ComPicture WHERE CPID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, CPID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				comPicture.setCPID(rs.getInt(1));
				comPicture.setCID(rs.getInt(2));
				comPicture.setPath(rs.getString(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comPicture;
	}

	public List<ComPicture> SelectComPictureAll(String Concondition) {// 查询商品图片
		List<ComPicture> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM ComPicture WHERE CID LIKE ? ";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 1; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				ComPicture comPicture = new ComPicture();
				comPicture.setCPID(rs.getInt(1));
				comPicture.setCID(rs.getInt(2));
				comPicture.setPath(rs.getString(3));
				list.add(comPicture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ComPicture> SelectComPictureForCID(String CID) {// 查询商品图片,根据商品ID
		List<ComPicture> list = new ArrayList<>();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM ComPicture WHERE CID = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, CID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ComPicture comPicture = new ComPicture();
				comPicture.setCPID(rs.getInt(1));
				comPicture.setCID(rs.getInt(2));
				comPicture.setPath(rs.getString(3));
				list.add(comPicture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ComPicture> SelectComPictureForCPID(String[] CPID) {// 查询商品图片,根据CPID
		List<ComPicture> list = new ArrayList<ComPicture>();
		try {
			if (CPID != null && CPID.length > 0) {
				con = cm.getConnection();
				sql = "SELECT * FROM ComPicture WHERE CPID in (";
				for (int i = 0; i < CPID.length; i++) {
					if (i != 0) {
						sql += ",";
					}
					sql += "?";
				}
				sql += ")";
				psmt = con.prepareStatement(sql);
				for (int i = 1; i <= CPID.length; i++) {
					psmt.setString(i, CPID[i - 1]);
				}
				rs = psmt.executeQuery();
				while (rs.next()) {
					ComPicture comPicture = new ComPicture();
					comPicture.setCPID(rs.getInt(1));
					comPicture.setCID(rs.getInt(2));
					comPicture.setPath(rs.getString(3));
					list.add(comPicture);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean UpdateComPicture(Integer CID,String[] imgDelId, String[][] result){
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
			rollback = false;
			if (imgDelId != null && imgDelId.length > 0) {
				sql = "DELETE FROM ComPicture WHERE CPID = ?";
				try {
					psmt = con.prepareStatement(sql);
					for (String s : imgDelId) {
						psmt.setString(1, s);
						row = psmt.executeUpdate();
						if (row != 1) {
							throw new SQLException();
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
					rollback = true;
				}
			}
			if (!rollback) {// false
				if (result != null && result.length > 0) {
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
					} catch (SQLException e) {
						e.printStackTrace();
						rollback = true;
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
}
