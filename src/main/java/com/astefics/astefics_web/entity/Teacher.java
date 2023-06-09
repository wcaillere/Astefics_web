package com.astefics.astefics_web.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lastname", length = 40, nullable = false)
    private String lastname;
    @Column(name = "firstname", length = 40, nullable = false)
    private String firstname;

    @OneToMany(mappedBy = "teacher", targetEntity = Formation.class, cascade = CascadeType.ALL)
    private List<Formation> formations = new ArrayList<>();
    
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", formations=" + formations +
                '}';
    }
}
