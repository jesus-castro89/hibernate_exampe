package org.app.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.sql.*;

public class DatabaseHelper {

    private static final String[] TABLES = {"person", "student", "professor"};
    private static final String[] COLUMNS = {"person_id", "student_id", "professor_id"};

    public static void createDatabaseIfNotExists(String dbName) {

        Configuration configuration = new Configuration().configure();
        String url = configuration.getProperty("hibernate.connection.url");
        String user = configuration.getProperty("hibernate.connection.username");
        String password = configuration.getProperty("hibernate.connection.password");
        // Extraer la URL base (eliminar el nombre de la base de datos)
        String baseUrl = extractBaseUrl(url, dbName);
        IO.println(baseUrl);

        try (Connection connection = DriverManager.getConnection(baseUrl, user, password)) {

            DatabaseMetaData metaData = connection.getMetaData();
            String dbProduct = metaData.getDatabaseProductName();

            if (dbProduct.contains("MySQL") || dbProduct.contains("MariaDB")) {
                createMySQLDatabaseIfNotExists(connection, dbName);
            } else if (dbProduct.contains("PostgreSQL")) {
                createPostgreSQLDatabaseIfNotExists(connection, dbName);
            } else {
                System.err.println("Motor de base de datos no soportado para creación automática.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al verificar el motor de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String extractBaseUrl(String fullUrl, String dbName) {

        // Ejemplo: jdbc:mariadb://localhost:3306/mi_db -> jdbc:mariadb://localhost:3306/
        if (fullUrl.endsWith("/" + dbName)) {
            return fullUrl.substring(0, fullUrl.length() - dbName.length());
        } else if (fullUrl.contains("?")) {
            // Si tiene parámetros, hay que quitarlos también
            int paramIndex = fullUrl.indexOf('?');
            String urlWithoutParams = fullUrl.substring(0, paramIndex);
            if (urlWithoutParams.endsWith("/" + dbName)) {
                return urlWithoutParams.substring(0, urlWithoutParams.length() - dbName.length());
            }
        }
        // Si no se puede extraer, asumimos que la URL ya es base (sin nombre de BD)
        return fullUrl;
    }

    private static void createMySQLDatabaseIfNotExists(Connection connection, String dbName) {

        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName +
                    " CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci";
            statement.execute(sql);
            System.out.println("✅ Base de datos '" + dbName + "' verificada/creada exitosamente");
        } catch (SQLException e) {
            System.err.println("❌ Error al crear la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createPostgreSQLDatabaseIfNotExists(Connection connection, String dbName) {

        try (Statement statement = connection.createStatement()) {
            // Verificar si la base de datos ya existe
            String checkSQL = "SELECT 1 FROM pg_database WHERE datname = '" + dbName + "'";
            ResultSet rs = statement.executeQuery(checkSQL);
            if (!rs.next()) {
                // Crear la base de datos si no existe
                String sql = "CREATE DATABASE " + dbName;
                statement.execute(sql);
                System.out.println("✅ Base de datos '" + dbName + "' verificada/creada exitosamente");
            } else {
                System.out.println("ℹ️ Base de datos '" + dbName + "' ya existe.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al crear la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void ensureAutoIncrementColumns() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Obtener la conexión subyacente
            Connection connection = session.doReturningWork(conn -> conn);
            DatabaseMetaData metaData = connection.getMetaData();
            String dbProduct = metaData.getDatabaseProductName();

            // Verificar y modificar según el motor
            if (dbProduct.contains("MySQL") || dbProduct.contains("MariaDB")) {
                ensureMySQLAutoIncrement(connection);
            } else if (dbProduct.contains("PostgreSQL")) {
                ensurePostgresSQLAutoIncrement(connection);
            } else {
                System.err.println("Motor de base de datos no soportado para AUTO_INCREMENT automático.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ensureMySQLAutoIncrement(Connection connection) {

        try (Statement stmt = connection.createStatement()) {
            for (int i = 0; i < TABLES.length; i++) {
                String table = TABLES[i];
                String column = COLUMNS[i];

                // Verificar si la columna ya tiene AUTO_INCREMENT
                String checkQuery = "SELECT EXTRA FROM INFORMATION_SCHEMA.COLUMNS " +
                        "WHERE TABLE_NAME = '" + table + "' AND COLUMN_NAME = '" + column + "'";
                ResultSet rs = stmt.executeQuery(checkQuery);
                boolean hasAutoIncrement = false;
                if (rs.next()) {
                    String extra = rs.getString("EXTRA");
                    if (extra != null && extra.contains("auto_increment")) {
                        hasAutoIncrement = true;
                    }
                }
                rs.close();

                if (!hasAutoIncrement) {
                    // Modificar la columna para agregar AUTO_INCREMENT
                    String alterSQL = "ALTER TABLE " + table + " MODIFY " + column + " BIGINT AUTO_INCREMENT";
                    stmt.execute(alterSQL);
                    System.out.println("✅ AUTO_INCREMENT agregado a " + table + "." + column);
                } else {
                    System.out.println("ℹ️ " + table + "." + column + " ya tiene AUTO_INCREMENT.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ensurePostgresSQLAutoIncrement(Connection connection) {

        try (Statement stmt = connection.createStatement()) {
            for (int i = 0; i < TABLES.length; i++) {
                String table = TABLES[i];
                String column = COLUMNS[i];
                String seqName = table + "_" + column + "_seq";

                // Verificar si la columna ya tiene valor por defecto de secuencia
                String checkQuery = "SELECT column_default FROM information_schema.columns " +
                        "WHERE table_name = '" + table + "' AND column_name = '" + column + "'";
                ResultSet rs = stmt.executeQuery(checkQuery);
                boolean hasDefault = false;
                if (rs.next()) {
                    String defaultValue = rs.getString("column_default");
                    if (defaultValue != null && defaultValue.contains("nextval")) {
                        hasDefault = true;
                    }
                }
                rs.close();

                if (!hasDefault) {
                    // Crear la secuencia si no existe
                    stmt.execute("CREATE SEQUENCE IF NOT EXISTS " + seqName);
                    // Establecer el valor por defecto de la columna a la secuencia
                    stmt.execute("ALTER TABLE " + table + " ALTER COLUMN " + column +
                            " SET DEFAULT nextval('" + seqName + "')");
                    // (Opcional) Sincronizar la secuencia con el máximo valor existente
                    stmt.execute("SELECT setval('" + seqName + "', COALESCE((SELECT MAX(" + column + ") FROM " + table + "), 0) + 1, false)");
                    System.out.println("✅ Secuencia y valor por defecto agregados a " + table + "." + column);
                } else {
                    System.out.println("ℹ️ " + table + "." + column + " ya tiene valor por defecto de secuencia.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
