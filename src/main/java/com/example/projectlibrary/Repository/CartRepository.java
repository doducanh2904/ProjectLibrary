package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
