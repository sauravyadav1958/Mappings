package com.example.mappings.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;


@RestController
public class ManyToManyController {

    @Autowired
    private StudentRepoM studentRepoMObj;

    @Autowired
    private CourseRepoM courseRepoMObj;


    StudentM studentMObj = new StudentM();


    CourseM courseMObj = new CourseM();

    @PostMapping("/createStudentM")
    public ResponseEntity<?> createStudentM(@RequestBody StudentM studentM){

        studentMObj.setName(studentM.getName());
        studentMObj.setAge(studentM.getAge());



        studentMObj.setCourse(studentM.getCourse());

        Set<StudentM> set = new HashSet<>();

//        for(CourseM x : set){
//            courseMObj.setName(x.getName());
//            courseMObj.setAge(x.getAge());
//
//        }

        set.add(studentMObj);


//        studentObj.setCourse(set);
        courseMObj.setStudentM(set);

        System.out.println(1);
        System.out.println(studentMObj);
        System.out.println(courseMObj);

        try {
            studentRepoMObj.save(studentMObj);
        }catch(Exception e){
            System.out.println(e);
        }

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
