package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Consultas {
	
	
	
	
	public Consultas() {
		
	}


	
	
	
	public static void insertar(String correo, String usuario, String clave) {
		
		 Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO DATOS(correo,usuario,clave) VALUES (?,?,?)");
			stm2.setString(1 , correo);
			stm2.setString(2 , usuario);
			stm2.setString(3 , clave);
			
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
	}
	
	
	
	
	
	
	
	public static void eliminar(String usuario) {
		
		 Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 
		 try {
				cn = conexion.conectar();
				PreparedStatement stm2 = cn.prepareStatement("DELETE FROM DATOS  WHERE usuario = ? ");
				
				stm2.setString(1 , usuario);
				
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
		}
		
	
		 
	
	
	public static boolean comprobarDatos(String usuarioo, String clavee) {
		
		Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 PreparedStatement pst =null;
		 boolean inicioCorrecto=false;
		 
		 try {
 			cn = conexion.conectar();
 			stm = cn.createStatement();
 			pst = cn.prepareStatement("SELECT * FROM DATOS WHERE USUARIO = ? AND CLAVE = ?");
 			pst.setString(1, usuarioo);
 			pst.setString(2, clavee);
 			rs =pst.executeQuery();
 			
 			while (rs.next()) {
 				
 				String usuario = rs.getString(2);
 				String clave = rs.getString(3);
 				
 				if(usuario.equals(usuarioo) && clave.equals(clavee)) {
 					
	    				inicioCorrecto=true;
	    				break;
 				}
 			}
 		} catch (SQLException i) {
 			i.printStackTrace();
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
		 return inicioCorrecto;
	}
	
	
	
public static boolean comprobarReg(String usuarioo) {
		Conexion conexion = new Conexion();
		 Connection cn = null;
		 Statement stm = null;
		 ResultSet rs = null;
		 PreparedStatement pst =null;
		 boolean regCorrecto=true;
		 
		 try {
 			cn = conexion.conectar();
 			stm = cn.createStatement();
 			pst = cn.prepareStatement("SELECT * FROM DATOS WHERE USUARIO = ? ");
 			pst.setString(1, usuarioo);
 			
 			
 			rs =pst.executeQuery();
 			
 			while (rs.next()) {
 				
 				String usuario = rs.getString(2);
 				
 				
 				if(usuario.equals(usuarioo) ) {
	    				regCorrecto=false;
	    				break;
 					
 				}	
 			}
 		} catch (SQLException i) {
 			i.printStackTrace();	
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
		  return regCorrecto;
		
	}
	

public static void paneladmin(JTable tablaintroducida) {
	
	
	
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	DefaultTableModel modelo = (DefaultTableModel) tablaintroducida.getModel();
	
	modelo.getDataVector().removeAllElements();
	
	try {
		cn = conexion.conectar();
		stm = cn.createStatement();
		rs = stm.executeQuery("SELECT * FROM DATOS");
		int x= 26;
		int y=131;
		int width= 443;
		int height= 16;
		
		while (rs.next()) {
			String correo = rs.getString(1);
			String usuario = rs.getString(2);
			String clave = rs.getString(3);
			
			tablaintroducida.setBounds(x, y, width, height);
			
			String[] fila = {correo,usuario, clave};
			modelo.addRow(fila);
			height+=16;

		}

	} catch (SQLException o) {
		o.printStackTrace();
		
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
	
}

}
