<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="org.faviel.nutri.models.Patient" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nutri app | Editar paciente</title>

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
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/patients" class="active"><i class="fa-solid fa-person"></i><p>Pacientes</p></a></li>
                <li><a href="<%= request.getContextPath() %>/mode-evaluator/foods-catalog"><i class="fa-solid fa-utensils"></i><p>Alimentos</p></a></li>
            </ul>
            <ul>
                <li><a href="<%= request.getContextPath() %>/logout" class="logout"><i class="fa-solid fa-arrow-right-from-bracket"></i>Cerrar sesión</a></li>
            </ul>
        </nav>
    </aside>

    <%
        Patient patient = (Patient) request.getAttribute("patient");
    %>
    <main class="main-content">
        <header class="header-content">
            <h1>
                <a href="<%= request.getContextPath() %>/mode-evaluator/patients" class="link">Pacientes</a> / 
                <a href='<%= request.getContextPath() %>/mode-evaluator/patient-details?id=<%= patient.getId() %>' class="link">Detalles del paciente</a> / 
                <span>Editar</span>
            </h1>
            <a href="<%= request.getContextPath() %>/mode-evaluator/profile" title="Ir al perfil" class="a-profile">
                <p>FAVIO</p>
                <i class="fa-regular fa-circle-user"></i>
                <p class="mode">EVALUADOR</p>
            </a>
        </header>

        <section class="section-edit-patient">
            <form id="editPatientForm" action="<%= request.getContextPath() %>/mode-evaluator/patient-details/update" method="POST">
                
                <div class="info-principal">
                    <input type="hidden" name="id" value='<%= request.getParameter("id") %>'>
                    <div>
                        <label for="">Nombre(s)<span class="red">*</span></label>
                        <input type="text" name="name" value='<%= patient != null && patient.getName() != null ? patient.getName() : "" %>' required>
                    </div>
                    <div>
                        <label for="">Apellido paterno<span class="red">*</span></label>
                        <input type="text" name="pat-lastname" value='<%= patient != null && patient.getPatLastname() != null ? patient.getPatLastname() : "" %>' required>
                    </div>
                    <div>
                        <label for="">Apellido materno</label>
                        <input type="text" name="mat-lastname" value='<%= patient != null && patient.getMatLastname() != null ? patient.getMatLastname() : "" %>'>
                    </div>
                    <div>
                        <label for="">Género<span class="red">*</span></label>
                        <select name="gender">
                            <%
                                if (patient != null && patient.getGender() != null) {
                            %>
                                    <option value="">--Seleccione una opción--</option>
                                    <option value="Hombre" <%= patient.getGender().equals("Hombre") ? "selected" : "" %>>Hombre</option>
                                    <option value="Mujer" <%= patient.getGender().equals("Mujer") ? "selected" : "" %>>Mujer</option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div>
                        <label for="">Fecha de nacimiento</label>
                        <input type="date" name="birth" value='<%= patient != null && patient.getBirth() != null ? patient.getBirth().toString() : "" %>'>
                    </div>
                    <div>
                        <label for="">Altura (cm)</label>
                        <input type="number" name="height" value='<%= patient != null && patient.getHeight() != null ? patient.getHeight() : "" %>'>
                    </div>
                    <div>
                        <label for="">Peso (kg)</label>
                        <input type="number" step="0.1" name="weight" value='<%= patient != null && patient.getWeight() != null ? patient.getWeight() : "" %>'>
                    </div>
                    <div>
                        <label for="">Organización</label>
                        <input type="text" name="organization" value='<%= patient != null && patient.getOrganization() != null ? patient.getOrganization() : "" %>'>
                    </div>
                </div>
                
                <div class="separator-line"></div>

                <div class="info-extra">
                    <div>
                        <label for="">Código telefónico</label>
                        <select name="tel-country-code">
                            <option value="">--Seleccione una opción--</option>
                            <option value="+52">México: +52</option>
                        </select>
                    </div>
                    <div>
                        <label for="">Teléfono</label>
                        <input type="text" name="tel" value='<%= patient != null && patient.getTel() != null ? patient.getTel() : "" %>'>
                    </div>
                    <div>
                        <label for="">Email</label>
                        <input type="text" name="email" value='<%= patient != null && patient.getEmail() != null ? patient.getEmail() : "" %>'>
                    </div>
                    <div>
                        <label for="">Dirección</label>
                        <input type="text" name="address" value='<%= patient != null && patient.getAddress() != null ? patient.getAddress() : "" %>' placeholder="Calle y No.">
                    </div>
                    <div>
                        <label for="">Ciudad</label>
                        <input type="text" name="city" value='<%= patient != null && patient.getCity() != null ? patient.getCity() : "" %>'>
                    </div>
                    <div>
                        <label for="">Estado/Region</label>
                        <input type="text" name="region" value='<%= patient != null && patient.getRegion() != null ? patient.getRegion() : "" %>'>
                    </div>
                    <div>
                        <label for="">País<span class="red">*</span></label>
                        <select name="country" required>
                            <option value="">--Seleccione una opción--</option>
                            <option value="México">México</option>
                        </select>
                    </div>
                </div>

                <div class="separator-line"></div>

                <input type="submit" value="Guardar">

            </form>
        </section>
    </main>

    <!-- JS -->

    <script>

        document.addEventListener('DOMContentLoaded', () => {

            // Validate data form
            const validation = new JustValidate('#editPatientForm');

            validation
                .addField('[name="name"]', [
                    { rule: 'required', errorMessage: 'Este campo es obligatorio' },
                    { rule: 'minLength', value: 2, errorMessage: 'Debe tener al menos 2 caracteres' },
                    { rule: 'maxLength', value: 45, errorMessage: 'Máximo 45 caracteres' },
                ])
                .addField('[name="pat-lastname"]', [
                    { rule: 'required', errorMessage: 'Este campo es obligatorio' },
                    { rule: 'maxLength', value: 45, errorMessage: 'Máximo 45 caracteres' },
                ])
                .addField('[name="mat-lastname"]', [
                    { rule: 'maxLength', value: 45, errorMessage: 'Máximo 45 caracteres', },
                ]) 
                .addField('[name="gender"]', [
                    { rule: 'required', errorMessage: 'Debe seleccionar un género', },
                ])
                .addField('[name="height"]', [
                    { rule: 'number', errorMessage: 'Debe ser un número válido', },
                    { rule: 'minNumber', value: 40, errorMessage: 'Debe ser mayor a 40 cm', },
                    { rule: 'maxNumber', value: 250, errorMessage: 'Debe ser menor a 250 cm', },
                ])
                .addField('[name="weight"]', [
                    { rule: 'number', errorMessage: 'Debe ser un número válido', },
                    { rule: 'minNumber', value: 2, errorMessage: 'Debe ser mayor a 2 kg', },
                    { rule: 'maxNumber', value: 500, errorMessage: 'Debe ser menor a 700 kg', },
                ])
                .addField('[name="organization"]', [
                    { rule: 'maxLength', value: 100, errorMessage: 'Máximo 100 caracteres', },
                ])
                .addField('[name="tel"]', [
                    { rule: 'customRegexp', value: /^[0-9]{7,15}$/, errorMessage: 'Debe tener entre 7 y 15 dígitos' },
                ])
                .addField('[name="email"]', [
                    { rule: 'email', errorMessage: 'Debe ser un email válido' },
                    { rule: 'maxLength', value: 100, errorMessage: 'Máximo 100 caracteres' },
                ])
                .addField('[name="address"]', [
                    { rule: 'maxLength', value: 150, errorMessage: 'Máximo 150 caracteres' },
                ])
                .addField('[name="city"]', [
                    { rule: 'maxLength', value: 100, errorMessage: 'Máximo 50 caracteres' },
                ])
                .addField('[name="region"]', [
                    { rule: 'maxLength', value: 100, errorMessage: 'Máximo 50 caracteres' },
                ])
                .addField('[name="country"]', [
                    { rule: 'required', errorMessage: 'Debe seleccionar un país' },
                ])
                .onSuccess((event) => {
                    const btnSubmit = document.querySelector('form input[type="submit"]');
                    btnSubmit.disabled = true;
                    btnSubmit.value = 'Guardando...';

                    event.target.submit();
                })

        });

    </script>

</body>
</html>