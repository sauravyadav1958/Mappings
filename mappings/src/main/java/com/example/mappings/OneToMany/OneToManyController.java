package com.example.mappings.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
public class OneToManyController {

    @Autowired
    private StudentRepo studentRepoObj;

    @Autowired
    private CourseRepo courseRepoObj;


    Student studentObj = new Student();


    Course courseObj = new Course();

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student student){

        studentObj.setName(student.getName());
        studentObj.setAge(student.getAge());



        studentObj.setCourse(student.getCourse());

        Set<Course> set = student.getCourse();

        for(Course x : set){
            courseObj.setName(x.getName());
            courseObj.setAge(x.getAge());

        }

        set.add(courseObj);


//        studentObj.setCourse(set);
        courseObj.setStudent(studentObj);

        System.out.println(1);
        System.out.println(studentObj);
        System.out.println(courseObj);

        try {
            studentRepoObj.save(studentObj);
        }catch(Exception e){
            System.out.println(e);
        }
        // here may be if we consider unique id in the body also, then it would create a new detail.
        System.out.println("Successfully Saved to DB");
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("/fetchHusband/{id}")
//    public ResponseEntity<?> fetchHusband(@PathVariable long id){
//
//        Optional<Student> husband =  husbandRepoObj.findById(id);
//
//        System.out.println("Successfully fetched from DB");
//        System.out.println(husband.get());
//        // how to break the recursive loop here.
//        return new ResponseEntity<>(husband.get(), HttpStatus.OK);
//    }

}
