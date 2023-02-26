package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ICuentaDAO;
import modelo.dao.ITransaccionDAO;
import modelo.entidades.AbstractCuenta;
import modelo.entidades.CuentaDestino;
import modelo.entidades.CuentaEgresos;
import modelo.entidades.CuentaIngresoEgreso;
import modelo.entidades.CuentaIngresos;
import modelo.entidades.CuentaOrigen;
import modelo.entidades.ICuenta;
import modelo.entidades.Persona;
import modelo.entidades.AbstractTransaccion;
import modelo.entidades.TransaccionEgreso;
import modelo.entidades.TransaccionIngreso;
import modelo.entidades.TransaccionTraspaso;
import modelo.memoria.CuentaDAO;
import modelo.memoria.TransaccionDAO;
import utilities.JSON;
import utilities.VerificadorSesion;

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
			case "registrarIngreso":
				registrarIngreso(request, response);
				break;
			case "registrarEgreso":
				registrarEgreso(request, response);
				break;
			case "registrarTraspaso":
				registrarTraspaso(request, response);
				break;
			case "listar":
				listar(request, response);
				break;
		}
	}
	
	private void registrarTraspaso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Obtener parametros
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String fecha = request.getParameter("fecha");
		String monto = request.getParameter("monto");
		String concepto = request.getParameter("concepto");
		
		//Llamar al modelo
		LocalDate fechaTransaccion = LocalDate.parse(fecha);
		ICuentaDAO modeloCuenta = new CuentaDAO();
		CuentaIngresoEgreso cuentaOrigen = modeloCuenta.getByIdAndType(Integer.parseInt(origen), CuentaIngresoEgreso.class);
		CuentaIngresoEgreso cuentaDestino = modeloCuenta.getByIdAndType(Integer.parseInt(destino), CuentaIngresoEgreso.class);
		TransaccionTraspaso transaccion = new TransaccionTraspaso(0, cuentaOrigen, cuentaDestino, concepto, Double.parseDouble(monto), fechaTransaccion);
		ITransaccionDAO modeloTransaccion = new TransaccionDAO();
		modeloTransaccion.create(transaccion);
		
		//Llamar a la vista
		JSON json = new JSON();
		json.add("status", "ok");
		json.add("url", "GestionarMovimientosController");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		
	}

	private void registrarEgreso(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Obtener parametros
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String fecha = request.getParameter("fecha");
		String monto = request.getParameter("monto");
		String concepto = request.getParameter("concepto");
		
		//Llamar al modelo
		LocalDate fechaTransaccion = LocalDate.parse(fecha);
		ICuentaDAO modeloCuenta = new CuentaDAO();
		CuentaIngresoEgreso cuentaOrigen = modeloCuenta.getByIdAndType(Integer.parseInt(origen), CuentaIngresoEgreso.class);
		CuentaEgresos cuentaDestino = modeloCuenta.getByIdAndType(Integer.parseInt(destino), CuentaEgresos.class);
		TransaccionEgreso transaccion = new TransaccionEgreso(0, cuentaOrigen, cuentaDestino, concepto, Double.parseDouble(monto), fechaTransaccion);
		ITransaccionDAO modeloTransaccion = new TransaccionDAO();
		modeloTransaccion.create(transaccion);
		
		//Llamar a la vista
		JSON json = new JSON();
		json.add("status", "ok");
		json.add("url", "GestionarMovimientosController");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		
	}

	private void registrarIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener parametros
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String fecha = request.getParameter("fecha");
		String monto = request.getParameter("monto");
		String concepto = request.getParameter("concepto");
	
		
		//Llamar al modelo
		LocalDate fechaTransaccion = LocalDate.parse(fecha);
		ICuentaDAO modeloCuenta = new CuentaDAO();
		CuentaIngresos cuentaOrigen = modeloCuenta.getByIdAndType(Integer.parseInt(origen), CuentaIngresos.class);
		CuentaIngresoEgreso cuentaDestino = modeloCuenta.getByIdAndType(Integer.parseInt(destino), CuentaIngresoEgreso.class);
		TransaccionIngreso transaccion = new TransaccionIngreso(0, cuentaOrigen, cuentaDestino, concepto, Double.parseDouble(monto), fechaTransaccion);
		ITransaccionDAO modeloTransaccion = new TransaccionDAO();
		modeloTransaccion.create(transaccion);
		
		//Llamar a la vista
		JSON json = new JSON();
		json.add("status", "ok");
		json.add("url", "GestionarMovimientosController");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("jsp/movimientos.jsp").forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Obtener parametros
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		
		//Llamar al modelo
		Persona persona = (Persona) request.getSession().getAttribute("usuario");
		ITransaccionDAO modelo = new TransaccionDAO(); 
		List<AbstractTransaccion<?,?>> transacciones = modelo.getByPersona(persona);
		if((inicio != null && !inicio.equals("")) && (fin != null && !fin.equals(""))) {
			LocalDate fechaInicio = LocalDate.parse(inicio);
			LocalDate fechaFin = LocalDate.parse(fin);
			transacciones = modelo.getByDateRangeAndPersona(fechaInicio, fechaFin, persona);
		}
				
		//Llamar a la vista
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(transacciones);
	}

}
