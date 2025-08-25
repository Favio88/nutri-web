package org.faviel.nutri.helpers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PreparedStmtParam {

    public static void setString(PreparedStatement stmt, int index, String value) throws SQLException {
        if (value != null && !value.isEmpty()) {
            stmt.setString(index, value);
        } else {
            stmt.setNull(index, Types.VARCHAR);
        }
    }

    public static void setInt(PreparedStatement stmt, int index, Integer value) throws SQLException {
        if (value != null) {
            stmt.setInt(index, value);
        } else {
            stmt.setNull(index, Types.INTEGER);
        }
    }

    public static void setDouble(PreparedStatement stmt, int index, Double value) throws SQLException {
        if (value != null) {
            stmt.setDouble(index, value);
        } else {
            stmt.setNull(index, Types.DOUBLE);
        }
    }

    public static void setBoolean(PreparedStatement stmt, int index, Boolean value) throws SQLException {
        if (value != null) {
            stmt.setBoolean(index, value);
        } else {
            stmt.setNull(index, Types.BOOLEAN);
        }
    }

    public static void setDate(PreparedStatement stmt, int index, LocalDate value) throws SQLException {
        if (value != null) {
            stmt.setDate(index, java.sql.Date.valueOf(value));
        } else {
            stmt.setNull(index, Types.DATE);
        }
    }

    public static void setTimestamp(PreparedStatement stmt, int index, LocalDateTime value) throws SQLException {
        if (value != null) {
            stmt.setTimestamp(index, Timestamp.valueOf(value));
        } else {
            stmt.setNull(index, Types.TIMESTAMP);
        }
    }
}
