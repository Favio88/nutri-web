<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="org.faviel.nutri.models.Patient" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nutri | Detalles del paciente</title>
    
    <!-- Fontawesome icons -->
    <script src="https://kit.fontawesome.com/c09ae347fc.js" crossorigin="anonymous"></script></head>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200..800&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>
    
    <%
        String successMessage = (String) session.getAttribute("successMessage");
        String errorMessage = (String) session.getAttribute("errorMessage");

        if (successMessage != null || errorMessage != null) {
    %>
            <div class='<%= successMessage != null ? "alert alert-success" : "alert alert-danger" %>'>
                <%= successMessage != null ? successMessage : errorMessage %>
            </div>
    <%
            session.removeAttribute("successMessage");
            session.removeAttribute("errorMessage");
        }
    %>

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
                <span>Detalles del paciente</span>
            </h1>
            <a href="<%= request.getContextPath() %>/mode-evaluator/profile" title="Ir al perfil" class="a-profile">
                <p>FAVIO</p>
                <i class="fa-regular fa-circle-user"></i>
                <p class="mode">EVALUADOR</p>
            </a>
        </header>
        
        <section class="section-patient-details">
            <div class="patient">
                <h2>
                    <%= 
                        (patient != null && patient.getName() != null ? patient.getName() : "") + " " + 
                        (patient != null && patient.getPatLastname() != null ? patient.getPatLastname() : "") + " " +
                        (patient != null && patient.getMatLastname() != null ? patient.getMatLastname() : "")
                    %>
                </h2>
                <div class="buttons">
                    <button class="btn-view">Ver información completa</button>
                    <button class="btn-edit" data-id='<%= request.getParameter("id") %>'>Editar información</button>
                    <button class="btn-delete">Eliminar paciente</button>
                </div>
            </div>
 
         <div class="separator-line"></div>

         <div class="info">
                <div class="age">
                    <i class="fa-solid fa-cake-candles"></i>
                    <p><%= patient != null && patient.getAge() != null ? patient.getAge() + " años" : "Edad --" %></p>
                </div>
                <div class="gender">
                    <%
                        if (patient != null && patient.getGender().equals("Hombre")) {                            
                    %>
                            <i class="fa-solid fa-person"></i>
                    <%        
                        } else {
                    %>
                            <i class="fa-solid fa-person-dress"></i>
                    <%
                        }
                    %>
                    <p><%= patient != null && patient.getGender() != null ? patient.getGender() : "--" %></p>
                </div>
                <div class="height">
                    <i class="fa-solid fa-ruler-vertical"></i>
                    <p><%= patient != null && patient.getHeight() != null ? patient.getHeight() : "--" %> cm</p>
                </div>
                <div class="weight">
                    <i class="fa-solid fa-weight-scale"></i>
                    <p><%= patient != null && patient.getWeight() != null ? patient.getWeight() : "--" %> kg</p>
                </div>
                <button class="btn-view">
                    <i class="fa-solid fa-clock-rotate-left"></i>Ver historial mediciones
                </button>
                <p>Organización: <%= patient != null && patient.getOrganization() != null ? patient.getOrganization() : "--" %></p>
            </div>
        </section>
        
        <div class="separator-line"></div>

        <section class="section-patient-intakes">
            <h3>Registro de ingestas</h3>
            <button class="btn-new"><i class="fa-solid fa-plus"></i>Nueva ingesta</button>
            <table class="table">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>No. días ?</th>
                        <th>Gasto calórico</th>
                        <th>Actividad física</th>
                        <th>Estado fisiológico</th>
                        <th>Edad</th>
                        <th>Altura</th>
                        <th>Peso</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </section>
    </main>

    <!-- Modal: intake form -->
    <div id="newModalIntake" class="modal" style="display: none;">
        <div class="modal-content">
            <h2>Nueva ingesta</h2>
            <span class="close-modal">&times;</span>
        </div>
        <form id="newIntake" action="" method="POST">
            <div>
                <label for="">No. días</label>
                <input type="number" name="days" placeholder="">
            </div>
            <div>
                <label for=""></label>
            </div>
        </form>
    </div>
    <!-- End modal: intake form -->


    <!-- Modal: info patient -->
    <div id="modalInfoPatient" style="display: none">
        <div class="container-info-patient">
            <div class="heading">
                <h2>Información del paciente</h2>
                <span class="close-modal">&times;</span>
            </div>
            <div class="separator-line"></div>
            <div class="info-principal">
                <p><strong>Nombre(s)</strong><%= patient != null && patient.getName() != null ? patient.getName() : "--" %></p>
                <p><strong>Apellido paterno</strong><%= patient != null && patient.getPatLastname() != null ? patient.getPatLastname() : "--" %></p>
                <p><strong>Apellido materno</strong><%= patient != null && patient.getMatLastname() != null ? patient.getMatLastname() : "--" %></p>
                <p><strong>Género</strong><%= patient != null && patient.getGender() != null ? patient.getGender() : "--" %></p>
                <p><strong>Edad</strong><%= patient != null && patient.getAge() != null ? patient.getAge() + " años" : "--" %></p>
                <p><strong>Fecha de nacimiento</strong><%= patient != null && patient.getBirth() != null ? patient.getBirth() : "--" %></p>
                <p><strong>Altura</strong><%= patient != null && patient.getHeight() != null ? patient.getHeight() + " cm" : "--" %></p>
                <p><strong>Peso</strong><%= patient != null && patient.getWeight() != null ? patient.getWeight() + " kg" : "--" %></p>
                <p><strong>Organización</strong><%= patient != null && patient.getOrganization() != null ? patient.getOrganization() : "--" %></p>
            </div>
            <div class="separator-line"></div>
            <div class="info-extra">
                <p>
                    <strong>Teléfono</strong>
                    <%= patient != null && patient.getTelCountryCode() != null ? patient.getTelCountryCode() + " " : "" %>
                    <%= patient != null && patient.getTel() != null ? patient.getTel() : "--" %>
                </p>
                <p><strong>Email</strong><%= patient != null && patient.getEmail() != null ? patient.getEmail() : "--" %></p>
                <p><strong>Dirección</strong><%= patient != null && patient.getAddress() != null ? patient.getAddress() : "--" %></p>
                <p><strong>Ciudad</strong><%= patient != null && patient.getCity() != null ? patient.getCity() : "--" %></p>
                <p><strong>Estado/Región</strong><%= patient != null && patient.getRegion() != null ? patient.getRegion() : "--" %></p>
                <p><strong>País</strong><%= patient != null && patient.getCountry() != null ? patient.getCountry() : "--" %></p>
            </div>
        </div>
    </div>
    <!-- End modal: info patient -->

    <!-- Modal: confirm delete -->
    <div class="modal-confirm-delete" style="display: none;">
        <div class="container-content">
            <p><strong>¿Desea eliminar permanentemente el paciente?</strong></p>
            
            <form action="<%= request.getContextPath() %>/mode-evaluator/patient-details/delete" method="POST">
                <input type="hidden" name="id" value='<%= request.getParameter("id") %>'>
                <div class="buttons">
                    <button type="submit" class="btn-confirm-delete">Eliminar</button>
                    <button type="button" class="btn-cancel">Cancelar</button>
                </div>
            </form>

        </div>
    </div>
    <!-- End modal: confirm delete -->

    <!-- JS -->

    <script>
        
        document.addEventListener('DOMContentLoaded', () => {

            const modalInfoPatient = document.querySelector('#modalInfoPatient');
            const modalConfirmDelete = document.querySelector('.modal-confirm-delete');

            // Show new patient modal
            document.querySelector('.btn-view').addEventListener('click', () => {
                modalInfoPatient.style.display = 'block';
            });
            
            // Close new patient modal            
            document.querySelector('#modalInfoPatient .close-modal').addEventListener('click', () => {
                modalInfoPatient.style.display = 'none';
            });

            // Close modal new patient (clicking outside modal)
            window.addEventListener('click', (e) => {
                if (e.target === modalInfoPatient) {
                    modalInfoPatient.style.display = 'none';
                }

                if (e.target === modalConfirmDelete) {
                    modalConfirmDelete.style.display = 'none';
                }
            });

            // Edit patient
            document.querySelector('.btn-edit').addEventListener('click', (e) => {
                const id = e.target.dataset.id;
                window.location.href = '<%= request.getContextPath() %>/mode-evaluator/patient-details/edit?id=' + id;
            });

            // Show delete patient modal
            document.querySelector('.btn-delete').addEventListener('click', (e) => {
                const id = e.target.dataset.id;
                modalConfirmDelete.style.display = 'block';
            });

            // Cancel delete patient
            document.querySelector('.btn-cancel').addEventListener('click', () => {
                modalConfirmDelete.style.display = 'none';
            });

        });

    </script>

</body>
</html>