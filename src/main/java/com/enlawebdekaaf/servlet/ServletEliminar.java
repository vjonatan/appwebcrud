package com.enlawebdekaaf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlawebdekaaf.appwebcrud.Conexion;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ServletEliminar
 */
public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conexion conexion = new Conexion();		
		
		try {
			
			String sql = "delete from persona where id=?";
		
			PreparedStatement ps = (PreparedStatement)conexion.getConexion().prepareStatement(sql);
			
			ps.setString(1, request.getParameter("id"));
			
			ps.execute();
			
			ps.close();
				
			request.getRequestDispatcher("eliminar.jsp").forward(request, response);
			
		}catch(Exception e) {
			
			System.out.println(e);
		
		}finally{
			
			conexion.cerrarConexion();
			
		}			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
