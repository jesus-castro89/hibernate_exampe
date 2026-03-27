package org.app;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.app.entities.Person;
import org.app.logic.PersonDAO;
import org.app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;

public class App {

    public static void main(String[] args) {

        String dbName = "hibernate_db";
        createDatabaseIfNotExists(dbName);
        //addAutoIncrements();
        //insertData();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try(Statement stmt = session.doReturningWork(Connection::createStatement)) {
            String sql = "SELECT * FROM person";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Person ID: " + rs.getLong("person_id") +
                        ", Name: " + rs.getString("first_name") +
                        " " + rs.getString("last_name") +
                        ", Email: " + rs.getString("email") +
                        ", Age: " + rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al consultar la tabla person: " + e.getMessage());
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }


        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try(Statement stmt = session.doReturningWork(Connection::createStatement)) {
            String sql = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getLong("student_id") +
                        ", Person ID: " + rs.getLong("person_id") +
                        ", Enrollment Date: " + rs.getDate("enrollment_date"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al consultar la tabla student: " + e.getMessage());
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        initializeHibernateAndRun();
    }

    /**
     * Función que agregar los elementos AUTO_INCREMENT a
     * las tablas necesarias.
     */
    private static void addAutoIncrements() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try(Statement stmt = session.doReturningWork(Connection::createStatement)) {
            // Agregar AUTO_INCREMENT a person_id en person
            String sql1 = "ALTER TABLE IF EXISTS person " +
                    "MODIFY COLUMN person_id BIGINT AUTO_INCREMENT UNIQUE";
            stmt.execute(sql1);
            System.out.println("✅ AUTO_INCREMENT agregado a person.person_id");

            // Agregar AUTO_INCREMENT a student_id en student
            String sql2 = "ALTER TABLE IF EXISTS student " +
                    "MODIFY COLUMN student_id BIGINT AUTO_INCREMENT UNIQUE";
            stmt.execute(sql2);
            System.out.println("✅ AUTO_INCREMENT agregado a student.student_id");

            // Agregar AUTO_INCREMENT a professor_id en professor
            String sql3 = "ALTER TABLE IF EXISTS professor " +
                    "MODIFY COLUMN professor_id BIGINT AUTO_INCREMENT UNIQUE";
            stmt.execute(sql3);
            System.out.println("✅ AUTO_INCREMENT agregado a professor.professor_id");

        } catch (SQLException e) {
            System.err.println("❌ Error al agregar AUTO_INCREMENT: " + e.getMessage());
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    public static void insertData() {
        PersonDAO personDAO = new PersonDAO();
        Person person = new Person();
        person.setFirstName("FirstName");
        person.setLastName("LastName");
        person.setEmail("correo@dominio.com");
        person.setAge(20);
        personDAO.create(person);
    }

    /**
     * Estrategia de 2 pasos para Connector/J 3.x:
     * 1. Conectar sin esquema (URL sin base de datos)
     * 2. Ejecutar CREATE DATABASE IF NOT EXISTS
     * 3. Reconectar con el esquema ya creado [citation:8]
     */
    private static void createDatabaseIfNotExists(String dbName) {
        String url = "jdbc:mariadb://localhost:3306/";  // Sin base de datos
        String user = "root";
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
