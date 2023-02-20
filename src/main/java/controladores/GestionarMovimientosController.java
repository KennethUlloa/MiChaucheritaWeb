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

import modelo.Cuenta;
import modelo.CuentaDAO;
import modelo.CuentaEgresos;
import modelo.CuentaIngresos;
import modelo.Transaccion;
import modelo.TransaccionDAO;

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
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

}
