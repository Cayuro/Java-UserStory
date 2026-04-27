package com.riwi.talent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String URL = System.getenv().getOrDefault(
            "DB_URL",
            "jdbc:postgresql://localhost:5432/talenthub"
    );
    private static final String USER = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "postgres");

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        /*
         * En Java 8 o anterior era comun abrir recursos con try-catch-finally manual:
         * Connection c = null; PreparedStatement ps = null; ResultSet rs = null;
         * try { ... } finally { if (rs != null) rs.close(); if (ps != null) ps.close(); if (c != null) c.close(); }
         * Si algun close() se omitia o fallaba silenciosamente, quedaban recursos abiertos
         * y podian aparecer memory leaks o agotamiento de conexiones.
         */
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
