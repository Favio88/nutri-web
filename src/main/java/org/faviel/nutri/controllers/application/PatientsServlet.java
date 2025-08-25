package org.faviel.nutri.controllers.application;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.faviel.nutri.connections.MSSQLConnection;
import org.faviel.nutri.daos.PatientDAOImpl;
import org.faviel.nutri.models.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/application/patients")
public class PatientsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PatientDAOImpl patientDAO = new PatientDAOImpl();

        try {
            List<Patient> patients = patientDAO.getAll(MSSQLConnection.getConnection());
            req.setAttribute("patients", patients);
        } catch (SQLException e) {
            req.getSession().setAttribute("error-message", "Error al obtener los registros");
        }

        getServletContext().getRequestDispatcher("/application/patients.jsp").forward(req, resp);
    }
}