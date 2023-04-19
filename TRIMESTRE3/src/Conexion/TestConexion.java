package Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM DATOS");
			
			while (rs.next()) {
				String correo = rs.getString(1);
				String usuario = rs.getString(2);
				String clave = rs.getString(3);
				
				
				System.out.println(correo + " - " + usuario + " - " + clave );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
			
		
		
		finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO DATOS(correo,usuario,clave) VALUES (?,?,?)");
			stm2.setString(1 , "12345@");
			stm2.setString(2 , "xxxx");
			stm2.setString(3 , "12345");
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
//		try {
//			cn = conexion.conectar();
//			PreparedStatement stm2 = cn.prepareStatement("UPDATE DATOS SET Nombre = ?  WHERE DNI = ?");
//			stm2.setString(1 , "Pepe");
//			stm2.setString(2 , "12345h");
//			
//			
//			stm2.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		} finally {
//			try {
//				if (rs!= null) {
//					rs.close();
//				}
//				
//				if (stm != null) {
//					stm.close();
//				}
//				
//				if (cn != null) {
//					cn.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
		
//		try {
//			cn = conexion.conectar();
//			PreparedStatement stm2 = cn.prepareStatement("DELETE FROM DATOS  WHERE Correo = ?");
//			stm2.setString(1 , "12345h");
//			
//			
//			stm2.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		} 
//		finally {
//			try {
//				if (rs!= null) {
//					rs.close();
//				}
//				
//				if (stm != null) {
//					stm.close();
//				}
//				
//				if (cn != null) {
//					cn.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
	}
}