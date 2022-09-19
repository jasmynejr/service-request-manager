package com.angishadow.servicerequestmanager.helpers;
import java.util.*;
public class DomainCache {
    private Map<String,Boolean> cache;
    public DomainCache(){
        cache = new HashMap<String,Boolean>();
    }

    public boolean hasDomain(String domain){
        return cache.containsKey(domain);
    }

    public boolean getDomainValue(String domain){
        return cache.get(domain);
    }

    public void setDomainValue(String domain,boolean value){
        cache.put(domain, value);
    }

    @Override
    public String toString(){
        return cache.toString();
    }
}
