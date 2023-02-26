import { crearElementoTransaccion, createOption, crearTablaMovimientos } from "./elementos.js";
import { dateFormatter } from "./funciones.js";

const url = "GestionarMovimientosController?accion=listar";
const urlCuentas = "GestionarCuentasController?accion=listar";
const main = "GestionarMovimientosController?";
let form = document.querySelector("#nuevoMovimientoForm");

fetch(url).then(response => response.json())
.then(data => cargarTransacciones(data));

document.querySelector("#btnIngreso").addEventListener("click", mostrarIngresos, false);
document.querySelector("#btnGasto").addEventListener("click", mostrarGastos, false);
document.querySelector("#btnTraspaso").addEventListener("click", mostrarTraspaso, false);

function cargarTransacciones(transacciones) {
	var panel = document.querySelector("#panelMovimientos");
	panel.innerHTML = "";
	panel.appendChild(crearTablaMovimientos(transacciones));
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

function ocultar() {
	document.querySelector("#nuevoMovimientoForm").classList.toggle("d-none", true);
}
    	
function mostrar() {
	document.querySelector("#nuevoMovimientoForm").classList.toggle("d-none", false);
}

function mostrarIngresos() {
	form.elements["destino"].innerHTML = "";
	form.elements["origen"].innerHTML = "";
	form.action = main + "accion=registrarIngreso";
	fetch(urlCuentas)
	.then(response => response.json())
	.then(data => {
		data.forEach(cuenta => {
			switch(cuenta.tipo) {
				case "IE": 
					form.elements["destino"].appendChild(createOption(cuenta));
					break;
				case "I": 
					form.elements["origen"].appendChild(createOption(cuenta));
					break;
			}
		})
	})
	mostrar();
}

function mostrarGastos() {
	form.elements["destino"].innerHTML = "";
	form.elements["origen"].innerHTML = "";
	form.action = main + "accion=registrarEgreso";
	fetch(urlCuentas)
	.then(response => response.json())
	.then(data => {
		data.forEach(cuenta => {
			switch(cuenta.tipo) {
				case "IE": 
					form.elements["origen"].appendChild(createOption(cuenta));
					break;
				case "E": 
					form.elements["destino"].appendChild(createOption(cuenta));
					break;
			}
		})
	})
	mostrar();
}

function mostrarTraspaso() {
	form.elements["destino"].innerHTML = "";
	form.elements["origen"].innerHTML = "";
	form.action = main + "accion=registrarTraspaso";
	fetch(urlCuentas)
	.then(response => response.json())
	.then(data => {
		data.forEach(cuenta => {
			switch(cuenta.tipo) {
				case "IE": 
					form.elements["origen"].appendChild(createOption(cuenta));
					form.elements["destino"].appendChild(createOption(cuenta));			
			}
		})
	})
	mostrar();
}

function loadTransacciones() {
	fetch(url).then(response => response.json())
	.then(data => cargarTransacciones(data));
}

form.addEventListener("submit", (e) => {
	e.preventDefault();
	
	if(form.elements["origen"].value === form.elements["destino"].value) {
		alert("No se puede realizar un movimiento entre la misma cuenta");
		return;
	}
	
	fetch(form.action, {
		method: form.method,
		body: new URLSearchParams(new FormData(form))
	}).then(response => response.json())
	.then(data => {
		if(data.status === "ok") {
			loadTransacciones();
		}
	})
})

var date = new Date();
form.elements["fecha"].value = dateFormatter(date);

