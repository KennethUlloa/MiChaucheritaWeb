package modelo.entidades;

import utilities.JSON;

public class CuentaIngresos extends AbstractCuenta {

	private static final long serialVersionUID = 1L;
	
	public CuentaIngresos() {
		super();
	}

	public CuentaIngresos(int numeroCuenta, String nombreCuenta) {
		super(numeroCuenta, nombreCuenta);
	}

	@Override
	public void setMonto(double monto) {
		// TODO Auto-generated method stub
		super.setMonto(monto);
	}

	public void registrarSalida(double valor) {
		setMonto(getMonto() + valor);	
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
