package modelo.memoria;

import java.util.ArrayList;
import java.util.List;

import modelo.dao.ICuentaDAO;
import modelo.dao.IPersonaDAO;
import modelo.entidades.AbstractCuenta;
import modelo.entidades.CuentaEgresos;
import modelo.entidades.CuentaIngresoEgreso;
import modelo.entidades.CuentaIngresos;
import modelo.entidades.ICuenta;
import modelo.entidades.Persona;

public class CuentaDAO implements ICuentaDAO {
	private static List<ICuenta> cuentas = null;

	@Override
	public void create(ICuenta object) {
		int max = 0;
		for(ICuenta cuenta : cuentas) {
			if(max < cuenta.getId()) {
				max = cuenta.getId();
				
			}			
		}
		object.setId(max+1);
		cuentas.add(object);
		
	}

	@Override
	public ICuenta getById(Integer id) {
		for (ICuenta cuenta : getAll()) {
			if(cuenta.getId()==id) {
				return cuenta;
			}
		}
		return null;
	}

	@Override
	public List<ICuenta> getAll() {
		IPersonaDAO personas = new PersonaDAO();
		if(cuentas == null) {
			cuentas = new ArrayList<ICuenta>();
			ICuenta cuenta = new CuentaIngresos(1,"Nómina");
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
	public void update(ICuenta object) {
		for (ICuenta cuenta: getAll()) {
			if(cuenta.getId() == object.getId()) {
				cuentas.set(cuentas.indexOf(cuenta), object);
			}
		}
		
	}

	@Override
	public void delete(Integer id) {
		cuentas.removeIf(cuenta -> cuenta.getId() == id);
	}

	@Override
	public List<ICuenta> getByPropietario(Persona persona) {
		return getAll().stream().filter(cuenta -> cuenta.getPropietario().equals(persona)).toList();
	}

	@Override
	public <T extends ICuenta> List<T> getAllByType(Class<T> c) {
		return getAll().stream().filter(cuenta -> c.isInstance(cuenta)).map(cuenta -> c.cast(cuenta)).toList();
	}

	@Override
	public <T extends ICuenta> List<T> getAllByPropietarioAndType(Persona propietario, Class<T> c) {
		return getAll().stream().filter(cuenta -> c.isInstance(cuenta) && cuenta.getPropietario().equals(propietario)).map(cuenta -> c.cast(cuenta)).toList();
	}

	@Override
	public <T extends ICuenta> T getByIdAndType(Integer id, Class<T> c) {
		return c.cast(getById(id));
	}

}
