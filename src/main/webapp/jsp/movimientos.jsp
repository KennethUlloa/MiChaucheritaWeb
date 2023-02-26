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
    <link rel="stylesheet" href="css/movimientos.css">
    <title>Movimientos</title>
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
                    <li class="selected"><a href="GestionarMovimientosController">Movimientos</a></li>
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
    <main class="w-100 flex-column ai-center p-5">
        <div class="flex-row">
        	<button class="btn m-2" id="btnIngreso">+ Ingreso</button>
        	<button class="btn m-2" id="btnGasto">+ Gasto</button>
        	<button class="btn m-2" id="btnTraspaso">+ Traspaso</button>
        </div>
        <form action="GestionarMovimientosController?accion=registrar" method="post" class="shadow rounded-3 p-4 m-3 d-none" id="nuevoMovimientoForm">
            <div class="col-2-auto w-100 mb-2">
                <div class="field mr-1">
                    <label for="origen">Cuenta origen</label>
                    <select name="origen" id="" class="input">
                        <!--option value="1">Banco</option>
                        <option value="2">Efectivo</option>
                        <option value="3">Nómina</option-->
                    </select>
                </div>
                <div class="field">
                    <label for="destino">Cuenta destino</label>
                    <select name="destino" id="" class="input">
                        <!--option value="1">Banco</option>
                        <option value="2">Efectivo</option>
                        <option value="3">Nómina</option-->
                    </select>
                </div>
            </div>
            
            <div class="flex-row">
            	<div class="field mr-1">
                    <label for="monto">Monto</label>
                    <input type="number" name="monto" min="0.0" step="0.01" placeholder="100.50" required>
                </div>
                <div class="field mr-1">
                    <label for="fecha">Fecha</label>
                    <input type="date" name="fecha" required>
                </div>
            </div>
            <div class="field mt-2">
                <label for="monto">Concepto</label>
                <input type="text" name="concepto" placeholder="Descripción del movimiento" required>
            </div>
            <div class="flex-row jc-end mt-2">
                <input type="submit" value="Guardar" class="btn mr-1">
                <input type="button" value="Cancelar" class="btn secondary" onclick="ocultar()">
            </div>
        </form>
        <form action="GestionarMovimientosController?accion=listar" method="post" id="rangoFechasForm" class="shadow rounded-3 p-4 m-3 w-80">
            <label for="inicio">Inicio</label>
            <input type="date" name="inicio" class="input">
            <label for="fin">Fin</label>
            <input type="date" name="fin" class="input">
            <input type="submit" value="Consultar" class="btn ml-1">
        </form>
        <div class="shadow rounded-3 p-5 m-3 flex-column ai-center w-80">
            <h2 class="mb-2">Movimientos realizados</h2>
            <div id="panelMovimientos" class="w-100">
	            
            </div>        
        </div>
    </main>
    <script src="js/movimientos.js" type="module"></script>
    <script>
    	function ocultar() {
    		document.querySelector("#nuevoMovimientoForm").classList.toggle("d-none", true);
    	}
    	
    	function mostrar() {
    		document.querySelector("#nuevoMovimientoForm").classList.toggle("d-none", false);
    	}
    </script>
</body>
</html>