package org.faviel.nutri.controllers.evaluator.patients;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.faviel.nutri.connections.MSSQLConnection;
import org.faviel.nutri.daos.PatientDAOImpl;
import org.faviel.nutri.helpers.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/mode-evaluator/patients/delete")
public class PatientsDeleteServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(PatientsDeleteServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = RequestParam.getInt(req, "id");

        PatientDAOImpl patientDAO = new PatientDAOImpl();

        try {
            patientDAO.delete(MSSQLConnection.getConnection(), id);
            req.getSession().setAttribute("successMessage", "Se ha eliminado correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar el registro" ,e);
            req.getSession().setAttribute("errorMessage", "Error al eliminar el registro");
        }

        resp.sendRedirect(req.getContextPath() + "/mode-evaluator/patients");
    }
}
