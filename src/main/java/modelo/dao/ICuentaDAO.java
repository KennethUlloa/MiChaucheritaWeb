package modelo.dao;

import java.util.List;

import modelo.entidades.AbstractCuenta;
import modelo.entidades.ICuenta;
import modelo.entidades.Persona;

public interface ICuentaDAO extends DAO<ICuenta, Integer>{
	public List<ICuenta> getByPropietario(Persona persona);
	public <T extends ICuenta> List<T> getAllByType(Class<T> c); 
	public <T extends ICuenta> List<T> getAllByPropietarioAndType(Persona propietario, Class<T> c); 
	public <T extends ICuenta> T getByIdAndType(Integer id, Class<T> c);
	
}
