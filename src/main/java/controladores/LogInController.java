package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.IPersonaDAO;
import modelo.entidades.Persona;
import modelo.memoria.PersonaDAO;
import utilities.JSON;

/**
 * Servlet implementation class LogInController
 */
@WebServlet("/LogInController")
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogInController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}
	
	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion == null) {
			accion = "mostrar";
		}
		
		switch(accion) {
			case "mostrar":
				mostrar(request, response);
				break;
			case "autenticar":
				autenticar(request, response);
				break;
		}
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
	}
	
	
	
	private void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener parametros
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		//Llamar al modelo
		IPersonaDAO modelo = new PersonaDAO();
		Persona persona = modelo.autenticar(usuario, clave);
		//Llamar a la vista (respuesta JSON para actualizacion de contenido)
		if(persona == null) {
			JSON error = new JSON();
			error.add("error", "Usuario y/o contraseña incorrectos");
			response.setStatus(400);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(error);
		}else {
			request.getSession().setAttribute("usuario", persona);  
			response.sendRedirect("HomePageController"); 
		}
		//Autenticar
		
	}
}
