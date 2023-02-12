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
        <form action="EstadoCuentaController?ruta=mostrarEstado" method="post">
            <span>Fecha de Inicio:</span><input type="date" name="fechaInicial" id="" required/>
            <span>Fecha de Fin:</span><input type="date" name="fechaFinal" id="" required/>
            <input type="submit" value="Consultar" />
        </form>
    </div>
    
    <br>
    <div class="headerEC">
        <h2 class="center"> Estado de Cuenta</h2>
        <a href="http://localhost:8080/MiChaucheritaWeb/">Regresar</a>
    </div>
    <br>
    
    
    <div class="container">
        <div class="card">
            <div class="titulo_item">Cuentas de Entrada y Salida</div>
            <div class="descripcion">
            <c:forEach items="${estadoCuenta.cuentasIngresoEgreso}" var="cuenta">
                <div>
                    <div>Nombre de Cuenta: ${cuenta.nombreCuenta}</div>
                    <div>Monto: ${cuenta.monto}</div>
                </div>
                </br>
            </c:forEach>
            </div>
            </br>
            
        </div>
    
        <div class="card">
            <div class="titulo_item">Cuentas de Gasto</div>
            <div class="descripcion">
            <c:forEach items="${estadoCuenta.cuentasEgresos}" var="cuenta">
                <div>
                    <div>Nombre de Cuenta: ${cuenta.nombreCuenta}</div>
                    <div>Monto: ${cuenta.monto}</div>
                </div>
                </br>
            </c:forEach>
            </div>
            </br>
        </div>

        <div class="card">
            
            <div class="titulo_item">Cuentas de Ingreso</div>
            <div class="descripcion">
            <c:forEach items="${estadoCuenta.cuentasIngresos}" var="cuenta">
                <div>
                    <div>Nombre de Cuenta: ${cuenta.nombreCuenta}</div>
                    <div>Monto: ${cuenta.monto}</div>
                </div>
            	</br>    
            </c:forEach>
            </div>
            </br>
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
</body>
</html>