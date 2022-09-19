package com.angishadow.servicerequestmanager.models;


//import javax.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name="filters")
public class Filter {
    private long id;
    private String type;
    private int priority;
    private double weight;

    public Filter() {
    }

    public Filter(String type, int priority, double weight) {
        this.type = type;
        this.priority = priority;
        this.weight = weight;
    }

    @Id
    @Column(name="filter_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="filter_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Column(name="weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double randomScore(){
        return Math.random();
    }

    @Override
    public String toString(){
        return "Type:"+type+"\nPriority:"+priority+"\nWeight:"+weight;
    }
    
    
}
