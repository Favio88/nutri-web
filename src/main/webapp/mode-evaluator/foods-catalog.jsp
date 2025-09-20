<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nutri | Alimentos</title>

    <!-- Fontawesome icons -->
    <script src="https://kit.fontawesome.com/c09ae347fc.js" crossorigin="anonymous"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <!-- JustValidate library -->
    <script src="https://unpkg.com/just-validate@latest/dist/just-validate.production.min.js"></script>

</head>
<body>
    
    <aside class="sidebar">
        <div class="container-nutri-logo">
            <img src="<%= request.getContextPath() %>/images/logo-nutri-white-small.png" alt="Logotipo de...">
            <span>Nombre de la app</span>
        </div>
        <nav class="nav">
            <ul>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/profile"><i class="fa-regular fa-circle-user"></i><p>Mi perfil</p></a></li>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/patients"><i class="fa-solid fa-person"></i><p>Pacientes</p></a></li>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/foods-catalog" class="active"><i class="fa-solid fa-utensils"></i><p>Alimentos</p></a></li>
            </ul>
            <ul>
                <li><a href="<%= request.getContextPath() %>/logout" class="logout"><i class="fa-solid fa-arrow-right-from-bracket"></i>Cerrar sesión</a></li>
            </ul>
        </nav>
    </aside>

    <main class="main-content">
        <header class="header-content">
            <h1>Alimentos</h1>
            <a href="<%= request.getContextPath() %>/mode-evaluator/profile" title="Ir al perfil" class="a-profile">
                <p>FAVIO</p>
                <i class="fa-regular fa-circle-user"></i>
                <p class="mode">EVALUADOR</p>
            </a>
        </header>
        <section class="section-foods-catalog">
            <div class="tabs">
                <a href="" class="active">Catálogo de alimentos</a>
                <a href="<%= request.getContextPath() %>/mode-evaluator/foods-user">Mis alimentos</a>
            </div>
            <div class="content">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="text-left">Nombre</th>
                            <th>Grupo</th>
                            <th>Origen</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>
    </main>

</body>
</html>