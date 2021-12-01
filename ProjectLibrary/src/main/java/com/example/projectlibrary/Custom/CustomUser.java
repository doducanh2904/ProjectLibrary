//package com.example.projectlibrary.Custom;
//
//import com.example.projectlibrary.Model.Role;
//import com.example.projectlibrary.Model.Student;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//public class CustomUser implements UserDetails {
//    private Student student;
//
////    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////    Set<Role> roles = student.getRoles();
////        for (Role role : roles) {
////        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
////    }
//
//    public CustomUser(String username,String password,String grantedAuthorities)
//    {
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}
