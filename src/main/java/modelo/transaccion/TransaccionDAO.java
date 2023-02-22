package modelo.transaccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.cuenta.CuentaDAO;
import modelo.cuenta.CuentaDestino;
import modelo.cuenta.CuentaOrigen;
import modelo.persona.Persona;

public class TransaccionDAO implements ITransaccionDAO{
	private static List<Transaccion> transacciones;
	
	@Override
	public void create(Transaccion transaccion) {
		int maxId = 0;
		for(Transaccion t : getAll()) {
			if (t.getId() > maxId) {
				maxId = t.getId();
			}
		}
		transaccion.setId(maxId + 1);
		getAll().add(transaccion);
	}

	@Override
	public Transaccion getById(Integer id) {
		// no aplica por regla de negocio
		return null;
	}

	@Override
	public List<Transaccion> getAll() {
		if(transacciones == null) {
			CuentaDAO cd = new CuentaDAO();			
			transacciones = new ArrayList<>();
			//1 - 3 Nomina a banco
			transacciones.add(new Transaccion(1, (CuentaOrigen)cd.getById(1), 
					(CuentaDestino)cd.getById(3), "Pago de nómina de mi trabajo", 1000, 
					LocalDate.of(2022, 12, 31)));
			//3 - 5 Banco a Universidad
			transacciones.add(new Transaccion(2, (CuentaOrigen)cd.getById(3), 
					(CuentaDestino)cd.getById(5), "Libro \"Contabilidad básica\"", 100, 
					LocalDate.of(2023, 1, 16)));
			//3 - 4 Banco a Efectivo
			transacciones.add(new Transaccion(3, (CuentaOrigen)cd.getById(3), 
					(CuentaDestino)cd.getById(4), "Traspaso entre cuentas", 400, 
					LocalDate.of(2023, 1, 20)));
			//4 - 2 Efectivo a regalo
			transacciones.add(new Transaccion(4, (CuentaOrigen)cd.getById(4), 
					(CuentaDestino)cd.getById(2), "Teléfono Celular para mamá", 350, 
					LocalDate.of(2023, 1, 20)));
		}
		return transacciones;
	}

	@Override
	public void update(Transaccion object) {
		// no aplica por regla de negocio
		
	}

	@Override
	public void delete(Integer id) {
		// no aplica por regla de negocio
		
	}

	@Override
	public List<Transaccion> getByRange(LocalDate inicio, LocalDate fin) {
		List<Transaccion> rangoTransacciones = new ArrayList<>(); 
		for(Transaccion t : getAll()) {
			if(t.getFecha().isEqual(inicio) || t.getFecha().isEqual(fin) || 
					(t.getFecha().isAfter(inicio) && t.getFecha().isBefore(fin))) {
				rangoTransacciones.add(t);
			}
		}
		return rangoTransacciones;
	}

	@Override
	public List<Transaccion> getByPersona(Persona persona) {
		return getAll().stream().filter(transaccion -> {
			CuentaOrigen origen = transaccion.getOrigen(); 
			CuentaDestino destino = transaccion.getDestino();
			return origen.getPropietario().equals(persona) || destino.getPropietario().equals(persona);
		}).toList();
	}	
	
	
}
