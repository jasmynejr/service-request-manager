package com.angishadow.servicerequestmanager.models;

import javax.persistence.*;

@Entity
@Table(name="service_requests")
public class ServiceRequest {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String service_type;


    public ServiceRequest(){}


    public ServiceRequest(String name, String email, String phone, String address, String service_type) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.service_type = service_type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sr_id",columnDefinition = "serial")
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    @Column(name="client_name")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="phone")
    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="service_type")
    public String getService_type() {
        return service_type;
    }


    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    
}
