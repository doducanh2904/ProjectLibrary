package com.example.projectlibrary.Config;

import com.example.projectlibrary.Model.Book;


//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Model.Role;
//import com.example.projectlibrary.Repository.LibraryanRepository;
import com.example.projectlibrary.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.projectlibrary.Repository.StudentRepository;
import com.example.projectlibrary.Model.Student;

import java.util.HashSet;


@Component
public class addfirtdata implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private StudentRepository studentRepository;
//    @Autowired
//    private LibraryanRepository libraryanRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // Roles
        if (roleRepository.findByName("ADMIN") == null) {
            Role role=new Role("ADMIN");
            roleRepository.save(role);
        }

        if (roleRepository.findByName("USER") == null) {
            Role role=new Role("USER");
            roleRepository.save(role);
        }
// Tài khoản thủ thư
        if(studentRepository.findByUsername("33")==null) {
            Student student = new Student();
            student.setGmail("doducanh@gmail.com");
            student.setStudentClass("44k21.2");
            student.setStudentName("anh");
            student.setSex("nam");
            student.setPassword(passwordEncoder.encode("33"));
            student.setUsername("33");
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_USER"));
            student.setRoles(roles);
            studentRepository.save(student);
        }

        // Tài khoản sinh viên
        if(studentRepository.findByUsername("22")==null) {
            Student student1 = new Student();
            student1.setGmail("doducanh@gmail.com");
            student1.setStudentClass("44k21.2");
            student1.setStudentName("anh");
            student1.setSex("nam");
            student1.setPassword(passwordEncoder.encode("22"));
            student1.setUsername("22");
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("USER"));
            student1.setRoles(roles);
            studentRepository.save(student1);
        }


    }
}
