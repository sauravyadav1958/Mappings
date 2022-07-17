package com.example.mappings.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "husband")
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "husband_id")
    private long id;

    private String name;

    private int age;

    //    fetch = FetchType.LAZY : fetch only required details
    //    fetch = FetchType.EAGER : fetch all details
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    // referencedColumnName = "id" : The name of the column referenced by this foreign key column
    @JoinColumn(name = "wife_Id", referencedColumnName = "wife_Id") // join table will remove join column // how to get multiple columns in a join table
//    @JoinTable(name = "Husband_Wife", joinColumns = @JoinColumns({@JoinColumn(name = "husband_id")}),inverseJoinColumns = @JoinColumn(name = "wife_id"))
//    @JoinTable(
//            name = "Husband_Wife",
//            joinColumns = @JoinColumn(name = "husband_id"),
//            inverseJoinColumns = @JoinColumn(name = "wife_Id"))
//    @OneToMany( cascade = CascadeType.ALL, mappedBy = "husband")

//    @ManyToMany( cascade = CascadeType.ALL)
//    @JoinTable(name = "wife_list", joinColumns = @JoinColumn(name = "husband_id"),
//            inverseJoinColumns = @JoinColumn(name="wife_id"))
//    @JsonManagedReference
    private Wife wife;

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

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
