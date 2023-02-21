package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.cuenta.Cuenta;
import modelo.cuenta.CuentaDAO;
import modelo.cuenta.ICuentaDAO;
import modelo.persona.Persona;
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
		ICuentaDAO modelo = new CuentaDAO();
		Persona persona = (Persona) request.getSession().getAttribute("usuario");
		System.out.println(persona);
		List<Cuenta> cuentas = modelo.getByPropietario(persona);
		System.out.println(cuentas);
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(cuentas);
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/cuentas.jsp").forward(request, response);
	}
}
