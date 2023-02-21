package modelo;

import java.io.Serializable;

public class Persona implements Serializable{
	
	//attributes
	private static final long serialVersionUID = 1L;
	private String usario;
	private String nombre;
	private String clave;
	//constructors
	public Persona(String usario, String nombre, String clave) {
		this.usario = usario;
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public Persona() {}

	
	//getters & setters
	public String getUsario() {
		return usario;
	}

	public void setUsario(String usario) {
		this.usario = usario;
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
	
	
	
	
	
	
	
	

}
