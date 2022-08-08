package com.example.schoolapigroupone.controller;

import com.example.schoolapigroupone.model.Students;
import com.example.schoolapigroupone.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {
    private StudentsService service;

    @GetMapping("/students")
    public List<Students> findStudents(){
        return service.findAllStudents();
    }

    @GetMapping("/students/{query}")
    public List<Students> findByNameContent(@PathVariable String query){
        return service.findWhereNameLike(query);
    }

    @PostMapping("/students")
    public Students createStudents(@RequestBody Students student){
        return service.save(student);
    }

    @PatchMapping("/students")
    public Students updateStudents(
            @RequestParam("id") Long id,
            @RequestParam("name") String newName
    ){
        return service.update(id, newName);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudents(@PathVariable Long id){
        service.deleteById(id);
        return "Resource successfully deleted";
    }

}
