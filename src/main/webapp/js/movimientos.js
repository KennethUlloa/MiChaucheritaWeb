import { crearElementoTransaccion, createOption } from "./elementos.js";

const url = "GestionarMovimientosController?accion=listar";
const url2 = "GestionarCuentasController?accion=listar";
let form = document.querySelector("#nuevoMovimientoForm");

fetch(url).then(response => response.json())
.then(data => cargarTransacciones(data));

fetch(url2).then(response => response.json())
.then(data => {
	data.forEach(cuenta => {
		console.log(cuenta);
		switch(cuenta.tipo) {
			case "IE": 
				form.elements["origen"].appendChild(createOption(cuenta));
				form.elements["destino"].appendChild(createOption(cuenta));
				break;
			case "E": 
				form.elements["destino"].appendChild(createOption(cuenta));
				break;
			case "I": 
				form.elements["origen"].appendChild(createOption(cuenta));
				break;
		}
	})
})

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

