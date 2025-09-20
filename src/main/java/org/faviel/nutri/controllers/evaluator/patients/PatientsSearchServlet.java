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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/mode-evaluator/patients/search")
public class PatientsSearchServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PatientsSearchServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchValue = RequestParam.getString(req, "q", "");

        PatientDAOImpl patientDAO = new PatientDAOImpl();

        if (!searchValue.isEmpty()) {
            try {
                // Patients filtered
                List<Patient> patients = patientDAO.search(MSSQLConnection.getConnection(), searchValue);
                req.setAttribute("patients", patients);
                req.setAttribute("searchValue", searchValue);

                req.getServletContext().getRequestDispatcher("/mode-evaluator/patients.jsp").forward(req, resp);

            } catch (SQLException e) {
                logger.log(Level.WARNING, "Error al obtener los registros", e);
                req.getSession().setAttribute("errorMessage", "Error al obtener los registros");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/mode-evaluator/patients");
        }
    }
}
