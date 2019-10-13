package com.pinxixi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private String driver;
	private String url;
	private String userName;
	private String pwd;
	private Connection con;

	public ConnectionManager() {
		driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url = "jdbc:sqlserver://47.106.134.88:1433;DatabaseName=pxx;";
		userName = "sa";
		pwd = "root123456,";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		con = DriverManager.getConnection(url, userName, pwd);
		return con;
	}

	public void close() throws SQLException {
		con.close();
	}

	public static void main(String[] args) {
		ConnectionManager cm = new ConnectionManager();
		try {
			System.out.println(cm.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
