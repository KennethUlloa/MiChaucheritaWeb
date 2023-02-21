package modelo.transaccion;

import java.io.Serializable;
import java.time.LocalDate;

import modelo.cuenta.CuentaDestino;
import modelo.cuenta.CuentaOrigen;
import utilities.JSON;

public class Transaccion implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private CuentaOrigen origen;
	private CuentaDestino destino;
	private String concepto;
	private double monto;
	private LocalDate fecha;
	
	public Transaccion() {}
	
	public Transaccion(int id, CuentaOrigen origen, CuentaDestino destino, String concepto, double monto, LocalDate fecha) {
		super();
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.concepto = concepto;
		this.monto = monto;
		this.fecha = fecha;
		this.realizarTransaccion();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public CuentaOrigen getOrigen() {
		return origen;
	}
	
	public void setOrigen(CuentaOrigen origen) {
		this.origen = origen;
	}
	
	public CuentaDestino getDestino() {
		return destino;
	}
	
	public void setDestino(CuentaDestino destino) {
		this.destino = destino;
	}
	
	public String getConcepto() {
		return concepto;
	}
	
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public void realizarTransaccion() {
		origen.registrarSalida(monto);
		destino.registrarEntrada(monto);
		
	}

	@Override
	public String toString() {
		JSON json = new JSON();
		json.add("id", this.id);
		json.add("origen", this.origen);
		json.add("destino", this.destino);
		json.add("concepto", this.concepto);
		json.add("monto", this.monto);
		json.add("fecha", this.fecha.toString());
		
		return json.toString();
	}
}
