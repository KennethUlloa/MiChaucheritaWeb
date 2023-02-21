package modelo.transaccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.DAO;

public interface ITransaccionDAO extends DAO<Transaccion, Integer>{
	public List<Transaccion> getByRange(LocalDate inicio, LocalDate fin);
}
