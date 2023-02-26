import { currencyFormatter } from "./funciones.js";
export function crearElementoTransaccion(transaccion) {
	var div = document.createElement('tr');
	//div.className = "w-100 flex-column mt-1";
	/*div.innerHTML = `<div class="flex-row sp-between">
	                    <div>
	                        <span class="txt-i txt-b">${transaccion.fecha}</span>
	                        <span>Desde </span>
	                        <span class="c-darkgreen txt-b">${transaccion.origen.nombre}</span>
	                        <span>hacia </span>
	                        <span class="c-darkgreen txt-b">${transaccion.destino.nombre}</span>
	                    </div>
	                    <p class="c-darkgreen txt-b ml-2">${currencyFormatter(transaccion.monto)}</p>
	                </div>
	                <p class="txt-li">${transaccion.concepto}</p>`;*/
	 div.innerHTML = `<td class="txt-i">${transaccion.fecha}</td>
	                	<td class="c-darkgreen txt-b">${transaccion.origen.nombre}</td>
	                	<td class="c-darkgreen txt-b">${transaccion.destino.nombre}</td>
	                	<td >${transaccion.concepto}</td>
	                	<td class="c-darkgreen txt-b">${currencyFormatter(transaccion.monto)}</td>`;
	return div;
}

export function crearTablaMovimientos(transacciones) {
	var table = document.createElement('table');
	table.className = "w-100";
	table.innerHTML = `
		<th>Fecha</th>
		<th>Origen</th>
		<th>Destino</th>
		<th>Concepto</th>
		<th>Monto</th>`
	transacciones.forEach(transaccion => {
		table.appendChild(crearElementoTransaccion(transaccion));
	});
	
	return table;
}

export function createOption(cuenta) {
	var option = document.createElement("option");
	option.value = cuenta.numero;
	option.textContent = cuenta.nombre;
	return option;
}