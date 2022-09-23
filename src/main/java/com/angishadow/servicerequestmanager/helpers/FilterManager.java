package com.angishadow.servicerequestmanager.helpers;

import java.util.List;


import com.angishadow.servicerequestmanager.models.*;

public class FilterManager {
    
    Verify v;
    public FilterManager(){
        v = new Verify();
    }
    
    
    public double applyFilters(List<Filter> filters,ServiceRequest s){
        double finalScore = 0;
        double totalWeight = 0;
        
        for(int i = 0; i<filters.size();i++){
            Filter cur = filters.get(i);
            totalWeight+=cur.getWeight();

        }
        for(int i = 0; i<filters.size();i++){
            Filter cur = filters.get(i);
            double score;
            if(cur.getType().equals("email")){
                boolean validEmail = v.checkEmail(s.getEmail());
                score = validEmail ? 100 : 0;
            }
            else{
                score = cur.applyFilter();
            }
            
            finalScore += (cur.getWeight() / totalWeight) * score;
            if (finalScore >= .7) {
                return finalScore;
            }
        }

        return finalScore;
    }

}
