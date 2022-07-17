package com.example.mappings.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class OneToOneController {

    @Autowired
    private HusbandRepo husbandRepoObj;


    Husband husbandObj = new Husband();


    Wife wifeObj = new Wife();

    @PostMapping("/createHusband")
    public ResponseEntity<?> createHusband(@RequestBody Husband husband){

        husbandObj.setName(husband.getName());
        husbandObj.setAge(husband.getAge());

        wifeObj.setName(husband.getWife().getName());
        wifeObj.setAge(husband.getWife().getAge());

//        Set<Wife> set = new HashSet<>();
//        set.add(wifeObj);
//
//        Set<Husband> set2 = new HashSet<>();
//        set2.add(husbandObj);

        husbandObj.setWife(wifeObj);
        wifeObj.setHusband(husbandObj);


        System.out.println(husbandObj);
        System.out.println(wifeObj);
        Husband husbandResponse = new Husband();
        try {
            husbandRepoObj.save(husbandObj);
        }catch(Exception e){
            System.out.println(e);
        }
        // not able to save new detail, it overrides the previous one.
        System.out.println("Successfully Saved to DB");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/fetchHusband/{id}")
    public ResponseEntity<?> fetchHusband(@PathVariable long id){

        Optional<Husband> husband    =  husbandRepoObj.findById(id);

        System.out.println("Successfully fetched from DB");
        System.out.println(husband.get().toString());
        // how to break the recursive loop here.
        return new ResponseEntity<>(husband.get(), HttpStatus.OK);
    }

}
