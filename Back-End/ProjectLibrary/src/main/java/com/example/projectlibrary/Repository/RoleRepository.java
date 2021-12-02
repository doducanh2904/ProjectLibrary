package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Category;
//import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);

}
