package model;

public class Clientes {
	private String DNI;
	private String Nombre;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	public Clientes(String dNI, String nombre, String apellidos, String direccion, String telefono) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	@Override
	public String toString() {
		return "Clientes [DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion
				+ ", Telefono=" + Telefono + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}
}
