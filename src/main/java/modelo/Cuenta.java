package modelo;

import java.io.Serializable;

abstract class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroCuenta;
	private String nombreCuenta;
	
	
	
	public Cuenta() {
		
	}

	public Cuenta(int numeroCuenta, String nombreCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.nombreCuenta = nombreCuenta;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}
	
	abstract double getMonto();
	abstract void registrarEgreso(double valor);
	abstract void registrarIngreso(double valor);
	


	
	
	
	
}
