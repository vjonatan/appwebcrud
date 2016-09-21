package com.enlawebdekaaf.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlawebdekaaf.appwebcrud.Conexion;
import com.enlawebdekaaf.bean.Persona;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ServletActualizar
 */
public class ServletActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conexion conexion = new Conexion();
		
		try {
		
			String sql = "SELECT * FROM persona WHERE id=?";		
		
			PreparedStatement ps = (PreparedStatement)conexion.getConexion().prepareStatement(sql);
			
			ps.setString(1, request.getParameter("id"));
			
			ResultSet rs = ps.executeQuery();			
			
			Persona per = new Persona();
			
			while(rs.next()){

				per.setId(rs.getInt("id"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setDocumentoIdentidad(rs.getString("documentoIdentidad"));
				per.setCorreoElectronico(rs.getString("correoElectronico"));
				per.setFechaNacimiento(rs.getDate("fechaNacimiento"));
														
			}
			
			request.setAttribute("persona", per);
			
			request.getRequestDispatcher("actualizar.jsp").forward(request, response);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		finally{
			conexion.cerrarConexion();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fechaActualizacion;
		
		Conexion conexion = new Conexion();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			
			fechaActualizacion = dateFormat.format(new Date());
			
			String sql = "UPDATE persona SET nombre=?, apellido=?, documentoIdentidad=?, correoElectronico=?"+
						 ", fechaNacimiento=?, fechaActualizacion=? WHERE id=?";
		
			PreparedStatement ps = (PreparedStatement)conexion.getConexion().prepareStatement(sql);
			
			ps.setString(1, request.getParameter("txtNombre"));
			ps.setString(2, request.getParameter("txtApellido"));
			ps.setString(3, request.getParameter("txtDocumentoIdentidad"));
			ps.setString(4, request.getParameter("txtCorreoElectronico"));
			ps.setString(5, request.getParameter("txtFechaNacimiento"));
			ps.setString(6, fechaActualizacion);
			ps.setString(7, request.getParameter("txtId"));
			
			ps.executeUpdate();
			
			ps.close();			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}catch(Exception e) {
			
			System.out.println(e);
		
		}finally{
			
			conexion.cerrarConexion();
			
		}		
				
	}

}
