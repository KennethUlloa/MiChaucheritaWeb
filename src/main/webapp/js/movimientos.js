import { crearElementoTransaccion } from "./elementos.js";

const url = "GestionarMovimientosController?accion=listar";

fetch(url).then(response => response.json())
.then(data => cargarTransacciones(data));

function cargarTransacciones(transacciones) {
	var panel = document.querySelector("#panelMovimientos");
	panel.innerHTML = "";
	transacciones.forEach(transaccion => {
		panel.appendChild(crearElementoTransaccion(transaccion));
	})
}


let rangoForm = document.querySelector("#rangoFechasForm");
rangoForm.addEventListener("submit", (e) => {
	e.preventDefault();
	fetch(rangoForm.action, {
		method: rangoForm.method,
		body: new URLSearchParams(new FormData(rangoForm))
		})
	.then(response => response.json())
	.then(data => cargarTransacciones(data));
	
});

