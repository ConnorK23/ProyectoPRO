package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.ConnectionBD;
import model.Prestamos;

public class PrestamosDAO implements IPrestamosDAO {
    ResultSet rs;
    Statement st;
    Connection con = ConnectionBD.getConnectionBD();
    
	@Override
	public boolean actualizar(Prestamos prestamos) {
			boolean success = false;
	    	String sql = "UPDATE prestamos SET DNI= ?, Nombre= ?, Telefono= ?, Pelicula= ?, Fecha_prestamo= ?, Fecha_devolucion= ?  WHERE DNI= ? AND Pelicula= ?";
	    	try {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, prestamos.getDNI());
				pr.setString(2, prestamos.getNombre());
				pr.setString(3, prestamos.getTelefono());
				pr.setString(4, prestamos.getPelicula());
				pr.setString(5, prestamos.getFecha_prestamo());
				pr.setString(6, prestamos.getFecha_devolucion());
				pr.setString(7, prestamos.getDNI());
				pr.setString(8, prestamos.getPelicula());
				int rows = pr.executeUpdate();
				if(rows != 0)
					success = true;
			} catch (SQLException e) {
				System.out.println("Error en Actualizar");
			}
	    	return success;
		}

	@Override
	public String[] getPrestamos() {
		String sql = "SELECT * FROM prestamos";
        String[] datos = new String[6];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR1");
        }
        return datos;
	}

	@Override
	public boolean nuevo(Prestamos prestamos) {
		boolean success = false;
    	String sql = "INSERT INTO prestamos VALUES (?, ?, ?, ?, ?, ?)";
    	try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, prestamos.getDNI());
			pr.setString(2, prestamos.getNombre());
			pr.setString(3, prestamos.getTelefono());
			pr.setString(4, prestamos.getPelicula());
			pr.setString(5, prestamos.getFecha_prestamo());
			pr.setString(6, prestamos.getFecha_devolucion());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Has introducido un codigo igual. Intentalo de nuevo modificando el codigo");
		}
    	return success;
	}

	@Override
	public boolean eliminar(Prestamos prestamos) {
		boolean success = false;
		String sql = "DELETE FROM prestamos WHERE DNI = ? AND Pelicula = ?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, prestamos.getDNI());
			pr.setString(2, prestamos.getPelicula());
			int rows = pr.executeUpdate();
			if(rows != 0)
				success = true;
		} catch (SQLException e) {
        	System.out.println("Error en el borrado de datos");
		}
		return success;	
	}

}
