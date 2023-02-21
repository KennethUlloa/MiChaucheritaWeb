package modelo.cuenta;

import java.io.Serializable;

import modelo.persona.Persona;
import utilities.JSON;

public abstract class Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	private int numeroCuenta;
	private String nombreCuenta;
	private Persona propietario;
	
	
	public Cuenta() {
		
	}

	public Cuenta(int numeroCuenta, String nombreCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.nombreCuenta = nombreCuenta;
	}
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	abstract public double getMonto();
	

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("nombre", this.nombreCuenta);
		json.add("numero", this.numeroCuenta);
		json.add("monto",this.getMonto());		
		return json.toString();
	}
	
}
