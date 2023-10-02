package com.example.main_pract1.services;

import com.example.main_pract1.tables.Students;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Services {

    public ResponseEntity <List<Students>> getAllStudents();

    public ResponseEntity <Students> getStudentId(long id);

    public String ctrateNewStudent(Students students);

    public String updateNewStudent(long id, Students students);

    public String deleteWithId(long id);

    public String deleteId();

}
