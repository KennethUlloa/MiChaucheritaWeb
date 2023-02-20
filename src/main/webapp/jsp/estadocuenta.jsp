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
        <div class="flex-row ai-center">
            <h4 class="mr-2">${sessionScope.usuario}</h4>     
                <a href="LogOutController" class="">
                    <i class="fa-solid fa-arrow-right-from-bracket fa-2xl c-darkgreen"></i>
                </a>
        </div>
    </header>
    <main class="flex-column ai-center w-100">
        <form action="" class="my-3">
            <label for="mes">Mes</label>
            <input type="number" name="mes" id="" class="input" min="1" max="12" step="1" value="2">
            <label for="anio">Año</label>
            <input type="number" name="anio" id="" class="input" min="1900" max="2100" value="2023">
            <input type="submit" value="Generar" class="btn ml-1">
        </form>
        <h1 class="bg-green c-white w-100 p-3 txt-center">Estado de cuenta</h1>
        <section class="bg-lightgray w-100 p-4 my-4 flex-row jc-center">
            <div class="col-3 w-80">
                <div class="p-4 bg-white rounded-3 flex-column shadow mx-2">
                    <div class="flex-row jc-center ai-center">
                        <span class="ml-3 flex-row">
                            <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                            <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                        </span>
                        <h4 class="c-darkgreen ml-2">Ingresos y gastos</h4>
                    </div>
                    <div class="flex-row ai-center">
                        <h4 class="txt-b mr-2">Banco</h4>
                        <p>$500</p>
                    </div>
                    <div class="flex-row ai-center">
                        <h4 class="txt-b mr-2">Efectivo</h4>
                        <p>$50</p>
                    </div>
                </div>
                <div class="p-4 bg-white rounded-3 flex-column shadow mx-2">
                    <div class="flex-row jc-center">
                        <span class="ml-3">
                            <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                        </span>
                        <h4 class="c-darkgreen ml-2">Gastos</h4>
                    </div>
                    <div class="flex-row ai-center">
                        <h4 class="txt-b mr-2">Universidad</h4>
                        <p>-$100</p>
                    </div>
                    <div class="flex-row ai-center">
                        <h4 class="txt-b mr-2">Regalo</h4>
                        <p>-$50</p>
                    </div>
                </div>
                <div class="p-4 bg-white rounded-3 flex-column shadow mx-2">
                    <div class="flex-row jc-center">
                        <span class="ml-3">
                            <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                        </span>
                        <h4 class="c-darkgreen ml-2">Ingresos</h4>
                    </div>
                    <div class="flex-row ai-center">
                        <h4 class="txt-b mr-2">Nómina</h4>
                        <p>$1000</p>
                    </div>
                </div>
                
            </div>
        </section>
        
		<div class="shadow rounded-3 p-5 m-3 flex-column ai-center w-80">
            <h2 class="mb-2">Movimientos realizados</h2>
            <div id="panelMovimientos" class="w-100">
	            <!--div class="w-100 flex-column" >
	                <div class="flex-row sp-between">
	                    <div>
	                        <span class="txt-i txt-b">17/02/2023</span>
	                        <span>Desde </span>
	                        <span class="c-darkgreen txt-b">Banco</span>
	                        <span>hacia </span>
	                        <span class="c-darkgreen txt-b">Efectivo</span>
	                    </div>
	                    <p class="c-darkgreen txt-b ml-2">$1000</p>
	                </div>
	                <p class="txt-li">Transferencia entre cuentas</p>
	            </div-->
            </div>        
        </div>
    </main>
    <script src="js/estadocuenta.js" type="module"></script>
</body>
</html>