package dao;

import model.Clientes;

public interface IClientesDAO {
	boolean actualizar(Clientes clientes);
	String[] filtrar(String campo, String np);
	String[] getClientes();
	boolean nuevo(Clientes clientes);
	boolean eliminar(Clientes clientes);
}
