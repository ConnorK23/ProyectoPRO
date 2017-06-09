package model;

public class Prestamos {
	private String DNI;
	private String Nombre;
	private String Telefono;
	private String Pelicula;
	private String Fecha_prestamo;
	private String Fecha_devolucion;
	public Prestamos(String dNI, String nombre, String telefono, String pelicula, String fecha_prestamo,
			String fecha_devolucion) {
		super();
		DNI = dNI;
		Nombre = nombre;
		Telefono = telefono;
		Pelicula = pelicula;
		Fecha_prestamo = fecha_prestamo;
		Fecha_devolucion = fecha_devolucion;
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
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getPelicula() {
		return Pelicula;
	}
	public void setPelicula(String pelicula) {
		Pelicula = pelicula;
	}
	public String getFecha_prestamo() {
		return Fecha_prestamo;
	}
	public void setFecha_prestamo(String fecha_prestamo) {
		Fecha_prestamo = fecha_prestamo;
	}
	public String getFecha_devolucion() {
		return Fecha_devolucion;
	}
	public void setFecha_devolucion(String fecha_devolucion) {
		Fecha_devolucion = fecha_devolucion;
	}
	@Override
	public String toString() {
		return "Prestamos [DNI=" + DNI + ", Nombre=" + Nombre + ", Telefono=" + Telefono + ", Pelicula=" + Pelicula
				+ ", Fecha_prestamo=" + Fecha_prestamo + ", Fecha_devolucion=" + Fecha_devolucion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Pelicula == null) ? 0 : Pelicula.hashCode());
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
		Prestamos other = (Prestamos) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Pelicula == null) {
			if (other.Pelicula != null)
				return false;
		} else if (!Pelicula.equals(other.Pelicula))
			return false;
		return true;
	}
}
