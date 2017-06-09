package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.PrestamosDAO;
import model.Prestamos;
import view.VistaPrestamos;

public class ControladorPrestamos implements ActionListener {
	private static VistaPrestamos vistaPrestamos;
	private static PrestamosDAO prestamosDAO;
	
	
	public ControladorPrestamos(VistaPrestamos vistaPrestamos, PrestamosDAO prestamosDAO) {
		this.vistaPrestamos = vistaPrestamos;
		this.prestamosDAO = prestamosDAO;
		actionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpiar")){
			limpiarCampos();
		}
		
		if (e.getActionCommand().equals("Realizar Prestamo")){
			if(validar()==true){
			vistaPrestamos.getjTable1().setModel(vistaPrestamos.getModelo());
			Prestamos prestamos = recogerPrestamos();
			prestamosDAO.nuevo(prestamos);
			vistaPrestamos.getModelo().addRow(prestamosDAO.getPrestamos());
			}
		}
		
		if (e.getActionCommand().equals("Borrar Prestamo")){
			int fila = vistaPrestamos.getjTable1().getSelectedRow();
			vistaPrestamos.getjTable1().setModel(vistaPrestamos.getModelo());
			Prestamos prestamos = eliminarPrestamos();
			prestamosDAO.eliminar(prestamos);
			JOptionPane.showMessageDialog(null, "Datos ELIMINADOS");
			vistaPrestamos.getModelo().removeRow(fila);
		}
		
		if (e.getActionCommand().equals("Actualizar Prestamo")){
			int row = vistaPrestamos.getjTable1().getSelectedRow();
			vistaPrestamos.getjTable1().setModel(vistaPrestamos.getModelo());
			Prestamos prestamos = actualizarPrestamos();
			prestamosDAO.actualizar(prestamos);
			JOptionPane.showMessageDialog(null, "Datos ACTUALIZADOS");
			vistaPrestamos.getModelo().addRow(prestamosDAO.getPrestamos());
			vistaPrestamos.getModelo().removeRow(row);
		}
		
		/* if (e.getActionCommand().equals("Fecha")){
			String campo = vistaPrestamos.getCampo().getSelectedItem().toString();
			String np = vistaPrestamos.getjTextField4().getText();
			String[] datos = prestamosDAO.filtrar(campo, np);
			vistaPrestamos.getjTextField1().setText(datos[0]);
			vistaPrestamos.getjTextField2().setText(datos[1]);
			vistaPrestamos.getjTextField3().setText(datos[2]);
		} */
		
		
	}
	
	public void actionListener(ActionListener escuchador){
		vistaPrestamos.getBtnLimpiar().addActionListener(escuchador);
		vistaPrestamos.getjButton1().addActionListener(escuchador);
		vistaPrestamos.getjButton2().addActionListener(escuchador);
		vistaPrestamos.getjButton3().addActionListener(escuchador);
		//vistaPrestamos.getBtnFecha().addActionListener(escuchador);
	}
	
	private void limpiarCampos(){
		vistaPrestamos.getjTextField1().setText("");
		vistaPrestamos.getjTextField2().setText("");
		vistaPrestamos.getjTextField3().setText("");
		vistaPrestamos.getjTextField4().setText("");
		vistaPrestamos.getTextField().setText("");
	}
	
	public void seleccionarCampo(){
		int fila = vistaPrestamos.getjTable1().getSelectedRow();
		if(fila>=0){
			vistaPrestamos.getjTextField1().setText(vistaPrestamos.getjTable1().getValueAt(fila, 0).toString());
			vistaPrestamos.getjTextField2().setText(vistaPrestamos.getjTable1().getValueAt(fila, 1).toString());
			vistaPrestamos.getjTextField3().setText(vistaPrestamos.getjTable1().getValueAt(fila, 2).toString());
		}
	}
	
	private Prestamos recogerPrestamos(){
		String DNI = vistaPrestamos.getjTextField1().getText();
		String Nombre = vistaPrestamos.getjTextField2().getText();
		String Telefono = vistaPrestamos.getjTextField3().getText();
		String Pelicula = vistaPrestamos.getComboBox().getSelectedItem().toString();
		String Fecha_Prestamo = vistaPrestamos.getjTextField5().getText();
		String Fecha_Devolucion = vistaPrestamos.getTextField().getText();
		Prestamos prestamos = new Prestamos(DNI, Nombre, Telefono, Pelicula, Fecha_Prestamo, Fecha_Devolucion);
		return prestamos;
	}
	
	private Prestamos eliminarPrestamos(){
		int fila = vistaPrestamos.getjTable1().getSelectedRow();
		String DNI = (String) vistaPrestamos.getjTable1().getValueAt(fila, 0);
		String Pelicula = (String) vistaPrestamos.getjTable1().getValueAt(fila, 3);
		Prestamos prestamos = new Prestamos(DNI, null, null, Pelicula, null, null);
		return prestamos;
	}
	
	private Prestamos actualizarPrestamos(){
		String DNI = vistaPrestamos.getjTextField1().getText();
		String Nombre = vistaPrestamos.getjTextField2().getText();
		String Telefono = vistaPrestamos.getjTextField3().getText();
		String Pelicula = vistaPrestamos.getComboBox().toString();
		String Fecha_prestamo = vistaPrestamos.getjTextField5().getText();
		String Fecha_devolucion = vistaPrestamos.getTextField().getText();
		Prestamos prestamos = new Prestamos(DNI, Nombre, Telefono, Pelicula, Fecha_prestamo, Fecha_devolucion);
		return prestamos;
	}
	
	public boolean validar() {
		if(vistaPrestamos.getjTextField1().getText().equals("") 
				|| vistaPrestamos.getjTextField2().getText().equals("") 
				|| vistaPrestamos.getjTextField3().getText().equals("")
				|| vistaPrestamos.getjTextField5().getText().equals("")
				|| vistaPrestamos.getTextField().getText().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
            return false;
        } else {
            return true;
        }
	}
}