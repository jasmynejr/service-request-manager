package com.angishadow.servicerequestmanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;

import com.angishadow.servicerequestmanager.helpers.*;
import com.angishadow.servicerequestmanager.models.*;
import com.angishadow.servicerequestmanager.repository.*;

@RestController
public class FilterController {
    @Autowired
    private FilterRepository filterRepo;
    @GetMapping("/filters")
    public List<Filter> allFilters(){
        FilterManager fm = new FilterManager();
        List<Filter> filters = filterRepo.findAll();
        fm.applyFilters(filters);
        return filters;
    }

    @GetMapping("/apply")
    public double applyAllFilters(){
        FilterManager fm = new FilterManager();
        List<Filter> filters = filterRepo.findAll();
        double score  = fm.applyFilters(filters);
        return score;
    }
    
}
