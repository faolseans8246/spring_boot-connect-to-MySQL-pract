package com.example.main_pract1.services.extraService;

import com.example.main_pract1.reposiyories.Repositories;
import com.example.main_pract1.services.Services;
import com.example.main_pract1.tables.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ExtraService implements Services {

    @Autowired
    private final Repositories repositories;

    public ExtraService (Repositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public ResponseEntity<List<Students>> getAllStudents() {

        List <Students> otherStudents = new ArrayList<>();

        repositories.findAll().forEach(otherStudents::add);
        return new ResponseEntity<List<Students>>(otherStudents, HttpStatus.OK);
    }

    @Override
    public ResponseEntity <Students> getStudentId(long id) {
        Optional <Students> optId = repositories.findById(id);

        if (optId.isPresent()) {
            return new ResponseEntity<>(optId.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public String ctrateNewStudent(Students students) {
        repositories.save(students);

        return "Ma'lumot saqlandi!";
    }


    @Override
    public String updateNewStudent(long id, Students students) {
        Optional <Students> optIds = repositories.findById(id);

        if (optIds.isPresent()) {
            Students otherStudent = optIds.get();

            otherStudent.setName(students.getName());
            otherStudent.setSurname(students.getSurname());
            otherStudent.setYears(students.years);
            otherStudent.setAddress(students.getAddress());

            repositories.save(otherStudent);
            return "Uzgarish saqlandi!";
        } else {
            return "Dasturda hatolik mavjud!";
        }
    }

    @Override
    public String deleteWithId(long id) {
        repositories.deleteById(id);

        return "Berilgan element o'chirildi!";
    }


    @Override
    public String deleteId() {
        repositories.deleteAll();

        return "Malumotlar tozalandi!";
    }


}
