const url = "GestionarCuentasController?accion=listar";

fetch(url).then(response => response.json())
.then(data => {
	data.forEach(cuenta => {
		switch(cuenta.tipo) {
			case "IE": 
				document.querySelector("#panelIngresosGastos").appendChild(crearCartaCuentaIngresoGasto(cuenta));
				break;
			case "E": 
				document.querySelector("#panelGastos").appendChild(crearCartaCuentaGasto(cuenta));
				break;
			case "I": 
				document.querySelector("#panelIngresos").appendChild(crearCartaCuentaIngreso(cuenta));
				break;
		}
	})
})

function cargarCuentas() {
	
}

function crearCartaCuentaIngresoGasto(cuenta) {
	var div = document.createElement('div');
	div.className = "shadow rounded-3 bg-white p-4 w-fit m-2";
	div.innerHTML =  `<div class="flex-row">
                            <h4 class="c-darkgreen">${cuenta.nombre}</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                                <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                            </span>
                        </div>`;
	return div; 
}

function crearCartaCuentaIngreso(cuenta) {
	var div = document.createElement('div');
	div.className = "shadow rounded-3 bg-white p-4 w-fit m-2";
	div.innerHTML =  `<div class="flex-row">
                            <h4 class="c-darkgreen">${cuenta.nombre}</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                            </span>
                        </div>`;
	return div; 
}

function crearCartaCuentaGasto(cuenta) {
	var div = document.createElement('div');
	div.className = "shadow rounded-3 bg-white p-4 w-fit m-2";
	div.innerHTML =  `<div class="flex-row">
                            <h4 class="c-darkgreen">${cuenta.nombre}</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                            </span>
                        </div>`;
	return div;                       
}

function mostrarCrearCuenta() {
	document.querySelector("#crearCuentaForm").classList.toggle("d-none", false);
}

function ocultarCrearCuenta() {
	document.querySelector("#crearCuentaForm").classList.toggle("d-none", true);
}