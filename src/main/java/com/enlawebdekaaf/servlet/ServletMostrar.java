package com.enlawebdekaaf.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enlawebdekaaf.appwebcrud.Conexion;
import com.enlawebdekaaf.bean.Persona;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ServletMostrar
 */
public class ServletMostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMostrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conexion conexion = new Conexion();
		try {
		
			String sql = "SELECT * FROM persona";		
		
			PreparedStatement ps = (PreparedStatement)conexion.getConexion().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Persona> listaPersona = new ArrayList<Persona>();
			
			while(rs.next()){
				
				Persona per = new Persona();
				
				per.setId(rs.getInt("id"));
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setDocumentoIdentidad(rs.getString("documentoIdentidad"));
				per.setCorreoElectronico(rs.getString("correoElectronico"));
				per.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				per.setFechaRegistro(rs.getDate("fechaRegistro"));
				per.setFechaActualizacion(rs.getDate("fechaActualizacion"));
				
				listaPersona.add(per);								
			}
			
			request.setAttribute("lista", listaPersona);
			
			request.getRequestDispatcher("mostrar.jsp").forward(request, response);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
