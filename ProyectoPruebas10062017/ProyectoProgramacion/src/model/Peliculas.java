package model;

public class Peliculas {
	private String Codigo_Peliculas;
	private String Titulo;
	private String Autor;
	public Peliculas(String codigo_Peliculas, String titulo, String autor) {
		super();
		Codigo_Peliculas = codigo_Peliculas;
		Titulo = titulo;
		Autor = autor;
	}
	public String getCodigo_Peliculas() {
		return Codigo_Peliculas;
	}
	public void setCodigo_Peliculas(String codigo_Peliculas) {
		Codigo_Peliculas = codigo_Peliculas;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	@Override
	public String toString() {
		return "Peliculas [Codigo_Peliculas=" + Codigo_Peliculas + ", Titulo=" + Titulo + ", Autor=" + Autor + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Autor == null) ? 0 : Autor.hashCode());
		result = prime * result + ((Codigo_Peliculas == null) ? 0 : Codigo_Peliculas.hashCode());
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
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
		Peliculas other = (Peliculas) obj;
		if (Autor == null) {
			if (other.Autor != null)
				return false;
		} else if (!Autor.equals(other.Autor))
			return false;
		if (Codigo_Peliculas == null) {
			if (other.Codigo_Peliculas != null)
				return false;
		} else if (!Codigo_Peliculas.equals(other.Codigo_Peliculas))
			return false;
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		return true;
	}
}
