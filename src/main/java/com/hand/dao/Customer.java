package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	public ResultSet check(Connection conn, String name) throws SQLException {
		String sql = "select * from customer where first_name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		System.out.println("执行" + ps.execute());
		return rs;
	}
}
