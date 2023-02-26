package modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Persona;
import modelo.entidades.AbstractTransaccion;
import modelo.entidades.ICuenta;

public interface ITransaccionDAO extends DAO<AbstractTransaccion<?,?>, Integer>{
	public List<AbstractTransaccion<?,?>> getByDateRange(LocalDate inicio, LocalDate fin);
	public List<AbstractTransaccion<?,?>> getByPersona(Persona persona);
	public List<AbstractTransaccion<?,?>> getByDateRangeAndPersona(LocalDate inicio, LocalDate fin, Persona persona);
}
