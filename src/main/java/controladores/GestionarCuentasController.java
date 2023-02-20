package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilities.JSON;

/**
 * Servlet implementation class GestionarCuentasController
 */
@WebServlet("/GestionarCuentasController")
public class GestionarCuentasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GestionarCuentasController() {
        super();
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
			case "listar":
				listar(request, response);
				break;
		}
	}
	
	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSON propietario = new JSON();
		propietario.add("nombre", "Kenneth");
		
		JSON cuenta = new JSON();
		cuenta.add("nombre", "Banco");
		cuenta.add("tipo", "IE");
		cuenta.add("monto", 500.0);
		
		JSON cuenta2 = new JSON();
		cuenta2.add("nombre", "Efectivo");
		cuenta2.add("tipo", "IE");
		cuenta2.add("monto", 50.0);
		
		JSON cuenta3 = new JSON();
		cuenta3.add("nombre", "Nómina");
		cuenta3.add("tipo", "I");
		cuenta3.add("monto", 1000.0);
		
		JSON cuenta4 = new JSON();
		cuenta4.add("nombre", "Regalo");
		cuenta4.add("tipo", "E");
		cuenta4.add("monto", -350.0);
		
		List<JSON> cuentas = new ArrayList<>();
		cuentas.add(cuenta);
		cuentas.add(cuenta2);
		cuentas.add(cuenta3);
		cuentas.add(cuenta4);
		
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(cuentas);
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/cuentas.jsp").forward(request, response);
	}
}
