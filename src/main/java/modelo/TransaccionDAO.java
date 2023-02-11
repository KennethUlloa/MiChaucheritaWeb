package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {
	private static List<Transaccion> transacciones;
	
	public Transaccion getTransaccion(int id) {
		return null;
	}
	
	public List<Transaccion> getTransacciones() {
		if(transacciones == null) {
			transacciones = new ArrayList<>();
		}
		return transacciones;
	}
	
	public List<Transaccion> getTransacciones(LocalDate inicio, LocalDate fin) {
		List<Transaccion> rangoTransacciones = new ArrayList<>(); 
		for(Transaccion t : getTransacciones()) {
			if(t.getFecha().isEqual(inicio) || t.getFecha().isEqual(fin) || 
					(t.getFecha().isAfter(inicio) && t.getFecha().isBefore(fin))) {
				rangoTransacciones.add(t);
			}
		}
		return rangoTransacciones;
	}
	
	public void updateTransaccion(Transaccion transaccion) {
		
	}
	
	public void registrarTransaccion(Transaccion transaccion) {
		int maxId = 0;
		for(Transaccion t : getTransacciones()) {
			if (t.getId() > maxId) {
				maxId = t.getId();
			}
		}
		transaccion.setId(maxId + 1);
		getTransacciones().add(transaccion);
	}

}
