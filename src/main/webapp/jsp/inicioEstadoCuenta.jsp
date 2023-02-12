<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css" media="all" />
<title>Insert title here</title>
</head>
<body>
	<div>
        <h1 class="center">Mi Chaucherita WEB</h1>
    </div>
    <div class="container">
        <form action="EstadoCuentaController?ruta=mostrarEstado&usarApi=1" method="post" id="estado-form">
            <input type="hidden" name="fechaInicial" id=""/>
            <input type="hidden" name="fechaFinal" id=""/>
            <select name="mes" id="" class="rounded">
            	<option value="1">Enero</option>
            	<option value="2">Febrero</option>
            	<option value="3">Marzo</option>
            	<option value="4">Abril</option>
            	<option value="5">Mayo</option>
            	<option value="6">Junio</option>
            	<option value="7">Julio</option>
            	<option value="8">Agosto</option>
            	<option value="9">Septiembre</option>
            	<option value="10">Octubre</option>
            	<option value="11">Noviembre</option>
            	<option value="12">Diciembre</option>           	
            </select>
            <select name="anio" id="" class="rounded">
            
            </select>
            <input type="submit" value="Consultar" />
        </form>
    </div>
    
    <br>
    <div class="headerEC">
        <h2 class="center"> Estado de Cuenta</h2>
        <a href="index.html">Regresar</a>
    </div>
    <br>
    
    
    <div class="container" id="cuentas-container">
        <div class="card">
            <h2 class="titulo_item">Cuentas de Entrada y Salida</h2>
            <hr />
            <div class="descripcion" id="cuentasIngresoEgreso">
            <c:forEach items="${estadoCuenta.cuentasIngresoEgreso}" var="cuenta">
                <div>
                    <h3>${cuenta.nombreCuenta}</h3>
                    <p>Total: $${cuenta.monto}</p>
                </div>                
            </c:forEach>
            </div>                
        </div>
    
        <div class="card">
            <h2 class="titulo_item">Cuentas de Gastos</h2>
            <hr />
            <div class="descripcion" id="cuentasEgresos">
            <c:forEach items="${estadoCuenta.cuentasEgresos}" var="cuenta">
                <div>
                    <h3>${cuenta.nombreCuenta}</h3>
                    <p>Total: $${cuenta.monto}</p>
                </div>          
            </c:forEach>
            </div>       
        </div>

        <div class="card">
			<h2 class="titulo_item">Cuentas de Ingreso</h2>
            <hr />
            <div class="descripcion" id="cuentasIngresos">
            <c:forEach items="${estadoCuenta.cuentasIngresos}" var="cuenta">
				<div>
                    <h3>${cuenta.nombreCuenta}</h3>
                    <p>Total: -$${cuenta.monto}</p>
                </div>                 
            </c:forEach>
            </div>       
        </div>

    </div>

    <div id="footer">
        <h3>Terminos y Condiciones</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, voluptas provident!
            Corrupti mollitia veritatis, pariatur eligendi autem rerum ipsum facere temporibus adipisci aut maxime
            necessitatibus officiis alias vel tenetur odio?</p>
        <p>Grupo 2 | Proyecti Mi Chaucherita WEB | <a href="https://www.epn.edu.ec">Escuela Politécnica
                Nacional</a></p>
    </div>
    <script src="js/estadocuenta.js"></script>
</body>
</html>