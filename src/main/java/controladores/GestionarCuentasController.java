package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ICuentaDAO;
import modelo.entidades.AbstractCuenta;
import modelo.entidades.CuentaEgresos;
import modelo.entidades.CuentaIngresoEgreso;
import modelo.entidades.CuentaIngresos;
import modelo.entidades.ICuenta;
import modelo.entidades.Persona;
import modelo.memoria.CuentaDAO;
import utilities.JSON;
import utilities.VerificadorSesion;

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
	
	private void crear(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombreCuenta");
		String tipo = request.getParameter("tipoCuenta");
		AbstractCuenta cuenta = null;
		switch(tipo) {
			case "IE": cuenta = new CuentaIngresoEgreso(0, nombre); break;
			case "I": cuenta = new CuentaIngresos(0, nombre); break;
			case "E": cuenta = new CuentaEgresos(0, nombre); break;
		}
		if(cuenta != null) {
			cuenta.setPropietario((Persona) request.getSession().getAttribute("usuario"));
			ICuentaDAO modelo = new CuentaDAO();
			modelo.create(cuenta);
		}
		
		response.sendRedirect("GestionarCuentasController");
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ICuentaDAO modelo = new CuentaDAO();
		Persona persona = (Persona) request.getSession().getAttribute("usuario");
		List<ICuenta> cuentas = modelo.getByPropietario(persona);
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(cuentas);
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/cuentas.jsp").forward(request, response);
	}
}
