package modelo.cuenta;

import modelo.persona.Persona;

public interface ICuenta {
	public Persona getPropietario();
	public void setPropietario(Persona propietario);
	public double getMonto();
	public int getId();
	public void setId(int id);
	public String getNombre();
	public void setNombre(String nombre);
	
}
