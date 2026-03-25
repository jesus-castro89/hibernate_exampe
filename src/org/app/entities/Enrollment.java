package org.app.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "student_enrollment")
public class Enrollment {

    @Id
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID id;

    /**
     * Columna Auxiliar para búsquedas, etc.
     * NOTA: En producción debemos marcar la columna como
     * AUTO_INCREMENT posterior o la ejecución inicial para mantener consistencia.
     */
    @Column(name = "enrollment_id", unique = true)
    private Long enrollmentId;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private Course course;
}