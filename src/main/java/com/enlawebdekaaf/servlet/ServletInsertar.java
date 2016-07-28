package com.enlawebdekaaf.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlawebdekaaf.appwebcrud.Conexion;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ServletInsertar
 */
public class ServletInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("insertar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fechaRegistro;
		String fechaActualizacion;
		
		Conexion conexion = new Conexion();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			
			fechaRegistro = dateFormat.format(new Date());
			fechaActualizacion = fechaRegistro;
			
			String sql = "insert into persona(nombre, apellido, documentoIdentidad, correoElectronico, fechaNacimiento, fechaRegistro, fechaActualizacion) "+
							"values (?, ?, ?, ?, ?, ?, ?)";
		
			PreparedStatement ps = (PreparedStatement)conexion.getConexion().prepareStatement(sql);
			
			ps.setString(1, request.getParameter("txtNombre"));
			ps.setString(2, request.getParameter("txtApellido"));
			ps.setString(3, request.getParameter("txtDocumentoIdentidad"));
			ps.setString(4, request.getParameter("txtCorreoElectronico"));
			ps.setString(5, request.getParameter("txtFechaNacimiento"));
			ps.setString(6, fechaRegistro);
			ps.setString(7, fechaActualizacion);
			
			ps.execute();
			
			ps.close();
			
			request.setAttribute("mensaje", "Registro insertardo");
			
			request.getRequestDispatcher("insertar.jsp").forward(request, response);
		
		}catch(Exception e) {
			
			System.out.println(e);
		
		}finally{
			
			conexion.cerrarConexion();
			
		}
		
	}

}
