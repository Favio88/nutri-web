<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nutri | Perfil</title>

    <!-- Fontawesome icons -->
    <script src="https://kit.fontawesome.com/c09ae347fc.js" crossorigin="anonymous"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/styles.css">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>

    <aside class="sidebar">
        <div class="container-nutri-logo">
            <img src="../images/logo-nutri-white-small.png" alt="Logotipo de...">
            <span>Nombre de la app</span>
        </div>
        <nav class="nav">
            <ul>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/profile" class="active"><i class="fa-regular fa-circle-user"></i><p>Mi perfil</p></a></li>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/patients"><i class="fa-solid fa-person"></i><p>Pacientes</p></a></li>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/foods-catalog"><i class="fa-solid fa-utensils"></i><p>Alimentos</p></a></li>
            </ul>
            <ul>
                <li><a href="<%= request.getContextPath() %>/logout" class="logout"><i class="fa-solid fa-arrow-right-from-bracket"></i>Cerrar sesión</a></li>
            </ul>
        </nav>
    </aside>
    
</body>
</html>