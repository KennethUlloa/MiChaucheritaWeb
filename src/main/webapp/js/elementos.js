import { currencyFormatter } from "./funciones.js";
export function crearElementoTransaccion(transaccion) {
	var div = document.createElement('div');
	div.className = "w-100 flex-column mt-1";
	div.innerHTML = `<div class="flex-row sp-between">
	                    <div>
	                        <span class="txt-i txt-b">${transaccion.fecha}</span>
	                        <span>Desde </span>
	                        <span class="c-darkgreen txt-b">${transaccion.origen.nombre}</span>
	                        <span>hacia </span>
	                        <span class="c-darkgreen txt-b">${transaccion.destino.nombre}</span>
	                    </div>
	                    <p class="c-darkgreen txt-b ml-2">${currencyFormatter(transaccion.monto)}</p>
	                </div>
	                <p class="txt-li">${transaccion.concepto}</p>`;
	return div;
}

export function createOption(cuenta) {
	var option = document.createElement("option");
	option.value = cuenta.numero;
	option.textContent = cuenta.nombre;
	return option;
}