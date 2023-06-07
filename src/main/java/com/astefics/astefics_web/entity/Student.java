package com.astefics.astefics_web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lastname", length = 40, nullable = false)
    private String lastname;
    @Column(name = "firstname", length = 40, nullable = false)
    private String firstname;

    @ManyToMany(mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Formation> formations = new ArrayList<>();

    @PreRemove
    private void removeFormationAssociations() {
        for (Formation formation : this.formations) {
            formation.getStudents().remove(this);
        }
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", formations=" + formations +
                '}';
    }
}
