//package com.example.projectlibrary.Repository;
//
//import com.example.projectlibrary.Model.Libraryan;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface LibraryanRepository extends JpaRepository<Libraryan,Long> {
//    @Query(value = "SELECT * FROM libraryan WHERE libraryan_name LIKE %?1% OR gmail LIKE %?1% OR libraryan_id LIKE %?1%",nativeQuery = true)
//    List<Libraryan> findByLibraryanName(String libraryanName);
//}
//
//
//
