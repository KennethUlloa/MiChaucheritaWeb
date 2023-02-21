package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ITransaccionDAO extends DAO<Transaccion, Integer>{
	public List<Transaccion> getByRange(LocalDate inicio, LocalDate fin);
}
