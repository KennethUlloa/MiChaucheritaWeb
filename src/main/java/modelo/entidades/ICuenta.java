package modelo.entidades;

public interface ICuenta {
	public Persona getPropietario();
	public void setPropietario(Persona propietario);
	public double getMonto();
	public int getId();
	public void setId(int id);
	public String getNombre();
	public void setNombre(String nombre);
	public void setMonto(double monto);
}
