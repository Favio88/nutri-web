package org.faviel.nutri.controllers.evaluator.patientdetails;

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

@WebServlet("/mode-evaluator/patient-details/update")
public class PatientDetailsUpdateServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PatientDetailsUpdateServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = RequestParam.getInt(req, "id");
        String name = RequestParam.getString(req, "name");
        String patLastname = RequestParam.getString(req, "pat-lastname");
        String matLastname = RequestParam.getString(req, "mat-lastname");
        String gender = RequestParam.getString(req, "gender");
        LocalDate birth = RequestParam.getDate(req, "birth");
        Integer height = RequestParam.getInt(req, "height");
        Double weight = RequestParam.getDouble(req, "weight");
        String organization = RequestParam.getString(req, "organization");
        String telCountryCode = RequestParam.getString(req, "tel-country-code");
        String tel = RequestParam.getString(req, "tel");
        String email = RequestParam.getString(req, "email");
        String address = RequestParam.getString(req, "address");
        String city = RequestParam.getString(req, "city");
        String region = RequestParam.getString(req, "region");
        String country = RequestParam.getString(req, "country");


        Patient patient = new Patient();
        patient.setId(id);
        patient.setName(name);
        patient.setPatLastname(patLastname);
        patient.setMatLastname(matLastname);
        patient.setGender(gender);
        patient.setBirth(birth);
        patient.setHeight(height);
        patient.setWeight(weight);
        patient.setOrganization(organization);
        patient.setTelCountryCode(telCountryCode);
        patient.setTel(tel);
        patient.setEmail(email);
        patient.setAddress(address);
        patient.setCity(city);
        patient.setRegion(region);
        patient.setCountry(country);


        PatientDAOImpl patientDAO = new PatientDAOImpl();
        try (Connection conn = MSSQLConnection.getConnection()) {
            patientDAO.update(conn, patient);
            req.getSession().setAttribute("successMessage", "Se ha actualizado correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar el registro", e);
            req.getSession().setAttribute("errorMessage", "Error al actualizar el registro");
        }

        resp.sendRedirect(req.getContextPath() + "/mode-evaluator/patient-details?id=" + id);
    }
}
