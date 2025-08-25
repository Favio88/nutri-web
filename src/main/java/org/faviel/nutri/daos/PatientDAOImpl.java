package org.faviel.nutri.daos;

import org.faviel.nutri.helpers.PreparedStmtParam;
import org.faviel.nutri.models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements IDAO<Patient> {

    @Override
    public List<Patient> getAll(Connection conn) throws SQLException {
        List<Patient> listPatients = new ArrayList<>();
        String sql = "SELECT * FROM Patients";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("PAT_Id"));
                patient.setName(rs.getString("PAT_Name"));
                patient.setPatLastname(rs.getString("PAT_Pat_Lastname"));
                patient.setMatLastname(rs.getString("PAT_Mat_Lastname"));
                patient.setGender(rs.getString("PAT_Gender"));
                patient.setBirth(rs.getDate("PAT_Birth") != null
                        ? rs.getDate("PAT_Birth").toLocalDate()
                        : null);
                patient.setHeight(rs.getInt("PAT_Height"));
                patient.setWeight(rs.getDouble("PAT_Weight"));
                patient.setOrganization(rs.getString("PAT_Organization"));
                patient.setTelCountryCode(rs.getString("PAT_Tel_Country_Code"));
                patient.setTel(rs.getString("PAT_Tel"));
                patient.setEmail(rs.getString("PAT_Email"));
                patient.setAddress(rs.getString("PAT_Address"));
                patient.setCity(rs.getString("PAT_City"));
                patient.setRegion(rs.getString("PAT_Region"));
                patient.setCountry(rs.getString("PAT_Country"));

                listPatients.add(patient);
            }
        }
        return listPatients;
    }

    @Override
    public Patient getById(Connection conn, Integer id) throws SQLException {
        Patient patient = null;
        String sql = "SELECT * FROM Patients " +
                "WHERE PAT_Id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setInt(stmt, 1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("PAT_Id"));
                patient.setName(rs.getString("PAT_Name"));
                patient.setPatLastname(rs.getString("PAT_Pat_Lastname"));
                patient.setMatLastname(rs.getString("PAT_Mat_Lastname"));
                patient.setGender(rs.getString("PAT_Gender"));
                patient.setBirth(rs.getDate("PAT_Birth") != null
                        ? rs.getDate("PAT_Birth").toLocalDate()
                        : null);
                patient.setHeight(rs.getInt("PAT_Height"));
                patient.setWeight(rs.getDouble("PAT_Weight"));
                patient.setOrganization(rs.getString("PAT_Organization"));
                patient.setTelCountryCode(rs.getString("PAT_Tel_Country_Code"));
                patient.setTel(rs.getString("PAT_Tel"));
                patient.setEmail(rs.getString("PAT_Email"));
                patient.setAddress(rs.getString("PAT_Address"));
                patient.setCity(rs.getString("PAT_City"));
                patient.setRegion(rs.getString("PAT_Region"));
                patient.setCountry(rs.getString("PAT_Country"));
            }
            rs.close();
        }
        return patient;
    }

    @Override
    public void save(Connection conn, Patient patient) throws SQLException {
        String sql = "INSERT INTO Patients(" +
                "PAT_Name, PAT_Pat_Lastname, PAT_Mat_Lastname, PAT_Gender, " +
                "PAT_Birth, PAT_Height, PAT_Weight, PAT_Organization, " +
                "PAT_Tel_Country_Code, PAT_Tel, PAT_Email, PAT_Address, PAT_City, " +
                "PAT_Region, PAT_Country) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setString(stmt,1, patient.getName());
            PreparedStmtParam.setString(stmt,2, patient.getPatLastname());
            PreparedStmtParam.setString(stmt,3, patient.getMatLastname());
            PreparedStmtParam.setString(stmt,4, patient.getGender());
            PreparedStmtParam.setDate(stmt,5, patient.getBirth());
            PreparedStmtParam.setInt(stmt,6, patient.getHeight());
            PreparedStmtParam.setDouble(stmt,7, patient.getWeight());
            PreparedStmtParam.setString(stmt,8, patient.getOrganization());
            PreparedStmtParam.setString(stmt,9, patient.getTelCountryCode());
            PreparedStmtParam.setString(stmt,10, patient.getTel());
            PreparedStmtParam.setString(stmt,11, patient.getEmail());
            PreparedStmtParam.setString(stmt,12, patient.getAddress());
            PreparedStmtParam.setString(stmt,13, patient.getCity());
            PreparedStmtParam.setString(stmt,14, patient.getRegion());
            PreparedStmtParam.setString(stmt,15, patient.getCountry());

            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Connection conn, Patient patient) throws SQLException {
        String sql = "UPDATE Patients SET " +
                "PAT_Name=?, PAT_Pat_Lastname=?, PAT_Mat_Lastname=?, PAT_Gender=?, " +
                "PAT_Birth=?, PAT_Height=?, PAT_Weight=?, PAT_Organization=?, " +
                "PAT_Tel_Country_Code=?, PAT_Tel=?, PAT_Email=?, PAT_Address=?, " +
                "PAT_City=?, PAT_Region=?, PAT_Country=? " +
                "WHERE PAT_Id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setString(stmt,1, patient.getName());
            PreparedStmtParam.setString(stmt,2, patient.getPatLastname());
            PreparedStmtParam.setString(stmt,3, patient.getMatLastname());
            PreparedStmtParam.setString(stmt,4, patient.getGender());
            PreparedStmtParam.setDate(stmt,5, patient.getBirth());
            PreparedStmtParam.setInt(stmt,6, patient.getHeight());
            PreparedStmtParam.setDouble(stmt,7, patient.getWeight());
            PreparedStmtParam.setString(stmt,8, patient.getOrganization());
            PreparedStmtParam.setString(stmt,9, patient.getTelCountryCode());
            PreparedStmtParam.setString(stmt,10, patient.getTel());
            PreparedStmtParam.setString(stmt,11, patient.getEmail());
            PreparedStmtParam.setString(stmt,12, patient.getAddress());
            PreparedStmtParam.setString(stmt,13, patient.getCity());
            PreparedStmtParam.setString(stmt,14, patient.getRegion());
            PreparedStmtParam.setString(stmt,15, patient.getCountry());
            PreparedStmtParam.setInt(stmt,16, patient.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Patients " +
                "WHERE PAT_Id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setInt(stmt,1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Patient> find(Connection conn, String fieldName, Object value) throws SQLException {
        return List.of();
    }

    @Override
    public Patient findFirst(Connection conn, String fieldName, Object value) throws SQLException {
        return null;
    }
}