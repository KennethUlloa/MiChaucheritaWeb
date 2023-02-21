package modelo.cuenta;

import java.util.ArrayList;
import java.util.List;

import modelo.persona.IPersonaDAO;
import modelo.persona.Persona;
import modelo.persona.PersonaDAO;

public class CuentaDAO implements ICuentaDAO {
	private static List<Cuenta> cuentas = null;

	@Override
	public void create(Cuenta object) {
		int max = 0;
		for(Cuenta cuenta:cuentas) {
			if(max<cuenta.getNumeroCuenta()) {
				max = cuenta.getNumeroCuenta();
				
			}			
		}
		object.setNumeroCuenta(max+1);
		cuentas.add(object);
		
	}

	@Override
	public Cuenta getById(Integer id) {
		for (Cuenta cuenta : getAll()) {
			if(cuenta.getNumeroCuenta()==id) {
				return cuenta;
			}
		}
		return null;
	}

	@Override
	public List<Cuenta> getAll() {
		IPersonaDAO personas = new PersonaDAO();
		if(cuentas == null) {
			cuentas = new ArrayList<Cuenta>();
			Cuenta cuenta = new CuentaIngresos(1,"Nómina");
			cuenta.setPropietario(personas.getById("kenneth"));
			cuentas.add(cuenta);
			cuenta = new CuentaEgresos(2,"Regalo");
			cuenta.setPropietario(personas.getById("kenneth"));
			cuentas.add(cuenta);
			cuenta = new CuentaEgresos(5,"Universidad");
			cuenta.setPropietario(personas.getById("kenneth"));
			cuentas.add(cuenta);
			cuenta = new CuentaIngresoEgreso(3,"Banco");
			cuenta.setPropietario(personas.getById("kenneth"));
			cuentas.add(cuenta);
			cuenta = new CuentaIngresoEgreso(4,"Efectivo");
			cuenta.setPropietario(personas.getById("kenneth"));
			cuentas.add(cuenta);
		}
		return cuentas;
	}

	@Override
	public void update(Cuenta object) {
		for (Cuenta cuenta:cuentas) {
			if(cuenta.getNumeroCuenta()==object.getNumeroCuenta()) {
				cuentas.set(cuentas.indexOf(cuenta), object);
			}
		}
		
	}

	@Override
	public void delete(Integer id) {
		cuentas.removeIf(cuenta->cuenta.getNumeroCuenta()==id);
	}

	@Override
	public List<Cuenta> getByPropietario(Persona persona) {
		return getAll().stream().filter(cuenta -> cuenta.getPropietario().equals(persona)).toList();
	}

		
	
}
