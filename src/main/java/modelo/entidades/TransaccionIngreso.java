package modelo.entidades;

import java.time.LocalDate;

public class TransaccionIngreso extends AbstractTransaccion<CuentaIngresos, CuentaIngresoEgreso> {

	private static final long serialVersionUID = 1L;

	public TransaccionIngreso(int id, CuentaIngresos origen, CuentaIngresoEgreso destino, String concepto, double monto,
			LocalDate fecha) {
		super(id, origen, destino, concepto, monto, fecha);
		destino.registrarEntrada(monto);
	}
	

}
