<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/icon.png" type="image/x-icon">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/lib.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Log In</title>
</head>
<body>
    <main class="flex-column ai-center jc-center">
        <div class="p-5 py-4 shadow rounded-3">
            <div class="flex-column ai-center">
                <img src="img/icon.png" alt="Logo Mi Chaucherita Web" class="logo" >
                <h1 class="m-1 txt-li f-1">Mi Chaucherita Web</h1>
                <h3 class="m-2 txt-li f-2">Ingresa tus credenciales</h3>
            </div>
            <form action="LogInController?accion=autenticar" method="post" id="loginForm">
                <div class="flex-column">
                    <label for="usuario">Usuario</label>
                    <input type="text" name="usuario"  placeholder="user1234" class="input mt-1" required>
                </div>
                <div class="flex-column mt-2">
                    <label for="clave">Contraseña</label>
                    <input type="password" name="clave" placeholder="Contraseña12345" class="input mt-1" required>
                </div>
                <div class="flex-row jc-center txt-i m-3">
                    <a href="" class="link">¿No tienes una cuenta? Regístrate</a>
                </div>
                <input type="submit" value="Ingresar" class="btn w-100">
            </form>
        </div>
    </main>
    <script src="js/login.js"></script>
</body>
</html>