package com.example.projectlibrary.Controller;


import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Borow;
import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    @PostMapping(value = "/insert")
    public ResponseEntity<Borow> insert(@RequestBody Borow borow){
        borrowService.save(borow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/borrow-full")
    public ResponseEntity<List<Borow>> showAll(){
        List<Borow> borowList=borrowService.findAll();
        if (borowList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(borowList,HttpStatus.OK);
    }
//    Thông báo từ Admin
    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Borow> findById(@PathVariable Long id){
        Borow borow= borrowService.findById(id);
        return new ResponseEntity<>(borow,HttpStatus.OK);
    }
//    Tra cứu lịch sử đặt sách (Lấy ra theo tham số id là student_id)
    @GetMapping(value = "/searchhistory/{id}")
    public ResponseEntity<List<Borow>> showHistory(@PathVariable(value = "id") Long id){
        List<Borow> borow1 = borrowService.findBorowByIdAndRole(id);
        return new ResponseEntity<>(borow1,HttpStatus.OK);
    }
//    Show ra toàn bộ yêu cầu mượn sách
//    @GetMapping(value = "/borrow-full")
//    public ResponseEntity<List<Borow>> findAllRequestBorow(){
//        List<Borow> borowList=borrowService.findAllRequestBorow();
//        if (borowList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(borowList,HttpStatus.OK);
//    }



    @PutMapping(value = "/updateAccept/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Borow> updateAccept(@PathVariable(value ="id")Long id) {
        borrowService.updateAccept(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/updateNotAccept/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Borow> updateNotAccept(@PathVariable(value ="id")Long id) {
        borrowService.updateNotAccept(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
