package modelo.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.dao.ITransaccionDAO;
import modelo.entidades.Persona;
import modelo.entidades.AbstractTransaccion;

public class JPATransaccionDAO implements ITransaccionDAO{
	
	EntityManager em;
	
	public JPATransaccionDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiChaucheritaWeb");
		this.em = emf.createEntityManager();
	}

	@Override
	public void create(AbstractTransaccion<?, ?> object) {
		// TODO Auto-generated method stub
		this.em.getTransaction().begin();
		this.em.persist(object);
		this.em.getTransaction().commit();
	}

	@Override
	public AbstractTransaccion<?, ?> getById(Integer id) {
		this.em.getTransaction().begin();
		AbstractTransaccion t1 = this.em.find(AbstractTransaccion.class, id);
		this.em.getTransaction().commit();
		return t1;
	}

	@Override
	public List<AbstractTransaccion<?, ?>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AbstractTransaccion<?, ?> object) {
		this.em.getTransaction().begin();
		this.em.merge(object);
		this.em.getTransaction().commit();		
	}

	@Override
	public void delete(Integer id) {
		this.em.getTransaction().begin();
		AbstractTransaccion t1 = this.em.find(AbstractTransaccion.class, id);
		this.em.remove(t1);
		this.em.getTransaction().commit();
		
	}

	@Override
	public List<AbstractTransaccion<?, ?>> getByDateRange(LocalDate inicio, LocalDate fin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractTransaccion<?, ?>> getByPersona(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractTransaccion<?, ?>> getByDateRangeAndPersona(LocalDate inicio, LocalDate fin, Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
