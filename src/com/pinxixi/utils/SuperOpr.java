package com.pinxixi.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SuperOpr {
	protected Connection con;
	protected PreparedStatement psmt;
	protected Statement statement;
	protected String sql;
	protected int row;
	protected ResultSet rs;
	protected ConnectionManager cm;
}
