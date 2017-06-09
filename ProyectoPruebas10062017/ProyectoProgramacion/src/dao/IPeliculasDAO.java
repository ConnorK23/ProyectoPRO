package dao;

import model.Peliculas;

public interface IPeliculasDAO {
	boolean actualizar(Peliculas peliculas);
	String[] filtrar(String campo, String np);
	String[] getClientes();
	boolean nuevo(Peliculas peliculas);
	boolean eliminar(Peliculas peliculas);
}
