package modelo.estadocuenta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.cuenta.Cuenta;
import modelo.cuenta.CuentaDAO;
import modelo.cuenta.CuentaEgresos;
import modelo.cuenta.CuentaIngresoEgreso;
import modelo.cuenta.CuentaIngresos;
import modelo.persona.Persona;
import modelo.transaccion.Transaccion;
import utilities.JSON;

public class EstadoCuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<CuentaIngresos> cuentasIngreso;
	private List<CuentaEgresos> cuentasEgreso;
	private List<CuentaIngresoEgreso> cuentasIngresoEgreso;
	private List<Transaccion> transacciones;
	
	public EstadoCuenta() {
		cuentasIngresoEgreso = new ArrayList<>();
		cuentasIngreso = new ArrayList<>();
		cuentasEgreso = new ArrayList<>();
	}
	
	public EstadoCuenta(List<Transaccion> transacciones, Persona persona) {
		this();
		//Estruturas donde se van a guardar las cuentas que obtenga
		this.transacciones = transacciones;
		HashMap<Integer, CuentaIngresos> mapCuentasIngresos = new HashMap<>();
		HashMap<Integer, CuentaEgresos> mapCuentasEgresos = new HashMap<>();

		List<Cuenta> cuentasExistentes = new CuentaDAO().getByPropietario(persona);
		
		//Cargar primero todas las cuentas existentes
		for(Cuenta cuenta : cuentasExistentes ) {
			
			if(cuenta instanceof CuentaIngresoEgreso) {
				cuentasIngresoEgreso.add((CuentaIngresoEgreso) cuenta);
			}
			
			if(cuenta instanceof CuentaIngresos) {
				mapCuentasIngresos.put(cuenta.getId(),new CuentaIngresos(cuenta.getId(), cuenta.getNombre()));
			}
			
			if(cuenta instanceof CuentaEgresos) {
				mapCuentasEgresos.put(cuenta.getId(),new CuentaEgresos(cuenta.getId(), cuenta.getNombre()));
			}
		}
		
		//Se realiza la sumarizacion de cada cuenta con la traccion registrada
		for(Transaccion t : transacciones) {
			CuentaIngresos origen = mapCuentasIngresos.get(t.getOrigen().getId());
			CuentaEgresos destino = mapCuentasEgresos.get(t.getDestino().getId());
			if(origen != null) {
				origen.registrarSalida(t.getMonto());
			}
			if(destino != null) {
				destino.registrarEntrada(t.getMonto());
			}
			
		}
			
		
		for(Integer i : mapCuentasIngresos.keySet()) {
			cuentasIngreso.add(mapCuentasIngresos.get(i));
		}
		
		for(Integer i : mapCuentasEgresos.keySet()) {
			cuentasEgreso.add(mapCuentasEgresos.get(i));
		}
	}

	public List<CuentaIngresos> getCuentasIngresos() {
		return cuentasIngreso;
	}

	public void setCuentasIngresos(List<CuentaIngresos> cuentasIngresos) {
		this.cuentasIngreso = cuentasIngresos;
	}

	public List<CuentaEgresos> getCuentasEgresos() {
		return cuentasEgreso;
	}

	public void setCuentasEgresos(List<CuentaEgresos> cuentasEgresos) {
		this.cuentasEgreso = cuentasEgresos;
	}

	public List<CuentaIngresoEgreso> getCuentasIngresoEgreso() {
		return cuentasIngresoEgreso;
	}

	public void setCuentasIngresoEgreso(List<CuentaIngresoEgreso> cuentasIngresoEgreso) {
		this.cuentasIngresoEgreso = cuentasIngresoEgreso;
	}
	
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("cuentasIngreso", this.cuentasIngreso);
		json.add("cuentasIngresoEgreso", this.cuentasIngresoEgreso);
		json.add("cuentasEgreso", this.cuentasEgreso);
		json.add("transacciones", transacciones);
		return json.toString();
	}
	

}
