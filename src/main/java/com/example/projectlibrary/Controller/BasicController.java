package com.example.projectlibrary.Controller;

import com.example.projectlibrary.Service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicController {
    @Autowired
    protected LibraryanService libraryanService;
    @Autowired
    protected CategoryService categoryService;
    @Autowired
    protected BookService bookService;
}
