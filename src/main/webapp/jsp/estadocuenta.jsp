<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/x-icon">
    <script src="https://kit.fontawesome.com/f9e2e8e2a6.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/lib.css">
    <link rel="stylesheet" href="css/estadocuenta.css">
    <title>Estado de Cuenta</title>
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
                    <li><a href="HomePageController">Inicio</a></li>
                    <li><a href="GestionarMovimientosController">Movimientos</a></li>
                    <li><a href="GestionarCuentasController">Cuentas</a></li>
                    <li class="selected"><a href="GestionarEstadoCuentaController">Estado de Cuenta</a></li>
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
    <main class="flex-column ai-center w-100">
        <form action="GestionarEstadoCuentaController?accion=crear" method="post" class="my-3" id="panelEstadoCuenta">
            <label for="mes">Mes</label>
            <input type="number" name="mes" id="" class="input" min="1" max="12" step="1" value="2">
            <label for="anio">Año</label>
            <input type="number" name="anio" id="" class="input" min="1900" max="2100" value="2023">
            <input type="submit" value="Generar" class="btn ml-1">
        </form>
        <h1 class="bg-green c-white w-100 p-3 txt-center">Estado de cuenta</h1>
        <section class="bg-lightgray w-100 p-4 my-4 flex-row jc-center d-none-i" id="panelCuentas">
            <div class="flex-column w-100">
                <div class="p-4 bg-white rounded-3 flex-column shadow m-2">
                    <div class="flex-row jc-center ai-center">
                        <span class="ml-3 flex-row">
                            <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                            <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                        </span>
                        <h4 class="c-darkgreen ml-2">Ingresos y gastos</h4>
                    </div>
                    <div class="" id="panelIngresosGastos">
                    </div>
                </div>
                <div class="p-4 bg-white rounded-3 flex-column shadow m-2">
                    <div class="flex-row jc-center">
                        <span class="ml-3">
                            <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                        </span>
                        <h4 class="c-darkgreen ml-2">Gastos</h4>
                    </div>
                    <div class="" id="panelGastos">
                    </div>
                </div>
                <div class="p-4 bg-white rounded-3 flex-column shadow m-2">
                    <div class="flex-row jc-center">
                        <span class="ml-3">
                            <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                        </span>
                        <h4 class="c-darkgreen ml-2">Ingresos</h4>
                    </div>
                    <div class="" id="panelIngresos">
                    </div>
                </div>
                
            </div>
            
            <div class="d-none-i shadow rounded-3 p-5 m-2 flex-column ai-center w-100 bg-white" id="panelMovimientosUp">
            	<h2 class="mb-2">Movimientos realizados</h2>
            	<div id="panelMovimientos" class="w-100">
	            
            	</div>        
        	</div>
            
        </section>
        
		
    </main>
    <script src="js/estadocuenta.js" type="module"></script>
</body>
</html>