package com.example.projectlibrary.Service.impl;

import com.example.projectlibrary.Model.Libraryan;
import com.example.projectlibrary.Repository.LibraryanRepository;
import com.example.projectlibrary.Service.LibraryanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryanServiceimpl implements LibraryanService {
    @Autowired
    private LibraryanRepository libraryanRepository;
    @Autowired
    public List<Libraryan> findAll (){
        return libraryanRepository.findAll();
    }
    public void save(Libraryan libraryan){
        libraryanRepository.save(libraryan);

    }
    public List<Libraryan> findByLibraryanName(String libraryanName){
        return libraryanRepository.findByLibraryanName(libraryanName);
    }
}
