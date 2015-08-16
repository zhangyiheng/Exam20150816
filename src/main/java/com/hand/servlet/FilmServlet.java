package com.hand.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.service.CheckFilm;

public class FilmServlet extends HttpServlet {
	private CheckFilm cf = new CheckFilm();
	/**
	 * Constructor of the object.
	 */
	public FilmServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String forward = null;
		ResultSet rs = cf.checkfilm();
//		Collection<ResultSet> col= new ArrayList<ResultSet>();
//		try {
//			while(rs.next()){
//				
//					try {
//						System.out.print(rs.getInt("film_id")+" ");
//						System.out.print(rs.getString("title")+" ");
//						System.out.print(rs.getString("description")+" ");
//						System.out.print(rs.getString("name"));
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println();
//					
//				}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		HttpSession session = request.getSession();
		session.setAttribute("result", rs);
		
		
		request.setAttribute("msg", "電影");
		forward = "film.jsp";
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
