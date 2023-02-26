package modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Persona;
import modelo.entidades.Transaccion;

public interface ITransaccionDAO extends DAO<Transaccion, Integer>{
	public List<Transaccion> getByDateRange(LocalDate inicio, LocalDate fin);
	public List<Transaccion> getByPersona(Persona persona);
	public List<Transaccion> getByDateRangeAndPersona(LocalDate inicio, LocalDate fin, Persona persona);
}
