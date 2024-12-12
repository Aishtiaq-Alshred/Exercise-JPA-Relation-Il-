package com.example.jparelationi.Controller;


import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return   ResponseEntity.status(200).body(courseService.getCourse());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course){
        courseService.addCourse(teacher_id, course);
        return ResponseEntity.status(200).body("course added");
    }

    @PutMapping("/update/{teacher_id}")
    public ResponseEntity update(@PathVariable Integer teacher_id,@RequestBody @Valid Course course){
        courseService.update(teacher_id, course);
        return ResponseEntity.status(200).body("course updated");

    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@PathVariable Integer id){
        courseService.delete(id);
        return ResponseEntity.status(200).body("course delete");

    }

    @GetMapping("/getTeacherByCourse/{id}")
    public ResponseEntity TeacherByCourse(@PathVariable Integer id){
        courseService.TeacherByCourse(id);
        return ResponseEntity.status(200).body("the teacher details");

    }








}
