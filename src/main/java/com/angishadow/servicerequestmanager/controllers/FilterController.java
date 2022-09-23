package com.angishadow.servicerequestmanager.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


import com.angishadow.servicerequestmanager.helpers.*;
import com.angishadow.servicerequestmanager.models.*;
import com.angishadow.servicerequestmanager.repository.*;

@RestController
public class FilterController {
    @Autowired
    private FilterRepository filterRepo;
  
   

    @GetMapping("/filter/{type}")
    public Filter getFilterByType(@PathVariable(name="type") String type){
        return filterRepo.findByType(type);
    }
    
}
