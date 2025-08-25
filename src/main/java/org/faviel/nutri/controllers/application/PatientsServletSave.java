package org.faviel.nutri.controllers.application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.faviel.nutri.connections.MSSQLConnection;
import org.faviel.nutri.daos.PatientDAOImpl;
import org.faviel.nutri.helpers.RequestParam;
import org.faviel.nutri.models.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/application/patients/save")
public class PatientsServletSave extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PatientsServletSave.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = RequestParam.getString(req, "name", "");
        String patLastname = RequestParam.getString(req, "pat-lastname", "");
        String matLastname = RequestParam.getString(req, "mat-lastname", "");
        String gender = RequestParam.getString(req, "gender");
        LocalDate birth = RequestParam.getDate(req, "birth");
        Integer height = RequestParam.getInt(req, "height");
        Double weight = RequestParam.getDouble(req, "weight");
        String organization = RequestParam.getString(req, "organization");


        Patient patient = new Patient();
        patient.setName(name);
        patient.setPatLastname(patLastname);
        patient.setMatLastname(matLastname);
        patient.setGender(gender);
        patient.setBirth(birth);
        patient.setHeight(height);
        patient.setWeight(weight);
        patient.setOrganization(organization);


        PatientDAOImpl patientDAO = new PatientDAOImpl();

        try (Connection conn = MSSQLConnection.getConnection()) {
            patientDAO.save(conn, patient);
            req.getSession().setAttribute("success-message","Se ha guardado correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar el registro del paciente", e);
            req.getSession().setAttribute("error-message", "Error al guardar el registro");
        }

        resp.sendRedirect(req.getContextPath() + "/application/patients");
    }
}