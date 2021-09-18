package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Borow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borow,Long> {
}
