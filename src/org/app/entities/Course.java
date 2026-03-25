package org.app.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID id;

    /**
     * Columna Auxiliar para búsquedas, etc.
     * NOTA: En producción debemos marcar la columna como
     * AUTO_INCREMENT posterior o la ejecución inicial para mantener consistencia.
     */
    @Column(name = "course_id", unique = true)
    private Long courseId;

    @Column(name = "course_name", nullable = false,
            unique = true)
    private String courseName;

    @Column(check = {
            @CheckConstraint(name = "chk_minimum", constraint = "minimum >= 10")
    })
    private int minimum;

    @Column(check = {
            @CheckConstraint(name = "chk_maximum", constraint = "maximum BETWEEN (minimum + 1) AND 35")
    })
    private int maximum;

    //Relaciones
    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL)
    private ArrayList<CourseProfessor> courseProfessors;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL)
    private ArrayList<Enrollment> enrollments;
}
