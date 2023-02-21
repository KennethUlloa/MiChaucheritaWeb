package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cuenta.Cuenta;
import modelo.cuenta.CuentaDAO;
import modelo.cuenta.CuentaDestino;
import modelo.cuenta.CuentaEgresos;
import modelo.cuenta.CuentaIngresos;
import modelo.cuenta.CuentaOrigen;
import modelo.persona.Persona;
import modelo.transaccion.ITransaccionDAO;
import modelo.transaccion.Transaccion;
import modelo.transaccion.TransaccionDAO;
import utilities.JSON;

@WebServlet("/GestionarMovimientosController")
public class GestionarMovimientosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GestionarMovimientosController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}
	
	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		VerificadorSesion verificador = new VerificadorSesion();
		if(!verificador.verificarYRedirigir(request, response, "LogInController")) {
			return;
		}
		
		String accion = request.getParameter("accion");
		if(accion == null) accion = "mostrar";
		
		switch(accion) {
			case "mostrar":	
				mostrar(request, response); 
				break;
			case "registrar":
				registrar(request, response);
				break;
			case "listar":
				listar(request, response);
				break;
		}
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("jsp/movimientos.jsp").forward(request, response);
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Obtener parametros
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String fecha = request.getParameter("fecha");
		String monto = request.getParameter("monto");
		String concepto = request.getParameter("concepto");
		
		//Llamar al modelo
		LocalDate fechaTransaccion = LocalDate.parse(fecha);
		CuentaDAO modeloCuenta = new CuentaDAO();
		CuentaOrigen cuentaOrigen = (CuentaOrigen) modeloCuenta.getById(Integer.parseInt(origen));
		CuentaDestino cuentaDestino= (CuentaDestino) modeloCuenta.getById(Integer.parseInt(destino));
		Transaccion transaccion = new Transaccion(0, cuentaOrigen, cuentaDestino, concepto, Double.parseDouble(monto), fechaTransaccion);
		transaccion.realizarTransaccion();
		ITransaccionDAO modeloTransaccion = new TransaccionDAO();
		modeloTransaccion.create(transaccion);
		
		//Llamar a la vista
		
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Obtener parametros
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		
		//Llamar al modelo
		ITransaccionDAO modelo = new TransaccionDAO(); 
		List<Transaccion> transacciones = modelo.getAll();
		if(inicio != null && fin != null) {
			LocalDate fechaInicio = LocalDate.parse(inicio);
			LocalDate fechaFin = LocalDate.parse(fin);
			transacciones = modelo.getByRange(fechaInicio, fechaFin);
		}
		
		Persona persona = (Persona) request.getSession().getAttribute("usuario");
		transacciones = transacciones.stream().filter(transaccion -> {
			CuentaOrigen origen = transaccion.getOrigen(); 
			CuentaDestino destino = transaccion.getDestino();
			return origen.getPropietario().equals(persona) || destino.getPropietario().equals(persona);
		}).toList();
		
		//Llamar a la vista
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(transacciones);
	}

}
