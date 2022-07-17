package com.example.mappings.ManyToMany;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courseM")
public class CourseM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private long id;

    private String name;

    private int age;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Student_Course_M",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    @JsonBackReference
    private Set<StudentM> studentM;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<StudentM> getStudentM() {
        return studentM;
    }

    public void setStudentM(Set<StudentM> studentM) {
        this.studentM = studentM;
    }
}
