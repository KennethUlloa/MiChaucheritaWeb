<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/styleInicioTransaccion.css" />
    <title>Transacciones</title>
</head>

<body>
    <section class="header border-styled">
        <a href="index.html">Regresar</a>
        <h1>Mi Chaucherita</h1>
    </section>
    <section class="main">
        <div class="transaction-main-container">
            <h1>Transacciones</h1>
            <form action="GestionarMovimientosController?ruta=listarTransaccion" method="post">
                <fieldset class="container-date-inputs non-border">
                    <label for="fechaInicial">Fecha inicial: </label>
                    <input type="date" name="fechaInicial" id="" />
                    <label for="fechaFinal">Fecha Final: </label>
                    <input type="date" name="fechaFinal" id="" />
                    <input class="btn-styled" type="submit" value="Consultar" />
                </fieldset>
            </form>
        </div>
        <div class="movimientos-container">
            <h2>Movimientos</h2>
            <table class="transactions-table">
                <caption>
                    Lista de Movimientos
                </caption>
                <colgroup>
                    <col class="col-1" />
                    <col class="col-2" />
                    <col class="col-3" />
                    <col class="col-4" />
                    <col class="col-5" />
                    <col class="col-6" />
                </colgroup>
                <tr>
                    <thead>
                        <th>Id</th>
                        <th>Origen</th>
                        <th>Destino</th>
                        <th>Concepto</th>
                        <th>Monto</th>
                        <th>Fecha</th>
                    </thead>
                </tr>
                <c:forEach items="${transacciones}" var="transaccion">
                    <tr>
                        <td>${transaccion.id}</td>
                        <td>${transaccion.origen.nombreCuenta}</td>
                        <td>${transaccion.destino.nombreCuenta}</td>
                        <td>${transaccion.concepto}</td>
                        <td>${transaccion.monto}</td>
                        <td>${transaccion.fecha}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="registro-transaccion-container">
            <h2>Realizar transacción</h2>
            <form action="GestionarMovimientosController?ruta=registroTransaccion" method="post">
                <fieldset class="transaction-inpunts non-border" >
                    <div class="transactions-inpunts-1st-row">
                        <div>
                            <label for="cuentaOrigen">Cuenta Origen:</label>
                            <select name="cuentaOrigen" required>
                                <c:forEach items="${cuentas}" var="cuenta">
                                    <option value="${cuenta.numeroCuenta}">
                                        ${cuenta.nombreCuenta}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="cuentaDestino">Cuenta Destino: </label>
                            <select name="cuentaDestino" required>
                                <c:forEach items="${cuentas}" var="cuenta">
                                    <option value="${cuenta.numeroCuenta}">
                                        ${cuenta.nombreCuenta}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="monto">Monto: </label>
                            <input type="number" name="monto" id="" min="0" required />
                        </div>
                    </div>
                    <div class="transactions-inpunts-2nd-row">
                        <div>
                            <label for="concepto">Concepto: </label>
                            <input type="text" name="concepto" id="" required />
                        </div>
                        
                    </div>
                    <div id="fecha-transaccion-registro">
                        <label for="fecha">Fecha: </label>
                        <input type="date" name="fecha"  required />
                    </div>
                    <div class="btn-save-transaction">
                        <input  class="btn-styled" type="submit" value="Guardar" />
                    </div>
                    
                </fieldset>
            </form>
        </div>
    </section>
    <section id="footer" class="border-styled txt-primary-color bg-primary-color fixed-bottom">
        <h3>Términos y Condiciones</h3>
        <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem,
            voluptas provident! Corrupti mollitia veritatis, pariatur eligendi autem
            rerum ipsum facere temporibus adipisci aut maxime necessitatibus
            officiis alias vel tenetur odio?
        </p>
        <p>
            Grupo 2 | Proyecto "Mi Chaucherita WEB" |
            <a href="https://www.epn.edu.ec">Escuela Politécnica Nacional</a>
        </p>
    </section>
</html>