package com.angishadow.servicerequestmanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.angishadow.servicerequestmanager.helpers.*;

@RestController
public class VerifyController {
    private Verify v;
    private DomainCache c;
    public VerifyController() {
        v = new Verify();
        c = new DomainCache();
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyEmail(@RequestBody String email){
        System.out.print(email);
        String domain = v.getDomain(email.trim());
        if(c.hasDomain(domain)){
            return ResponseEntity.ok(c.getDomainValue(domain));
        }
        boolean isValid = v.checkEmail(email.trim());
        c.setDomainValue(domain, isValid);
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/verified-domains")
    public String getVerifiedDomains(){
        return c.toString();
    }
}
