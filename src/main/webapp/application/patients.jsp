<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="org.faviel.nutri.models.Patient" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nutri | Pacientes</title>

    <!-- Fontawesome icons -->
    <script src="https://kit.fontawesome.com/c09ae347fc.js" crossorigin="anonymous"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/styles.css">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <!-- JustValidate library -->
    <script src="https://unpkg.com/just-validate@latest/dist/just-validate.production.min.js"></script>

</head>
<body>

    <% // Alert messages %>
    <%
        String successMessage = (String) session.getAttribute("success-message");
        String errorMessage = (String) session.getAttribute("error-message");

        if (successMessage != null || errorMessage != null) {
    %>
            <div id="alertMessage" class='<%= successMessage != null ? "alert alert-success" : "alert alert-danger" %>'>
                <%= successMessage != null ? successMessage : errorMessage %>
            </div>
    <%
            session.removeAttribute("success-message");
            session.removeAttribute("error-message");
        }
    %>
    
    <aside class="sidebar">
        <div class="container-nutri-logo">
            <img src="../images/logo-nutri-white-small.png" alt="Logotipo de...">
            <span>Nombre de la app</span>
        </div>
        <nav class="nav">
            <ul>
                <li><a href="<%= request.getContextPath() %>/application/profile.html"><i class="fa-regular fa-circle-user"></i><p>Mi perfil</p></a></li>
                <li><a href="<%= request.getContextPath() %>/application/patients" class="active"><i class="fa-solid fa-person"></i><p>Pacientes</p></a></li>
                <li><a href="<%= request.getContextPath() %>/application/foods.html"><i class="fa-solid fa-utensils"></i><p>Alimentos</p></a></li>
            </ul>
            <ul>
                <li><a href="<%= request.getContextPath() %>/logout" class="logout"><i class="fa-solid fa-arrow-right-from-bracket"></i>Cerrar sesión</a></li>
            </ul>
        </nav>
    </aside>

    <main class="main-content">
        <header class="header">
            <h1>Pacientes</h1>
            <a href="<%= request.getContextPath() %>/application/profile.html" title="Ir al perfil" class="a-profile">
                <p>FAVIO</p>
                <i class="fa-regular fa-circle-user"></i>
            </a>
        </header>
        <section class="section-list-patients">
            <div>
                <button id="newPatient"><i class="fa-solid fa-plus"></i>Nuevo paciente</button>
                <search class="search">
                    <form action="<%= request.getContextPath() %>/application/patients/search-patients" method="GET">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <input type="search" name="q" placeholder="Buscar paciente">
                    </form>
                </search>
            </div>
            <%
                List<Patient> patients = (List<Patient>) request.getAttribute("patients");
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th class="text-left">Paciente</th>
                        <th>Fecha de nacimiento</th>
                        <th>Altura (cm)</th>
                        <th>Peso (kg)</th>
                        <th>Organización</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (patients != null) {
                            for (Patient p : patients) {
                    %>
                                <tr data-id="<%= p.getId() %>">
                                    <td class="text-left">
                                        <%= 
                                            (p.getName() != null ? p.getName() : "") + " " +
                                            (p.getPatLastname() != null ? p.getPatLastname() : "") + " " + 
                                            (p.getMatLastname() != null ? p.getMatLastname() : "")
                                        %>
                                    </td>
                                    <td class="text-center"><%= p.getBirth() != null ? p.getBirth() : "--" %></td>
                                    <td class="text-center"><%= (p.getHeight() != null && p.getHeight() != 0) ? p.getHeight() : "--" %></td>
                                    <td class="text-center"><%= (p.getWeight() != null && p.getWeight() != 0.0) ? p.getWeight() : "--" %></td>                                    <td class="text-center"><%= p.getOrganization() != null ? p.getOrganization() : "--" %></td>
                                </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
    </main>

    <!-- Modal: patient form -->
     <div class="modal-new-patient">
        <div class="modal-content">
            <div>
                <h2>Nuevo paciente</h2>
                <span class="close-modal">&times;</span>
            </div>

            <h3>Datos principales</h3>
            <small>Más adelante podrá agregar más datos y detalles del paciente (dirección, teléfono, etc).</small>

            <form id="newPatientForm" action="<%= request.getContextPath() %>/application/patients/save" method="POST">
                
                <div class="container-input" class="container-input">
                    <label for="name">Nombre<span class="red">*</span>:</label>
                    <input type="text" name="name" placeholder="Nombre" required>
                </div>
                <div class="container-input" class="container-input">
                    <label for="pat-lastname">Apellido paterno<span class="red">*</span>:</label>
                    <input type="text" name="pat-lastname" placeholder="Apellido paterno" required>
                </div>
                <div class="container-input">
                    <label for="mat-lastname">Apellido materno:</label>
                    <input type="text" name="mat-lastname" placeholder="Apellido materno">
                </div>
                <div class="container-input">
                    <label for="gender">Género:<span class="red">*</span></label>
                    <select name="gender">
                        <option value="">--Seleccione una opción--</option>
                        <option value="Hombre">Hombre</option>
                        <option value="Mujer">Mujer</option>
                    </select>
                </div>
                <div class="container-input">
                    <label for="birth">Fecha de nacimiento:</label>
                    <input type="date" name="birth">
                </div>
                <div class="container-input">
                    <label for="height">Altura (cm)</label>
                    <input type="number" name="height" step="1" placeholder="Altura">
                </div>
                <div class="container-input">
                    <label for="weight">Peso (kg):</label>
                    <input type="number" name="weight" placeholder="Peso">
                </div>
                <div class="container-input">
                    <label for="organization">Organización o grupo de evaluación (opcional)</label>
                    <input type="text" name="organization" placeholder="Nombre de organización o grupo">
                </div>

                <input type="submit" class="btn-save" value="Guardar paciente">

            </form>
        </div>
     </div>
    <!-- End modal: patients form -->


    <!-- JS -->

    <script>

        document.addEventListener('DOMContentLoaded', () => {

            // Avoid assigning event for each <tr> with event delegation 
            const tbody = document.querySelector('.table tbody');

            tbody.addEventListener('click', (event) => {
                const row = event.target.closest('tr');
                if (row) {
                    const id = row.dataset.id;
                    window.location.href = '<%= request.getContextPath() %>/application/patient-details.html?id=' + id;
                }
            });

            // Show modal
            const modalNewPatient = document.querySelector('.modal-new-patient');

            document.querySelector('#newPatient').addEventListener('click', () => {
                modalNewPatient.style.display = 'block';
            });

            // Close modal (clicking outside modal)
            window.addEventListener('click', (event) => {
                if (event.target == modalNewPatient) {
                    modalNewPatient.style.display = 'none';
                }
            });

            document.querySelector('.modal-content form').addEventListener('submit', ()=> {
                console.log('submitted');
            });
            
            // Close modal (clicking on close button)
            document.querySelector('.close-modal').addEventListener('click', () => {
                modalNewPatient.style.display = 'none';
            });


            // Validate data form
            const validation = new JustValidate('#newPatientForm');

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
                .onSuccess((event) => {
                    const btnSave = document.querySelector('.btn-save');
                    btnSave.disabled = true;
                    btnSave.value = 'Guardando...';

                    event.target.submit();
                })

        })

    </script>

</body>
</html>