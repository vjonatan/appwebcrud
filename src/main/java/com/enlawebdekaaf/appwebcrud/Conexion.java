package com.enlawebdekaaf.appwebcrud;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLDataException;

public class Conexion {
	private final String servidor="jdbc:mysql://localhost/dbappwebcrud";
	private final String usuario="root";
	private final String contrasenia="123456";
	private Connection conexion=null;

	public Conexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexion=(Connection)DriverManager.getConnection(servidor, usuario, contrasenia);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("No se encontró la clase para la conexión de base de datos");
		}
		catch(MySQLDataException ex)
		{
			System.out.println("Error en MySqlDataException");
		}
		catch(SQLException ex)
		{
			System.out.println("Error en Driver Manager");
		}
		catch(Exception ex)
		{
			System.out.println("Ocurrió un error inesperado en la conexión");
		}
	}
	
	public void cerrarConexion()
	{
		if(conexion!=null)
		{
			try
			{
				conexion.close();
				conexion=null;
			}
			catch(Exception ex)
			{
				System.out.println("No se pudo cerrar la conexión");
			}
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}

}
