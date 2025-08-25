package org.faviel.nutri.daos;

import org.faviel.nutri.models.Patient;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {

    List<T> getAll(Connection conn) throws SQLException;

    T getById(Connection conn, Integer id) throws SQLException;

    void save(Connection conn, T o) throws SQLException;

    void update(Connection conn, T o) throws SQLException;

    void delete(Connection conn, Integer id) throws SQLException;

    List<T> find(Connection conn, String fieldName, Object value) throws SQLException;

    T findFirst(Connection conn, String fieldName, Object value) throws SQLException;
}
