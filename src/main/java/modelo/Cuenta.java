package modelo;

import java.io.Serializable;

public abstract class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroCuenta;
	private String nombreCuenta;
	
	
	
	public Cuenta() {
		
	}

	public Cuenta(int numeroCuenta, String nombreCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.nombreCuenta = nombreCuenta;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}
	
	abstract public double getMonto();
	abstract public void registrarEgreso(double valor);
	abstract public void registrarIngreso(double valor);
	
}
