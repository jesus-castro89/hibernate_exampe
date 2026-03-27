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

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(ArrayList<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
