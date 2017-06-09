package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.PeliculasDAO;
import model.Peliculas;
import view.VistaPeliculas;

public class ControladorPeliculas implements ActionListener {
	private static VistaPeliculas vistaPeliculas;
	private static PeliculasDAO peliculasDAO;
	
	
	public ControladorPeliculas(VistaPeliculas vistaPeliculas, PeliculasDAO peliculasDAO) {
		this.vistaPeliculas = vistaPeliculas;
		this.peliculasDAO = peliculasDAO;
		actionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Limpiar")){
			limpiarCampos();
		}
		
		if (e.getActionCommand().equals("Nuevo")){
			if(validar()==true){
			vistaPeliculas.getjTable1().setModel(vistaPeliculas.getModelo());
			Peliculas peliculas = recogerPelicula();
			peliculasDAO.nuevo(peliculas);
			vistaPeliculas.getModelo().addRow(peliculasDAO.getClientes());
			}
		}
		
		if (e.getActionCommand().equals("Eliminar")){
			int fila = vistaPeliculas.getjTable1().getSelectedRow();
			vistaPeliculas.getjTable1().setModel(vistaPeliculas.getModelo());
			Peliculas peliculas = eliminarPeliculas();
			peliculasDAO.eliminar(peliculas);
			JOptionPane.showMessageDialog(null, "Datos ELIMINADOS");
			vistaPeliculas.getModelo().removeRow(fila);
		}
		
		if (e.getActionCommand().equals("Actualizar")){
			int row = vistaPeliculas.getjTable1().getSelectedRow();
			vistaPeliculas.getjTable1().setModel(vistaPeliculas.getModelo());
			Peliculas peliculas = actualizarPelicula();
			peliculasDAO.actualizar(peliculas);
			JOptionPane.showMessageDialog(null, "Datos ACTUALIZADOS");
			vistaPeliculas.getModelo().addRow(peliculasDAO.getClientes());
			vistaPeliculas.getModelo().removeRow(row);
		}
		
		if (e.getActionCommand().equals("Buscar")){
			String campo = vistaPeliculas.getCampo().getSelectedItem().toString();
			String np = vistaPeliculas.getjTextField4().getText();
			String[] datos = peliculasDAO.filtrar(campo, np);
			vistaPeliculas.getjTextField1().setText(datos[0]);
			vistaPeliculas.getjTextField2().setText(datos[1]);
			vistaPeliculas.getjTextField3().setText(datos[2]);
		}
		
		
	}
	
	public void actionListener(ActionListener escuchador){
		vistaPeliculas.getBtnLimpiar().addActionListener(escuchador);
		vistaPeliculas.getjButton1().addActionListener(escuchador);
		vistaPeliculas.getjButton2().addActionListener(escuchador);
		vistaPeliculas.getjButton3().addActionListener(escuchador);
		vistaPeliculas.getBtnBusquedaAvanzada().addActionListener(escuchador);
		vistaPeliculas.getjTextField4().addActionListener(escuchador);
	}
	
	private void limpiarCampos(){
		vistaPeliculas.getjTextField1().setText("");
		vistaPeliculas.getjTextField2().setText("");
		vistaPeliculas.getjTextField3().setText("");
	}
	
	public void seleccionarCampo(){
		int fila = vistaPeliculas.getjTable1().getSelectedRow();
		if(fila>=0){
			vistaPeliculas.getjTextField1().setText(vistaPeliculas.getjTable1().getValueAt(fila, 0).toString());
			vistaPeliculas.getjTextField2().setText(vistaPeliculas.getjTable1().getValueAt(fila, 1).toString());
			vistaPeliculas.getjTextField3().setText(vistaPeliculas.getjTable1().getValueAt(fila, 2).toString());
		}
	}
	
	private Peliculas recogerPelicula(){
		String codigo_Peliculas = vistaPeliculas.getjTextField1().getText();
		String titulo = vistaPeliculas.getjTextField2().getText();
		String autor = vistaPeliculas.getjTextField3().getText();
		Peliculas peliculas = new Peliculas(codigo_Peliculas, titulo, autor);
		return peliculas;
	}
	
	private Peliculas eliminarPeliculas(){
		int fila = vistaPeliculas.getjTable1().getSelectedRow();
		String codigo_Peliculas = (String) vistaPeliculas.getjTable1().getValueAt(fila, 0);
		Peliculas peliculas = new Peliculas(codigo_Peliculas, null, null);
		return peliculas;
	}
	
	private Peliculas actualizarPelicula(){
		String codigo_Peliculas = vistaPeliculas.getjTextField1().getText();
		String titulo = vistaPeliculas.getjTextField2().getText();
		String autor = vistaPeliculas.getjTextField3().getText();
		Peliculas peliculas = new Peliculas(codigo_Peliculas, titulo, autor);
		return peliculas;
	}
	
	public boolean validar() {
		if(vistaPeliculas.getjTextField1().getText().equals("") 
				|| vistaPeliculas.getjTextField2().getText().equals("") 
				|| vistaPeliculas.getjTextField3().getText().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
            return false;
        } else {
            return true;
        }
	}
	
	public static DefaultTableModel modelo(){
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
    	modelo.addColumn("Codigo Peliculas");
    	modelo.addColumn("Titulo");
    	modelo.addColumn("Autor");
    	return modelo;
	}
	
	public void llenarTabla(){
		
		vistaPeliculas.getModelo().addRow(peliculasDAO.getClientes());
		vistaPeliculas.getjTable1().setModel(vistaPeliculas.getModelo());
	}
}