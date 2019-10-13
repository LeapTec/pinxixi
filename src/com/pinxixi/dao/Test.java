package com.pinxixi.dao;

import java.sql.SQLException;

import com.pinxixi.utils.ConnectionManager;
import com.pinxixi.utils.SuperOpr;

/**
 * @author MrDemon 该类为通过以下两个java类实现连接数据库的测试类
 *         com.jincheng.utils.ConnectionManage.java
 *         com.jincheng.utils.SuperOpr.java
 */
public class Test extends SuperOpr {// 第一步: 继承SuperOpr
	public Test() {// 第二步: 为本类编写无参的构造方法
		cm = new ConnectionManager();// 第三步: 实例化ConnectionManager并赋值到父类的变量cm
	}

	public void test() {
		sql = "这里编写sql语句";
		try {
			con = cm.getConnection();// 获取数据库连接
			psmt = con.prepareStatement(sql);// 解析sql
			row = psmt.executeUpdate();// 执行增,删,改操作时使用该行语句更新数据库并返回成功条数
			rs = psmt.executeQuery();// 执行查询语句时使用该行语句获取结果集
			cm.close();// 对数据库操作结束后,记得执行该语句关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
