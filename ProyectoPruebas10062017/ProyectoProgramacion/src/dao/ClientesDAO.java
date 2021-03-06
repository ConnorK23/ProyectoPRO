package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;

import model.Clientes;
import model.ConnectionBD;

public class ClientesDAO implements IClientesDAO {
    ResultSet rs;
    Statement st;
    Connection con = ConnectionBD.getConnectionBD();

	@Override
	public boolean actualizar(Clientes clientes) {
		boolean success = false;
    	String sql = "UPDATE clientes SET DNI= ?, Nombre= ?, Apellidos= ?, Direccion= ?, Telefono= ? WHERE DNI= ?";
    	try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, clientes.getDNI());
			pr.setString(2, clientes.getNombre());
			pr.setString(3, clientes.getApellidos());
			pr.setString(4, clientes.getDireccion());
			pr.setString(5, clientes.getTelefono());
			pr.setString(6, clientes.getDNI());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
			System.out.println("Error en Actualizar");
		}
    	//llenarTabla();
    	return success;
	}
	
	public String[] filtrar(String campo, String np){
    	String sql = "SELECT * FROM clientes WHERE "+campo+"= '"+np+"'";
    	String[] datos = new String[5];
    	try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
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
        String sql = "SELECT * FROM clientes";
        String[] datos = new String[5];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR1");
        }
        return datos;
    }

	@Override
	public boolean nuevo(Clientes clientes) {
		boolean success = false;
    	String sql = "INSERT INTO clientes VALUES (?, ? ,?, ?, ?)";
    	try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, clientes.getDNI());
			pr.setString(2, clientes.getNombre());
			pr.setString(3, clientes.getApellidos());
			pr.setString(4, clientes.getDireccion());
			pr.setString(5, clientes.getTelefono());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Has introducido un codigo igual. Intentalo de nuevo modificando el codigo");
		}
    	return success;
	}
	
	@Override
	public boolean eliminar(Clientes clientes) {
		boolean success = false;
		String sql = "DELETE FROM clientes WHERE DNI = ?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, clientes.getDNI());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
        	System.out.println("Error en el borrado de datos");
		}
		return success;		
	}

}
