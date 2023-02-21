package modelo;

import java.util.ArrayList;
import java.util.List;

public class CuentaDAO implements ICuentaDAO {
	private static List<Cuenta> cuentas = null;

	@Override
	public void create(Cuenta object) {
		// TODO Auto-generated method stub
		
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
		if(cuentas == null) {
			cuentas = new ArrayList<Cuenta>();
			cuentas.add(new CuentaIngresos(1,"Nómina"));
			cuentas.add(new CuentaEgresos(2,"Regalo"));
			cuentas.add(new CuentaEgresos(5,"Universidad"));
			cuentas.add(new CuentaIngresoEgreso(3,"Banco"));
			cuentas.add(new CuentaIngresoEgreso(4,"Efectivo"));
		}
		return cuentas;
	}

	@Override
	public void update(Cuenta object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

		
	
}
