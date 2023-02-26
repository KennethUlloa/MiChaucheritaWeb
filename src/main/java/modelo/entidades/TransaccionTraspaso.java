package modelo.entidades;

import java.time.LocalDate;

public class TransaccionTraspaso extends AbstractTransaccion<CuentaIngresoEgreso, CuentaIngresoEgreso>{

	private static final long serialVersionUID = 1L;

	public TransaccionTraspaso(int id, CuentaIngresoEgreso origen, CuentaIngresoEgreso destino, String concepto,
			double monto, LocalDate fecha) {
		super(id, origen, destino, concepto, monto, fecha);
		origen.registrarSalida(monto);
		destino.registrarEntrada(monto);
	}
	
	

}
