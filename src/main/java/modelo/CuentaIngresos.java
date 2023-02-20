package modelo;

public class CuentaIngresos extends Cuenta implements CuentaOrigen{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double ingresos;
	
	

	public CuentaIngresos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaIngresos(int numeroCuenta, String nombreCuenta) {
		super(numeroCuenta, nombreCuenta);
	}

	@Override
	public double getMonto() {
		return ingresos;
	}

	@Override
	public void registrarSalida(double valor) {
		ingresos += valor;
		
	}

	
	
}
