package modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.dao.ICuentaDAO;
import modelo.memoria.CuentaDAO;
import utilities.JSON;

public class EstadoCuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<CuentaIngresos> cuentasIngreso;
	private List<CuentaEgresos> cuentasEgreso;
	private List<CuentaIngresoEgreso> cuentasIngresoEgreso;
	private List<AbstractTransaccion<?,?>> transacciones;
	
	public EstadoCuenta() {
		cuentasIngresoEgreso = new ArrayList<>();
		cuentasIngreso = new ArrayList<>();
		cuentasEgreso = new ArrayList<>();
	}
	
	public EstadoCuenta(List<AbstractTransaccion<?,?>> transacciones, Persona persona) {
		this();
		//Estruturas donde se van a guardar las cuentas que obtenga
		this.transacciones = transacciones;
		HashMap<Integer, CuentaIngresos> mapCuentasIngresos = new HashMap<>();
		HashMap<Integer, CuentaEgresos> mapCuentasEgresos = new HashMap<>();
		ICuentaDAO modelo = new CuentaDAO(); 
		cuentasIngresoEgreso = modelo.getAllByPropietarioAndType(persona, CuentaIngresoEgreso.class);
		
		for(CuentaIngresos c : modelo.getAllByPropietarioAndType(persona, CuentaIngresos.class)) {
			mapCuentasIngresos.put(c.getId(), new CuentaIngresos(c.getId(), c.getNombre()));
		}
		
		for(CuentaEgresos c : modelo.getAllByPropietarioAndType(persona, CuentaEgresos.class)) {
			mapCuentasEgresos.put(c.getId(), new CuentaEgresos(c.getId(), c.getNombre()));
		}
		
		
		//Se realiza la sumarizacion de cada cuenta con la traccion registrada
		for(AbstractTransaccion<?,?> t : transacciones) {
			CuentaIngresos origen = mapCuentasIngresos.get(t.getOrigen().getId());
			CuentaEgresos destino = mapCuentasEgresos.get(t.getDestino().getId());
			
			if(t.getOrigen() instanceof CuentaIngresos) {
				origen.registrarSalida(t.getMonto());		
			}
			
			if(t.getDestino() instanceof CuentaEgresos) {
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
	
	public List<AbstractTransaccion<?,?>> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<AbstractTransaccion<?,?>> transacciones) {
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
