package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	private void crear(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/cuentas.jsp").forward(request, response);
	}
}
