package modelo;

import java.util.List;

public interface DAO<T,K> {
	public void create(T object);
	public T getBy(K id);
	public List<T> getAll();
	public void update(T object);
	public void delete(K id);
}
