package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EstadoCuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<CuentaIngresos> cuentasIngresos;
	private List<CuentaEgresos> cuentasEgresos;
	private List<CuentaIngresoEgreso> cuentasIngresoEgreso;
	
	public EstadoCuenta() {
		cuentasIngresoEgreso = new ArrayList<>();
		cuentasIngresos = new ArrayList<>();
		cuentasEgresos = new ArrayList<>();
	}
	
	public EstadoCuenta(List<Transaccion> transacciones) {
		this();
		//Estruturas donde se van a guardar las cuentas que obtenga
		
		HashMap<Integer, CuentaIngresos> mapCuentasIngresos = new HashMap<>();
		HashMap<Integer, CuentaEgresos> mapCuentasEgresos = new HashMap<>();
		CuentaIngresos cuentaIngreso = new CuentaIngresos();
		CuentaEgresos cuentaEgreso = new CuentaEgresos();
		List<Cuenta> cuentasExistentes = new CuentaDAO().getAll();
		
		//Cargar primero todas las cuentas existentes
		for(Cuenta cuenta : cuentasExistentes ) {
			
			if(cuenta instanceof CuentaIngresoEgreso) {
				cuentasIngresoEgreso.add((CuentaIngresoEgreso) cuenta);
			}
			
			if(cuenta instanceof CuentaIngresos) {
				cuentaIngreso.setNumeroCuenta(cuenta.getNumeroCuenta());
				cuentaIngreso.setNombreCuenta(cuenta.getNombreCuenta());
				mapCuentasIngresos.put(cuentaIngreso.getNumeroCuenta(),cuentaIngreso);
			}
			
			if(cuenta instanceof CuentaEgresos) {
				cuentaEgreso.setNumeroCuenta(cuenta.getNumeroCuenta());
				cuentaEgreso.setNombreCuenta(cuenta.getNombreCuenta());
				mapCuentasEgresos.put(cuenta.getNumeroCuenta(), cuentaEgreso);
			}
		}
		
		//Se realiza la sumarizacion de cada cuenta con la traccion registrada
		for(Transaccion t : transacciones) {
			CuentaIngresos origen = mapCuentasIngresos.get(t.getOrigen().getNumeroCuenta());
			CuentaEgresos destino = mapCuentasEgresos.get(t.getDestino().getNumeroCuenta());
			if(origen != null) {
				origen.registrarSalida(t.getMonto());
			}
			if(destino != null) {
				destino.registrarEntrada(t.getMonto());
			}
			
		}
		for(Integer i : mapCuentasIngresos.keySet()) {
			cuentasIngresos.add(mapCuentasIngresos.get(i));
		}
		for(Integer i : mapCuentasEgresos.keySet()) {
			cuentasEgresos.add(mapCuentasEgresos.get(i));
		}
	}

	public List<CuentaIngresos> getCuentasIngresos() {
		return cuentasIngresos;
	}

	public void setCuentasIngresos(List<CuentaIngresos> cuentasIngresos) {
		this.cuentasIngresos = cuentasIngresos;
	}

	public List<CuentaEgresos> getCuentasEgresos() {
		return cuentasEgresos;
	}

	public void setCuentasEgresos(List<CuentaEgresos> cuentasEgresos) {
		this.cuentasEgresos = cuentasEgresos;
	}

	public List<CuentaIngresoEgreso> getCuentasIngresoEgreso() {
		return cuentasIngresoEgreso;
	}

	public void setCuentasIngresoEgreso(List<CuentaIngresoEgreso> cuentasIngresoEgreso) {
		this.cuentasIngresoEgreso = cuentasIngresoEgreso;
	}

	@Override
	public String toString() {
		return "{\"cuentasIngresos\":" + cuentasIngresos + ", \"cuentasEgresos\":" + cuentasEgresos
				+ ", \"cuentasIngresoEgreso\":" + cuentasIngresoEgreso + "}";
	}
	

}
