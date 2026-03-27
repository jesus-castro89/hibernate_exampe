package org.app.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import java.util.UUID;


@Entity
@Table(
        name = "person",
        uniqueConstraints = {
                @UniqueConstraint(name = "UK_person_email", columnNames = "email"),
                @UniqueConstraint(name = "UK_person_person_id", columnNames = "person_id")
        }
)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID",
            nullable = false,
            updatable = false,
            insertable = false)
    private UUID id;

    @Column(name = "person_id",
            unique = true,
            insertable = false,
            updatable = false)
    @Generated(event = EventType.INSERT)
    private Long personId;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(nullable = false,
            check = {
                    @CheckConstraint(name = "chk_email_format", constraint = "email LIKE '%_@__%.__%'")
            })
    private String email;

    @Column(check = {
            @CheckConstraint(name = "chk_age_range",
                    constraint = "age BETWEEN 0 AND 120")
    })
    private Integer age;

    // Relaciones
    @OneToOne(mappedBy = "person",
            cascade = CascadeType.ALL,
            optional = true)
    private Student student;

    @OneToOne(mappedBy = "person",
            cascade = CascadeType.ALL,
            optional = true)
    private Professor teacher;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public Professor getTeacher() {
        return teacher;
    }
}
