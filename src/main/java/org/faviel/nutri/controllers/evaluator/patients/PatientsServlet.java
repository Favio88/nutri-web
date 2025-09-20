package org.faviel.nutri.controllers.evaluator.patients;

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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/mode-evaluator/patients")
public class PatientsServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PatientsServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNumber = RequestParam.getInt(req, "pageNumber", 1);
        int pageSize = 10;

        PatientDAOImpl patientDAO = new PatientDAOImpl();

        try (Connection conn = MSSQLConnection.getConnection()) {
            List<Patient> patients = patientDAO.getPage(conn, pageNumber, pageSize);
            int totalPatients = patientDAO.countPatients(conn);
            int totalPages = (int) Math.ceil((double) totalPatients / pageSize);

            req.setAttribute("patients", patients);
            req.setAttribute("totalPatients", totalPatients);
            req.setAttribute("currentPage", pageNumber);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("pageSize", pageSize);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener los registros", e);
            req.getSession().setAttribute("errorMessage", "Error al obtener los registros");
        }

        req.getServletContext().getRequestDispatcher("/mode-evaluator/patients.jsp").forward(req, resp);
    }
}