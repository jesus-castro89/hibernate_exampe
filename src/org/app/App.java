package org.app;

import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.*;

public class App {

    public static void main(String[] args) {

        String dbName = "hibernate_db";
        createDatabaseIfNotExists(dbName);
        initializeHibernateAndRun();
    }

    /**
     * Estrategia de 2 pasos para Connector/J 3.x:
     * 1. Conectar sin esquema (URL sin base de datos)
     * 2. Ejecutar CREATE DATABASE IF NOT EXISTS
     * 3. Reconectar con el esquema ya creado [citation:8]
     */
    private static void createDatabaseIfNotExists(String dbName) {
        String url = "jdbc:mariadb://localhost:3306/";  // Sin base de datos
        String user = "tu_usuario";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE DATABASE IF NOT EXISTS " + dbName +
                        " CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci";
                stmt.execute(sql);
                System.out.println("✅ Base de datos '" + dbName + "' verificada/creada exitosamente");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al crear/verificar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Inicializa Hibernate y ejecuta operaciones
     * Ahora la URL en hibernate.cfg.xml debe incluir el nombre de la base de datos
     * NOTA: Para que esto funcione, debes actualizar la URL en hibernate.cfg.xml
     * a: jdbc:mariadb://localhost:3306/mi_base_datos
     */
    private static void initializeHibernateAndRun() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
    }
}
