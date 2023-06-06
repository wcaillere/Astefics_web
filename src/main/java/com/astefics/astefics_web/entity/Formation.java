package com.astefics.astefics_web.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formations")
public class Formation {


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "inscriptions", joinColumns = @JoinColumn(name = "id_formation"), inverseJoinColumns = @JoinColumn(name = "id_student"))
    List<Student> students = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "begin_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin_at;
    @Column(name = "nb_days")
    private int nbDays;
    @Column(name = "price")
    private float price;
    @ManyToOne(targetEntity = Level.class, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_level")
    private Level level;
    @Column(name = "is_online")
    private Boolean isOnline;
    @Column(name = "program", length = 1000)
    private String program;
    @ManyToOne(targetEntity = Category.class, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_category")
    private Category category;
    @ManyToOne(targetEntity = Teacher.class, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @PreRemove
    private void removeStudentsAssociations() {
        for (Student student : this.students) {
            student.getFormations().remove(this);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBegin_at() {
        return begin_at;
    }

    public void setBegin_at(Date begin_at) {
        this.begin_at = begin_at;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "students=" + students +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", begin_at=" + begin_at +
                ", nbDays=" + nbDays +
                ", price=" + price +
                ", level=" + level +
                ", isOnline=" + isOnline +
                ", program='" + program + '\'' +
                ", category=" + category +
                ", teacher=" + teacher +
                '}';
    }
}
