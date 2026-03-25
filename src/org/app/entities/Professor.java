package org.app.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @Column(columnDefinition = "UUID")
    private UUID id;

    /**
     * Columna Auxiliar para búsquedas, etc.
     * NOTA: En producción debemos marcar la columna como
     * AUTO_INCREMENT posterior o la ejecución inicial para mantener consistencia.
     */
    @Column(name = "professor_id",
            unique = true)
    private Long professorId;

    @Column(nullable = false,
            check = {
                    @CheckConstraint(name = "chk_hours", constraint = "hours >= 0")
            })
    private int hours;

    //Relaciones
    @OneToMany(mappedBy = "professor",
            cascade = CascadeType.ALL)
    private ArrayList<CourseProfessor> courseProfessors;
}
