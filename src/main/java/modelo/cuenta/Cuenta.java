package modelo.cuenta;

import java.io.Serializable;

import modelo.persona.Persona;
import utilities.JSON;

public abstract class Cuenta implements Serializable, ICuenta {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Persona propietario;
	
	
	public Cuenta() {}

	public Cuenta(int id, String nombreCuenta) {
		this.id = id;
		this.nombre = nombreCuenta;
	}
	
	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("nombre", this.nombre);
		json.add("numero", this.id);
		json.add("monto",this.getMonto());		
		return json.toString();
	}

	@Override
	public Persona getPropietario() {
		return propietario;
	}

	@Override
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
