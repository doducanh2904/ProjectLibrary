package com.example.projectlibrary.Controller;


import com.example.projectlibrary.Model.Book;
import com.example.projectlibrary.Model.Cart;
import com.example.projectlibrary.Model.Category;
import com.example.projectlibrary.Model.Student;
import com.example.projectlibrary.Service.CartService;
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
@RequestMapping(value = "/cart")
public class CartController extends BasicController {
    @Autowired
    private CartService cartService;

    @PostMapping(value = "/insert/{idb}/{ids}")
    public ResponseEntity<Cart> insert(@PathVariable(value = "idb")Long bookId,@PathVariable(value = "ids")Long studentId){
        cartService.saveCart(bookId,studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/cart-full")
    public ResponseEntity<List<Cart>> showFindAll (){
        List<Cart> cartList=cartService.findAll();
        if (cartList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartList,HttpStatus.OK);
    }
    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Cart> showFindById(@PathVariable(value = "id") Long id){
        Cart cart=cartService.findById(id);
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Cart> deleteById(@PathVariable(value = "id")Long id){
        cartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
