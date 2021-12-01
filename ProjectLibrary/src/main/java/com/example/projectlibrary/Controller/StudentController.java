package com.example.projectlibrary.Controller;


import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Category;
//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController extends BasicController{
    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/student-full")
    public ResponseEntity<List<Student>> showAll(){
        List<Student> studentList=studentService.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);

    }

    @GetMapping(value = "/searchname/{name}")
    public ResponseEntity<List<Student>> showFindByName(@PathVariable(value = "name") String studentName){
        studentName=studentName.trim();
        List<Student> studentList=studentService.findByStudentSearch(studentName);
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Student> showFindById(@PathVariable(value = "id") Long id){
        Student student=studentService.findById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }


    @PostMapping(value = "/insert")
    public ResponseEntity<Student> insert(@Validated @RequestBody Student student, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            for (final FieldError error:result.getFieldErrors()){
                System.out.println(errors.append("/"+error.getDefaultMessage()));
            }
        }
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Student> updateById(@PathVariable(value = "id")Long id ,@Validated @RequestBody Student student, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            for (final FieldError error:result.getFieldErrors()){
                System.out.println(errors.append("/"+error.getDefaultMessage()));
            }
        }
        studentService.update(id,student);
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable(value = "id")Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
