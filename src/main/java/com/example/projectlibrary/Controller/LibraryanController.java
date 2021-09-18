package com.example.projectlibrary.Controller;

import com.example.projectlibrary.Model.Libraryan;
//import com.example.projectlibrary.Service.LibraryanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Binding;
import java.util.List;

@RestController
@RequestMapping(value = "/libraryan")
public class LibraryanController extends BasicController{


    @GetMapping(value = "/libraryan-full")
    public ResponseEntity<List<Libraryan>> showAll(){
        List<Libraryan> customerList=libraryanService.findAll();
        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Libraryan>> showFindByName(@PathVariable(value = "name") String libraryanName){
        libraryanName=libraryanName.trim();
        List<Libraryan> libraryaList=libraryanService.findByLibraryanName(libraryanName);
        if (libraryaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(libraryaList,HttpStatus.OK);
    }


    @PostMapping(value = "/insert")
    public ResponseEntity<Libraryan> insert(@Validated @RequestBody Libraryan libraryan, BindingResult result){
        if(result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            for (final FieldError error:result.getFieldErrors()){
                System.out.println(errors.append("/"+error.getDefaultMessage()));
            }
        }
            libraryanService.save(libraryan);
            return new ResponseEntity<>(HttpStatus.OK);


    }

}
