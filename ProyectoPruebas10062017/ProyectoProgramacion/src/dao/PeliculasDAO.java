package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.ConnectionBD;
import model.Peliculas;

public class PeliculasDAO implements IPeliculasDAO {
    ResultSet rs;
    Statement st;
    Connection con = ConnectionBD.getConnectionBD();

	@Override
	public boolean actualizar(Peliculas peliculas) {
		boolean success = false;
    	String sql = "UPDATE peliculas SET Codigo_Peliculas= ?, Titulo= ?, Autor= ? WHERE Codigo_Peliculas= ?";
    	try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, peliculas.getCodigo_Peliculas());
			pr.setString(2, peliculas.getTitulo());
			pr.setString(3, peliculas.getAutor());
			pr.setString(4, peliculas.getCodigo_Peliculas());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
			System.out.println("Error en Actualizar");
		}
    	return success;
	}
	
	public String[] filtrar(String campo, String np){
    	String sql = "SELECT * FROM peliculas WHERE " + campo +"= '"+np+"'";
    	String[] datos = new String[3];
    	try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				JOptionPane.showMessageDialog(null, "Se encontro el registro con exito");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro el registro indicado");
			}
		} catch (SQLException e) {
			System.out.println("Error en FILTRAR");
		}
    	return datos;
    }
	
	@Override
	public String[] getClientes(){
        String sql = "SELECT * FROM peliculas";
        String[] datos = new String[3];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR1");
        }
        return datos;
    }

	@Override
	public boolean nuevo(Peliculas peliculas) {
		boolean success = false;
    	String sql = "INSERT INTO peliculas VALUES (?, ? ,?)";
    	try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, peliculas.getCodigo_Peliculas());
			pr.setString(2, peliculas.getTitulo());
			pr.setString(3, peliculas.getAutor());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Has introducido un codigo igual. Intentalo de nuevo modificando el codigo");
		}
    	return success;
	}
	
	@Override
	public boolean eliminar(Peliculas peliculas) {
		boolean success = false;
		String sql = "DELETE FROM peliculas WHERE Codigo_Peliculas = ?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, peliculas.getCodigo_Peliculas());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
        	System.out.println("Error en el borrado de datos");
		}
		return success;		
	}

}