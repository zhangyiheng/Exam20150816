package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.JDBC.ConnectionFactory;
import com.hand.dao.Customer;

public class Check {
	private static Customer cs = new Customer();

	public boolean check(String name) {
		Connection conn = null;

		try {
			conn = ConnectionFactory.getinstance().getConnection();
			conn.setAutoCommit(false);

			ResultSet rs = cs.check(conn, name);
			
			while (rs.next()) {
				return true;
//				System.out.println(rs.getInt("customer_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

}

