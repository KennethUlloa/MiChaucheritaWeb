package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.estadocuenta.EstadoCuenta;
import modelo.persona.Persona;
import modelo.transaccion.ITransaccionDAO;
import modelo.transaccion.Transaccion;
import modelo.transaccion.TransaccionDAO;
import utilities.DateRange;
import utilities.FiltroTransaccion;

/**
 * Servlet implementation class EstadoCuentaController
 */
@WebServlet("/GestionarEstadoCuentaController")
public class GestionarEstadoCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GestionarEstadoCuentaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}
	
	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerificadorSesion verificador = new VerificadorSesion();
		if(!verificador.verificarYRedirigir(request, response, "LogInController")) {
			return;
		}
		
		String accion = (request.getParameter("accion") == null)? "mostrar" : request.getParameter("accion");
		switch(accion) {
			case "mostrar":
				mostrar(request, response);
				break;
			case "crear":
				crear(request, response);
				break;
		}
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Parametros
		String mes = request.getParameter("mes");
		String anio = request.getParameter("anio");
		//
		DateRange range = new DateRange(Integer.parseInt(mes), Integer.parseInt(anio));
		ITransaccionDAO modelo = new TransaccionDAO();
		List<Transaccion> transacciones = modelo.getByRange(range.getInicio(),range.getFin());
		Persona persona = (Persona)request.getSession().getAttribute("usuario");
		transacciones = transacciones.stream().filter(new FiltroTransaccion(persona)).toList();
		EstadoCuenta estadoCuenta = new EstadoCuenta(transacciones, persona);
		//
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(estadoCuenta);
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/estadocuenta.jsp").forward(request, response);
	}
	


}
