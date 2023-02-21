package modelo.cuenta;

import java.util.List;

import modelo.DAO;
import modelo.persona.Persona;

public interface ICuentaDAO extends DAO<Cuenta, Integer>{
	public List<Cuenta> getByPropietario(Persona persona);
}
