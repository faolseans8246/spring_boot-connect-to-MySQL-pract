package com.example.main_pract1.controller;

import com.example.main_pract1.services.Services;
import com.example.main_pract1.tables.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outerPath")
public class Controller {

    @Autowired
    private final Services services;


    public Controller (Services services) {
        this.services = services;
    }


    @GetMapping("/innerPath")
    public ResponseEntity <List<Students>> hammasiniOlish() {
        return services.getAllStudents();
    }

    @GetMapping("/innerPath/{id}")
    public ResponseEntity <Students> idBilanOlish(@PathVariable long id) {
        return services.getStudentId(id);
    }


    @PostMapping("/innerPath")
    public String saqlash(@RequestBody Students students) {
        return services.ctrateNewStudent(students);
    }


    @PutMapping("/innerPath/{id}")
    public String uzgartirish(@PathVariable long id, @RequestBody Students students) {
        return services.updateNewStudent(id, students);
    }

    @DeleteMapping("/innerPath/{id}")
    public String idBilanUchirish(@PathVariable long id) {
        return services.deleteWithId(id);
    }

    @DeleteMapping("/innerPath")
    public String hammasiniUchirish() {
        return services.deleteId();
    }

}
