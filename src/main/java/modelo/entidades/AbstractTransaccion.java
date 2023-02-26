package modelo.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import utilities.JSON;

public abstract class AbstractTransaccion<O extends ICuenta, D extends ICuenta> implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private O origen;
	private D destino;
	private String concepto;
	private double monto;
	private LocalDate fecha;
	
	public AbstractTransaccion() {}
	
	
	
	public AbstractTransaccion(int id, O origen, D destino, String concepto, double monto, LocalDate fecha) {
		super();
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.concepto = concepto;
		this.monto = monto;
		this.fecha = fecha;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public O getOrigen() {
		return origen;
	}
	
	public void setOrigen(O origen) {
		this.origen = origen;
	}
	
	public D getDestino() {
		return destino;
	}
	
	public void setDestino(D destino) {
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
