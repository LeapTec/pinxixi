package com.pinxixi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;
import com.pinxixi.vo.Evaluation;

public class EvaluationDao extends SuperOpr {

	public EvaluationDao() {
		cm = new ConnectionManager();
	}

	public boolean AddEvaluation(Evaluation evaluation) {// 添加系列
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "INSERT INTO Evaluation(OID,PublishDate,EvaDetails) VALUES(?,?,?)";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, evaluation.getOID());
			psmt.setString(2, evaluation.getPublishDate());
			psmt.setString(3, evaluation.getEvaDetails());
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

	public boolean DeletEvaluation(List<String> EIDList) {// 删除系列
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "DELETE FROM Evaluation WHERE EID = ?";
			con.setAutoCommit(false);
			psmt = con.prepareStatement(sql);
			for (String EID : EIDList) {
				psmt.setString(1, EID);
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

	public boolean UpdateEvaluation(Evaluation evaluation) {// 更新系列信息
		boolean flag = false;
		try {
			con = cm.getConnection();
			sql = "UPDATE Evaluation set OID=? ,PublishDate=? ,EvaDetails=? WHERE EID=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, evaluation.getOID());
			psmt.setString(2, evaluation.getPublishDate());
			psmt.setString(3, evaluation.getEvaDetails());
			psmt.setInt(4, evaluation.getEID());
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

	public Evaluation SelectEvaluationOne(String EID) {// 根据主键EID查询
		Evaluation evaluation = new Evaluation();
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Evaluation WHERE EID=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, EID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				evaluation.setEID(rs.getInt(1));
				evaluation.setOID(rs.getInt(2));
				evaluation.setPublishDate(rs.getString(3));
				evaluation.setEvaDetails(rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evaluation;
	}

	public List<Evaluation> SelectEvaluationAll(String Concondition) {// 查询系列
		List<Evaluation> list = new ArrayList<>();
		Concondition = "%" + Concondition + "%";
		try {
			con = cm.getConnection();
			sql = "SELECT * FROM Evaluation WHERE OID LIKE ? OR PublishDate LIKE ? OR EvaDetails LIKE ?";
			psmt = con.prepareStatement(sql);
			for (int i = 1; i <= 3; i++) {
				psmt.setString(i, Concondition);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				Evaluation evaluation = new Evaluation();
				evaluation.setEID(rs.getInt(1));
				evaluation.setOID(rs.getInt(2));
				evaluation.setPublishDate(rs.getString(3));
				evaluation.setEvaDetails(rs.getString(4));
				list.add(evaluation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
