package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.JDBC.ConnectionFactory;
import com.hand.dao.FilmDao;
public class CheckFilm {
	private static FilmDao film = new FilmDao();
	
	Connection conn = null;
	
	public ResultSet checkfilm(){
		
		conn = ConnectionFactory.getinstance().getConnection();
		
		try {
			
			
			ResultSet rs = film.checkFilm(conn);
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(int id){
		try {
			film.deletefilm(conn, id);
		} catch (SQLException e) {
			
			
			e.printStackTrace();
			
			
		}
	}
}
