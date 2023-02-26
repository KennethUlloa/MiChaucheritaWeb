<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/x-icon">
    <script src="https://kit.fontawesome.com/f9e2e8e2a6.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/lib.css">
    <link rel="stylesheet" href="css/inicio.css">
    <title>Inicio</title>
</head>
<body>
    <header class="p-2 flex-row w-100 sp-between">
        <div class="flex-row">
            <div class="flex-row ai-center">
                <img src="img/icon.png" alt="Logo Mi Chaucherita Web" class="min-logo mr-2" >
                <h4 class="">Mi Chaucherita Web</h4>
            </div>
            <nav class="ml-2 flex-row">
                <ul class="menu">
                    <li class="selected"><a href="HomePageController">Inicio</a></li>
                    <li><a href="GestionarMovimientosController">Movimientos</a></li>
                    <li><a href="GestionarCuentasController">Cuentas</a></li>
                    <li><a href="GestionarEstadoCuentaController">Estado de Cuenta</a></li>
                </ul>
            </nav>
        </div>
        <div class="flex-row ai-center popup-target">
            <h4 class="mr-2">${sessionScope.usuario.nombre}</h4>     
                
            <div class="popup">
            	<div>
	            	<a href="LogOutController" class="flex-row">
	            	Salir
	                    <span class="ml-1">
	                    	<i class="fa-solid fa-arrow-right-from-bracket fa-lg c-darkgreen"></i>
	                    </span>
	                </a>
            	</div>
            </div>
        </div>
    </header>
    <main>
    	<div class="c-green p-5">
    		<h1 class="c-darkgreen">Bienvenido, ${sessionScope.usuario.nombre}</h1>
    	</div>
    	<div class="bg-lightgray w-100 flex-row jc-center py-5">
    		<div class="col-3 gap-5 w-80">
    		<div class="shadow p-5 bg-white rounded-3 c-darkgreen flex-column ai-center">
    			<a href="GestionarEstadoCuentaController">
    				<img src="img/estado-financiero.png" alt="icono estado financiero" width="150" height="150" class="filtered"/>
    			</a>
    			<h1 class="mt-3 c-darkgreen txt-center">Estado de Cuenta</h1>
    		</div>
    		
    		<div class="shadow p-5 bg-white rounded-3 c-darkgreen flex-column ai-center">
    			<a href="GestionarMovimientosController">
    				<img src="img/cuenta-bancaria.png" alt="icono estado financiero" width="150" height="150" class="filtered"/>
    			</a>
    			<h1 class="mt-3 c-darkgreen txt-center">Movimientos</h1>
    		</div>
    		
    		<div class="shadow p-5 bg-white rounded-3 c-darkgreen flex-column ai-center">
    			<a href="GestionarCuentasController">
    				<img src="img/pagar.png" alt="icono estado financiero" width="150" height="150" class="filtered"/>
    			</a>
    			<h1 class="mt-3 c-darkgreen txt-center">Cuentas</h1>
    		</div>
    	</div>
    	</div>
    </main>
    <script src="js/inicio.js" type="module"></script>
</body>
</html>