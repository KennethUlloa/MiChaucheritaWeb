package modelo.memoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.ITransaccionDAO;
import modelo.entidades.CuentaDestino;
import modelo.entidades.CuentaEgresos;
import modelo.entidades.CuentaIngresoEgreso;
import modelo.entidades.CuentaIngresos;
import modelo.entidades.CuentaOrigen;
import modelo.entidades.ICuenta;
import modelo.entidades.Persona;
import modelo.entidades.Transaccion;
import modelo.entidades.TransaccionEgreso;
import modelo.entidades.TransaccionIngreso;
import modelo.entidades.TransaccionTraspaso;

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
			transacciones.add(new TransaccionIngreso(1, cd.getByIdAndType(1, CuentaIngresos.class), 
					cd.getByIdAndType(3, CuentaIngresoEgreso.class), "Pago de nómina de mi trabajo", 1000, 
					LocalDate.of(2022, 12, 31)));
			//3 - 5 Banco a Universidad
			transacciones.add(new TransaccionEgreso(2, cd.getByIdAndType(3, CuentaIngresoEgreso.class), 
					cd.getByIdAndType(5, CuentaEgresos.class), "Libro \"Contabilidad básica\"", 100, 
					LocalDate.of(2023, 1, 16)));
			//3 - 4 Banco a Efectivo
			transacciones.add(new TransaccionTraspaso(3, cd.getByIdAndType(3, CuentaIngresoEgreso.class), 
					cd.getByIdAndType(4, CuentaIngresoEgreso.class), "Traspaso entre cuentas", 400, 
					LocalDate.of(2023, 1, 20)));
			//4 - 2 Efectivo a regalo
			transacciones.add(new TransaccionEgreso(4, cd.getByIdAndType(4, CuentaIngresoEgreso.class), 
					cd.getByIdAndType(2, CuentaEgresos.class), "Teléfono Celular para mamá", 350, 
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
	public List<Transaccion> getByDateRange(LocalDate inicio, LocalDate fin) {
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
			ICuenta origen = transaccion.getOrigen(); 
			ICuenta destino = transaccion.getDestino();
			return origen.getPropietario().equals(persona) && destino.getPropietario().equals(persona);
		}).toList();
	}

	@Override
	public List<Transaccion> getByDateRangeAndPersona(LocalDate inicio, LocalDate fin, Persona persona) {
		return getByDateRange(inicio, fin).stream().filter(t -> {
			return t.getOrigen().getPropietario().equals(persona) && t.getDestino().getPropietario().equals(persona);
			}).toList();
	}	
	
	
}
