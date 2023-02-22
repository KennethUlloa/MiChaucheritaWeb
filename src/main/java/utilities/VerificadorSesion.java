package utilities;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerificadorSesion {
	public boolean soloVerificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession() == null) return false;
		if (request.getSession().getAttribute("usuario") == null) return false;
		return true;
		
	}
	
	public boolean verificarYRedirigir(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		boolean estaVerificado = this.soloVerificar(request, response);
		if(!estaVerificado) {
			response.sendRedirect(url);
		}
		return estaVerificado;
	}
}
