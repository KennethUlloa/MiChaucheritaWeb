package utilities;

import java.util.function.Predicate;

import modelo.cuenta.CuentaDestino;
import modelo.cuenta.CuentaOrigen;
import modelo.persona.Persona;
import modelo.transaccion.Transaccion;

public class FiltroTransaccion implements Predicate<Transaccion>{
	
	private Persona propietario;
	
	public FiltroTransaccion(Persona propietario) {
		this.propietario = propietario;
	}

	@Override
	public boolean test(Transaccion t) {
		CuentaOrigen origen = t.getOrigen(); 
		CuentaDestino destino = t.getDestino();
		return origen.getPropietario().equals(propietario) || destino.getPropietario().equals(propietario);
	}

}
