package modelo.memoria;

import java.util.ArrayList;
import java.util.List;

import modelo.dao.IPersonaDAO;
import modelo.entidades.Persona;

public class PersonaDAO implements IPersonaDAO{
	
	private static List<Persona> personas = null;

	@Override
	public void create(Persona persona) {
		getAll().add(persona);
		
	}

	@Override
	public Persona getById(String id) {
		for (Persona persona : getAll()) {
			if(persona.getUsuario().equals(id)) {
				return persona;
			}
		}
		return null;
	}

	@Override
	public List<Persona> getAll() {
		if(personas == null) {
			personas = new ArrayList<>();
			personas.add(new Persona("kenneth", "Kenneth", "1234"));
			personas.add(new Persona("admin", "ADMINISTRADOR", "1234"));
			personas.add(new Persona("luigi", "Luigi", "1234"));
		}
		return personas;
	}

	@Override
	public void update(Persona object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona autenticar(String usuario, String clave) {
		Persona persona = getById(usuario);
		if(persona != null && persona.getClave().equals(clave)) {
			return persona;
		}
		return null;
	}


}
