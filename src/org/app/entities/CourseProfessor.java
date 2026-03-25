package org.app.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "course_professor")
public class CourseProfessor {

    @Id
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID id;

    /**
     * Columna Auxiliar para búsquedas, etc.
     * NOTA: En producción debemos marcar la columna como
     * AUTO_INCREMENT posterior o la ejecución inicial para mantener consistencia.
     */
    @Column(name = "course_professor_id", unique = true)
    private Long courseProfessorId;

    @Column(name = "professor_id", unique = true)
    private Long professorId;

    @Column(name = "course_id", unique = true)
    private Long courseId;

    //Relaciones
    @ManyToOne
    @MapsId
    @JoinColumn(name = "course")
    private Course course;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "professor")
    private Professor professor;
}
