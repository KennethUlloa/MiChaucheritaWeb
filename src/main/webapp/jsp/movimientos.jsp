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
    <link rel="stylesheet" href="css/movimientos.css">
    <title>Movimientos</title>
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
                    <li class="selected"><a href="GestionarMovimientosController">Movimientos</a></li>
                    <li><a href="GestionarCuentasController">Cuentas</a></li>
                    <li><a href="GestionarEstadoCuentaController">Estado de Cuenta</a></li>
                </ul>
            </nav>
        </div>
        <div class="flex-row ai-center">
            <h4 class="mr-2">Usuario</h4>     
                <a href="login.html" class="">
                    <i class="fa-solid fa-arrow-right-from-bracket fa-2xl c-darkgreen"></i>
                </a>
            </i>
        </div>
    </header>
    <main class="w-100 flex-column ai-center p-5">
        <button class="btn m-2">+ Movimiento</button>
        <form action="" class="shadow rounded-3 p-4 m-3">
            <div class="flex-row">
                <div class="field mr-1">
                    <label for="monto">Monto</label>
                    <input type="number" name="monto" min="0.0" step="0.01" placeholder="100.50">
                </div>
                <div class="field mr-1">
                    <label for="origen">Cuenta origen</label>
                    <select name="origen" id="" class="input">
                        <option value="1">Banco</option>
                        <option value="2">Efectivo</option>
                        <option value="3">Nómina</option>
                    </select>
                </div>
                <div class="field">
                    <label for="destino">Cuenta destino</label>
                    <select name="destino" id="" class="input">
                        <option value="1">Banco</option>
                        <option value="2">Efectivo</option>
                        <option value="3">Nómina</option>
                    </select>
                </div>
            </div>
            <div class="field mt-2">
                <label for="monto">Concepto</label>
                <input type="text" name="concepto" placeholder="Descripción del movimiento">
            </div>
            <div class="flex-row jc-end mt-2">
                <input type="submit" value="Guardar" class="btn mr-1">
                <input type="button" value="Cancelar" class="btn secondary">
            </div>
        </form>
        <form action="" class="shadow rounded-3 p-4 m-3 w-80">
            <label for="inicio">Inicio</label>
            <input type="date" name="inicio" class="input">
            <label for="fin">Fin</label>
            <input type="date" name="fin" class="input">
            <input type="submit" value="Consultar" class="btn ml-1">
        </form>
        <div class="shadow rounded-3 p-5 m-3 flex-column ai-center w-80">
            <h2>Movimientos realizados</h2>
            <div class="w-100">
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
            </div>
        </div>
    </main>
</body>
</html>