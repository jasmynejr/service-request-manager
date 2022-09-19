package com.angishadow.servicerequestmanager.helpers;

import java.util.List;


import com.angishadow.servicerequestmanager.models.*;

public class FilterManager {
    
    
    
    public double applyFilters(List<Filter> filters){
        double finalScore = 0;
        double totalWeight = 0;
        
        for(int i = 0; i<filters.size();i++){
            Filter cur = filters.get(i);
            totalWeight+=cur.getWeight();

        }
        for(int i = 0; i<filters.size();i++){
            Filter cur = filters.get(i);
            double score = cur.randomScore();
            finalScore += (cur.getWeight() / totalWeight) * score;
        }

        return finalScore;
    }

}
