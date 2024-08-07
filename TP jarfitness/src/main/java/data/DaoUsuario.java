package data;
//orig
import entities.*;

import java.sql.*;
import java.util.LinkedList;

public class DaoUsuario {
	
	public LinkedList<Usuario> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Usuario> usuarios= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id_usuario,nombre,apellido,email,nombre_usuario from Usuario");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Usuario u=new Usuario();
					u.setIdUsuario(rs.getInt("id_usuario"));
					u.setNombre(rs.getString("nombre"));
					u.setApellido(rs.getString("apellido"));
					u.setEmail(rs.getString("email"));
					u.setNombreUsuario(rs.getString("nombre_usuario"));
					usuarios.add(u);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return usuarios;
	}
	
	public Usuario getByUser(Usuario usu) {
		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_usuario,nombre,apellido,email,nombre_usuario from Usuario where nombre_usuario=? and contraseña=?"
					);
			stmt.setString(1, usu.getNombreUsuario());
			stmt.setString(2, usu.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				u=new Usuario();
				u.setIdUsuario(rs.getInt("id_usuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setEmail(rs.getString("email"));
				u.setNombreUsuario(rs.getString("nombre_usuario"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return u;
	}
	

	 /*public void add(Usuario p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into Usuario(nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDocumento().getTipo());
			stmt.setString(4, p.getDocumento().getNro());
			stmt.setString(5, p.getEmail());
			stmt.setString(5, p.getPassword());
			stmt.setString(6, p.getTel());
			stmt.setBoolean(7, p.isHabilitado());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
            }
            
            DataRol dr = new DataRol();
            dr.setRolesDeUsuario(p);

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}*/
}