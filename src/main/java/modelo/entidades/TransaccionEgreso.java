package modelo.entidades;

import java.time.LocalDate;

public class TransaccionEgreso extends AbstractTransaccion<CuentaIngresoEgreso, CuentaEgresos>{

	private static final long serialVersionUID = 1L;

	public TransaccionEgreso(int id, CuentaIngresoEgreso origen, CuentaEgresos destino, String concepto, double monto,
			LocalDate fecha) {
		super(id, origen, destino, concepto, monto, fecha);
		origen.registrarSalida(monto);
	}

	
}
