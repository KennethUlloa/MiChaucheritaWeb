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
    <link rel="stylesheet" href="css/cuentas.css">
    <title>Cuentas</title>
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
                    <li><a href="GestionarMovimientosController">Movimientos</a></li>
                    <li class="selected"><a href="GestionarCuentasController">Cuentas</a></li>
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
    <main class="w-100 flex-column ai-center">
        <div class="w-80 flex-column">
            <button class="btn mb-3 w-fit">Crear cuenta</button>
            <form action="" class="shadow rounded-3 p-4 w-fit my-3">
                <div class="flex-row">
                    <div class="field">
                        <label for="nombreCuenta">Nombre de cuenta</label>
                        <input type="text" name="nombreCuenta" placeholder="Nombre de la cuenta">
                    </div>
                    <div class="field ml-2">
                        <label for="tipoCuenta">Tipo</label>
                        <select name="tipoCuenta" id="" class="input">
                            <option value="1">Ingreso y gasto</option>
                            <option value="2">Ingreso</option>
                            <option value="3">Gasto</option>
                        </select>
                    </div>
                </div>
                <div class="flex-row jc-end mt-2">
                    <input type="submit" value="Guardar" class="btn mr-1">
                    <input type="button" value="Cancelar" class="btn secondary">
                </div>
            </form>
            <div class="bg-lightgray w-100 p-3 rounded-3 my-3 flex-column">
                <h4 class="m-1">Ingresos y Gastos</h4>
                <div class="flex-row">
                    <div class="shadow rounded-3 bg-white p-4 w-fit m-2">
                        <div class="flex-row">
                            <h4 class="c-darkgreen">Efectivo</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                                <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                            </span>
                        </div>
                    </div>
                    <div class="shadow rounded-3 bg-white p-4 w-fit m-2">
                        <div class="flex-row">
                            <h4 class="c-darkgreen">Banco</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                                <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bg-lightgray w-100 p-3 rounded-3 my-3 flex-column">
                <h4 class="m-1">Ingresos</h4>
                <div class="flex-row">
                    <div class="shadow rounded-3 bg-white p-4 w-fit m-2">
                        <div class="flex-row">
                            <h4 class="c-darkgreen">Nómina</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-down-long c-darkgreen"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="bg-lightgray w-100 p-3 rounded-3 my-3 flex-column">
                <h4 class="m-1">Gastos</h4>
                <div class="flex-row">
                    <div class="shadow rounded-3 bg-white p-4 w-fit m-2">
                        <div class="flex-row">
                            <h4 class="c-darkgreen">Universidad</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                            </span>
                        </div>
                    </div>
                    <div class="shadow rounded-3 bg-white p-4 w-fit m-2">
                        <div class="flex-row">
                            <h4 class="c-darkgreen">Regalos</h4>
                            <span class="ml-3">
                                <i class="fa-solid fa-arrow-up-long c-darkgreen"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>