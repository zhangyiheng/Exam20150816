package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDao {
	public ResultSet checkFilm(Connection conn) throws SQLException {
		String sql = "select film_id,title,description,name from film,language where film.language_id=language.language_id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("执行" + ps.execute());
		return rs;
	}
	public void deletefilm(Connection conn,int id) throws SQLException{
		String sql="delete from film where film_id="+id;
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("执行" + ps.execute());
	}
}
