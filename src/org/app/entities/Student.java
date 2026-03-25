package org.app.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id",
            columnDefinition = "UUID")
    private UUID personId;

    /**
     * Columna Auxiliar para búsquedas, etc.
     * NOTA: En producción debemos marcar la columna como
     * AUTO_INCREMENT posterior o la ejecución inicial para mantener consistencia.
     */
    @Column(name = "student_id",
            unique = true)
    private Long studentId;

    @Column(name = "enrollment_date",
            nullable = false)
    private LocalDate enrollmentDate;

    //Relaciona
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Person person;

    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL)
    private ArrayList<Enrollment> enrollments;
}
