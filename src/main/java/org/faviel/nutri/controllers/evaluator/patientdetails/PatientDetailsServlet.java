package org.faviel.nutri.controllers.evaluator.patientdetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.faviel.nutri.connections.MSSQLConnection;
import org.faviel.nutri.controllers.evaluator.patients.PatientsSaveServlet;
import org.faviel.nutri.daos.PatientDAOImpl;
import org.faviel.nutri.helpers.RequestParam;
import org.faviel.nutri.models.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/mode-evaluator/patient-details")
public class PatientDetailsServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PatientDetailsServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = RequestParam.getInt(req, "id");

        PatientDAOImpl patientDAO = new PatientDAOImpl();
        try {
            Patient patient = patientDAO.getById(MSSQLConnection.getConnection(), id);
            req.setAttribute("patient", patient);

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener los datos", e);
            req.getSession().setAttribute("errorMessage", "Error al obtener los datos");
        }

        getServletContext().getRequestDispatcher("/mode-evaluator/patient-details.jsp").forward(req, resp);
    }
}
