package com.angishadow.servicerequestmanager.controllers;

import org.springframework.web.bind.annotation.*;
import com.angishadow.servicerequestmanager.models.*;
import com.angishadow.servicerequestmanager.repository.*;
import com.angishadow.servicerequestmanager.helpers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.*;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServiceRequestsController {
    
    @Autowired
    private ServiceRequestRepository srRepo;

    @Autowired
    private VerifyController ver;

    @Autowired
    private FilterRepository filterRepo;

    private FilterManager fm;
    public ServiceRequestsController(){
        
        fm = new FilterManager();
    }

    @GetMapping("/service-requests")
    public List<ServiceRequest> getAllServiceRequests(){
        return srRepo.findAll();
    }

    @PostMapping("/service-requests/new")
    public ResponseEntity<ServiceRequest> newServiceRequest(@RequestBody ServiceRequest sr){
        srRepo.save(sr);
        return ResponseEntity.ok().body(sr);
    }

    @PostMapping("/service-requests/apply/{id}")
    public ResponseEntity<Double> checkServiceRequest(@PathVariable(name="id") long id){
        List<Filter> allFilters = filterRepo.findAll();
        Optional<ServiceRequest> srEnt = srRepo.findById(id);
        ServiceRequest sr = srEnt.get();
        //ResponseEntity<Boolean> emailValid = ver.verifyEmail(sr.getEmail());
        double sr_score = fm.applyFilters(allFilters, sr);

        return ResponseEntity.ok(sr_score);
    }
}
