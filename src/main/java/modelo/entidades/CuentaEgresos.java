package modelo.entidades;

import utilities.JSON;

public class CuentaEgresos extends AbstractCuenta {

	private static final long serialVersionUID = 1L;
	private double egresos;
	
	public CuentaEgresos() {
		super();
	}

	public CuentaEgresos(int id, String nombre) {
		super(id, nombre);
	}
	
	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("nombre", this.getNombre());
		json.add("numero", this.getId());
		json.add("monto",this.getMonto());	
		json.add("tipo","E");
		return json.toString();
	}
	
	@Override
	public double getMonto() {
		return -super.getMonto();
	}

	public void registrarEntrada(double valor) {
		this.egresos += valor;
		setMonto(this.egresos);
	}
}
