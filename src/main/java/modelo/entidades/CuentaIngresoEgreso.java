package modelo.entidades;

import utilities.JSON;

public class CuentaIngresoEgreso extends AbstractCuenta {

	private static final long serialVersionUID = 1L;
	private double egresos;
	private double ingresos;
	
	public CuentaIngresoEgreso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaIngresoEgreso(int id, String nombre) {
		super(id, nombre);
	}

	@Override
	public String toString() {		
		JSON json = new JSON();
		json.add("nombre", this.getNombre());
		json.add("numero", this.getId());
		json.add("monto",this.getMonto());	
		json.add("tipo","IE");
		return json.toString();
	}

	public void registrarSalida(double valor) {
		egresos += valor;
		setMonto(ingresos - egresos);
	}

	public void registrarEntrada(double valor) {
		ingresos += valor;
		setMonto(ingresos - egresos);
	}

}
