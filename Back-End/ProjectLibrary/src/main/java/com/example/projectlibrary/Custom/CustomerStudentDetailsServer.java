package com.example.projectlibrary.Custom;

//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Model.Role;
import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerStudentDetailsServer implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if(student ==null) {
            throw new UsernameNotFoundException("Người dùng này chưa tồn tại nhé :))");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = student.getRoles();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        UserDetails userDetails=(UserDetails) new User(student.getUsername(),student.getPassword(),authorities);
        return userDetails;

    }
}

