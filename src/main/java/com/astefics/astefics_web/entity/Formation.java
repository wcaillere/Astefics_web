package com.astefics.astefics_web.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "begin_at")
    private Date begin_at;
    @Column(name = "nb_days")
    private int nbDays;
    @Column(name = "price")
    private float price;
    @ManyToOne(targetEntity = Level.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_level")
    private Level level;
    @Column(name = "is_online")
    private Boolean isOnline;
    @Column(name = "program")
    private String program;
    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category category;
    @ManyToOne(targetEntity = Teacher.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
}
