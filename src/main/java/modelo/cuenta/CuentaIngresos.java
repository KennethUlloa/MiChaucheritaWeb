package modelo.cuenta;

import utilities.JSON;

public class CuentaIngresos extends Cuenta implements CuentaOrigen {

	private static final long serialVersionUID = 1L;
	private double ingresos;
	
	public CuentaIngresos() {
		super();
	}

	public CuentaIngresos(int numeroCuenta, String nombreCuenta) {
		super(numeroCuenta, nombreCuenta);
	}

	@Override
	public double getMonto() {
		return ingresos;
	}

	@Override
	public void registrarSalida(double valor) {
		ingresos += valor;
		
	}

	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("nombre", this.getNombre());
		json.add("numero", this.getId());
		json.add("monto",this.getMonto());	
		json.add("tipo","I");
		return json.toString();
	}
	
}