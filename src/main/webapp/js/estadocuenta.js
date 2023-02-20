import { crearElementoTransaccion } from "./elementos.js";

fetch("GestionarMovimientosController?accion=listar", {
	method: 'post'
}).then(response => response.json())
.then(data => cargarTransacciones(data));

function cargarTransacciones(transacciones) {
	var panel = document.querySelector("#panelMovimientos");
	panel.innerHTML = "";
	transacciones.forEach(transaccion => {
		panel.appendChild(crearElementoTransaccion(transaccion));
	})
}
