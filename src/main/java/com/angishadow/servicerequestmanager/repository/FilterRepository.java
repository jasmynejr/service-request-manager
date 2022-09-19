package com.angishadow.servicerequestmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.angishadow.servicerequestmanager.models.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter,Long>{
    
}
