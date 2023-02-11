package modelo;

import java.util.ArrayList;
import java.util.List;

public class CuentaDao {
	private static List<Cuenta> cuentas=null;
	
	public Cuenta getCuenta(int id) {
		for (Cuenta cuenta : cuentas) {
			if(cuenta.getNumeroCuenta()==id) {
				return cuenta;
			}
		}
		return null;
	}

	public static List<Cuenta> getCuentas() {
		if(cuentas==null) {
			cuentas = new ArrayList<Cuenta>();
			//agregar cuentas
		}
		return cuentas;
	}

		
	
}
