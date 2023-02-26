package modelo.entidades;

import java.io.Serializable;
import java.util.Objects;

import utilities.JSON;

public class Persona implements Serializable{
	
	//attributes
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String nombre;
	private String clave;
	//constructors
	public Persona(String usuario, String nombre, String clave) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public Persona() {}

	
	//getters & setters
	public String getUsuario() {
		return usuario;
	}

	public void setUsario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("usuario", this.usuario);
		json.add("nombre", this.nombre);
		json.add("clave", this.clave);
		return json.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(clave, nombre, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(clave, other.clave) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(usuario, other.usuario);
	}
		
}
