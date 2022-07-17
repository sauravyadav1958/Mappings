package com.example.mappings.OneToMany;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private long id;

    private String name;

    private int age;

    //    fetch = FetchType.LAZY : fetch only required details
    //    fetch = FetchType.EAGER : fetch all details
    // in oneToMany can have mappedBy, ManyToOne can't have.
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "student")
    // referencedColumnName = "id" : The name of the column referenced by this foreign key column
//    @JoinTable(name = "Husband_Wife", joinColumns = @JoinColumns({@JoinColumn(name = "husband_id")}),inverseJoinColumns = @JoinColumn(name = "wife_id"))


//    @ManyToMany( cascade = CascadeType.ALL)
//    @JoinTable(name = "wife_list", joinColumns = @JoinColumn(name = "husband_id"),
//            inverseJoinColumns = @JoinColumn(name="wife_id"))
//    @JsonManagedReference
    private Set<Course> course;

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

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }
}
