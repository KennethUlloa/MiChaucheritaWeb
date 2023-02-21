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
import modelo.cuenta.CuentaEgresos;
import modelo.cuenta.CuentaIngresos;
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
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		
		/*
		JSON banco = new JSON();
		banco.add("nombre", "Banco");
		banco.add("tipo", "IE");
		banco.add("monto", 500.0);
		
		JSON efectivo = new JSON();
		efectivo.add("nombre", "Efectivo");
		efectivo.add("tipo", "IE");
		efectivo.add("monto", 50.0);
		
		JSON nomina = new JSON();
		nomina.add("nombre", "Nómina");
		nomina.add("tipo", "I");
		nomina.add("monto", 1000.0);
		
		JSON regalo = new JSON();
		regalo.add("nombre", "Regalo");
		regalo.add("tipo", "E");
		regalo.add("monto", -350.0);
		
		JSON t = new JSON();
		t.add("origen", nomina);
		t.add("destino", banco);
		t.add("concepto", "Pago de rol");
		t.add("monto", 1000);
		t.add("fecha", "17-02-2022");
		
		JSON t2 = new JSON();
		t2.add("origen", banco);
		t2.add("destino", efectivo);
		t2.add("concepto", "Retiro de dinero");
		t2.add("monto", 400);
		t2.add("fecha", "20-02-2022");*/
		
		ITransaccionDAO modelo = new TransaccionDAO(); 
		List<Transaccion> transacciones = modelo.getAll();
		if(inicio != null && fin != null) {
			LocalDate fechaInicio = LocalDate.parse(inicio);
			LocalDate fechaFin = LocalDate.parse(fin);
			transacciones = modelo.getByRange(fechaInicio, fechaFin);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(transacciones);
	}

}
