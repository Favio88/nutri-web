package org.faviel.nutri.helpers;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class RequestParam {

    private static final LocalDate DEFAULT_DATE = LocalDate.of(1900, 1, 1);
    private static final LocalDateTime DEFAULT_DATETIME = LocalDateTime.of(1900, 1, 1, 0, 0);

    public static String getString(HttpServletRequest req, String param) {
        return getString(req, param, null);
    }

    public static String getString(HttpServletRequest req, String param, String defaultValue) {
        String valueStr = req.getParameter(param);
        if (valueStr != null && !valueStr.trim().isEmpty()) {
            return valueStr.trim();
        }
        return defaultValue;
    }

    public static Integer getInt(HttpServletRequest req, String param) {
        return getInt(req, param, null);
    }

    public static Integer getInt(HttpServletRequest req, String param, Integer defaultValue) {
        String valueStr = req.getParameter(param);
        if (valueStr != null && !valueStr.trim().isEmpty()) {
            try {
                return Integer.parseInt(valueStr.trim());
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido para '" + param + "' : " + valueStr);
            }
        }
        return defaultValue;
    }

    public static Double getDouble(HttpServletRequest req, String param) {
        return getDouble(req, param, null);
    }

    public static Double getDouble(HttpServletRequest req, String param, Double defaultValue) {
        String valueStr = req.getParameter(param);
        if (valueStr != null && !valueStr.trim().isEmpty()) {
            try {
                return Double.parseDouble(valueStr.trim());
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido para '" + param + "' : " + valueStr);
            }
        }
        return defaultValue;
    }

    public static Boolean getBoolean(HttpServletRequest req, String param) {
        return getBoolean(req, param, null);
    }

    public static Boolean getBoolean(HttpServletRequest req, String param, Boolean defaultValue) {
        String valueStr = req.getParameter(param);
        if (valueStr != null && !valueStr.trim().isEmpty()) {
            return Boolean.parseBoolean(valueStr.trim());
        }
        return defaultValue;
    }

    public static LocalDate getDate(HttpServletRequest req, String param) {
        return getDate(req, param, false);
    }

    public static LocalDate getDate(HttpServletRequest req, String param, boolean useDefaultDate) {
        String valueStr = req.getParameter(param);
        if (valueStr != null && !valueStr.trim().isEmpty()) {
            try {
                return LocalDate.parse(valueStr.trim());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido para '" + param + "' : " + valueStr);
            }
        }
        return useDefaultDate ? DEFAULT_DATE : null;
    }

    public static LocalDateTime getDateTime(HttpServletRequest req, String param) {
        return getDateTime(req, param, false);
    }

    public static LocalDateTime getDateTime(HttpServletRequest req, String param, boolean useDefaultDateTime) {
        String valueStr = req.getParameter(param);
        if (valueStr != null && !valueStr.trim().isEmpty()) {
            try {
                return LocalDateTime.parse(valueStr.trim());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido para '" + param + "' : " + valueStr);
            }
        }
        return useDefaultDateTime ? DEFAULT_DATETIME : null;
    }
}
