import {crearTablaMovimientos} from "./elementos.js";
import { currencyFormatter } from "./funciones.js";

let form = document.querySelector("#panelEstadoCuenta");

form.addEventListener('submit', (e) => {
	e.preventDefault();
	document.querySelector("#panelCuentas").classList.toggle("d-none-i", false);
	document.querySelector("#panelMovimientosUp").classList.toggle("d-none-i", false);
	fetch(form.action, {
		method: form.method,
		body: new URLSearchParams(new FormData(form))
	}).then(response => response.json())
	.then(data => {
		console.log(data);
		var pCuentasIngresosGastos = document.querySelector("#panelIngresosGastos");
		var pCuentasIngresos = document.querySelector("#panelIngresos");
		var pCuentasGastos = document.querySelector("#panelGastos");
		cargarTransacciones(data.transacciones);
		pCuentasIngresosGastos.innerHTML = "";
		pCuentasIngresos.innerHTML = "";
		pCuentasGastos.innerHTML = "";
		data.cuentasIngreso.forEach(cuenta => {
			pCuentasIngresos.appendChild(cardCuenta(cuenta));
		});
		data.cuentasIngresoEgreso.forEach(cuenta => {
			pCuentasIngresosGastos.appendChild(cardCuenta(cuenta));
		});
		data.cuentasEgreso.forEach(cuenta => {
			pCuentasGastos.appendChild(cardCuenta(cuenta));
		});
	})
});


function cargarTransacciones(transacciones) {
	var panel = document.querySelector("#panelMovimientos");
	panel.innerHTML = "";
	panel.appendChild(crearTablaMovimientos(transacciones));
}

function cardCuenta(cuenta) {
	var div = document.createElement('div');
	div.className = "flex-row ai-center";
	div.innerHTML =`<h4 class="txt-b mr-2">${cuenta.nombre}</h4><p>${currencyFormatter(cuenta.monto)}</p>`;
	return div;
}
