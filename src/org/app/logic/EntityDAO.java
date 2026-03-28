package org.app.logic;

import java.util.List;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public interface EntityDAO<T> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> findAll();

    /**
     * Función de búsqueda de un contenido especifíco para un campo
     * de la tabla, por ejemplo: findBy("email", "juan.perez@correo.empresa")
     * o findBy("courseName", "Matemáticas Avanzadas")
     *
     * @param fieldName El nombre del campo para la búsqueda.
     * @param value Valor a buscar en el campo especificado.
     * @return El objeto encontrado o null en caso contrario.
     */
    T findBy(String fieldName, Object value);

    T findBy(String fieldName, Predicate<T> predicate);

    /**
     * Función de busqueda dentro de la tabla de acuerdo a un
     * predicado.
     *
     * @param predicate Predicado o validación a evaluar.
     * @return Lista de elementos que cumplen con el predicado.
     */
    List<T> findByPredicate(Predicate<T> predicate);
}
