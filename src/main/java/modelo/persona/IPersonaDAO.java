package modelo.persona;

import modelo.DAO;

public interface IPersonaDAO extends DAO<Persona, String>{
	public Persona autenticar(String usuario, String clave);
}
