package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.EstadoCuenta;
import modelo.Transaccion;
import modelo.ITransaccionDAO;

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
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/estadocuenta.jsp").forward(request, response);
	}
	


}
