package com.example.MCardSpring.Service;

import com.example.MCardSpring.Exception.OpportunityNotFoundException;
import com.example.MCardSpring.MainModel.Opportunity;
import com.example.MCardSpring.Repository.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunityService {
    OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity createOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }

    public Opportunity getOpportunity(Long id) {
        return opportunityRepository.findById(id)
                .orElseThrow(() -> new OpportunityNotFoundException(id));
    }

    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id)
                .orElseThrow(() -> new OpportunityNotFoundException(id));
    }

    public void updateOpportunity(Opportunity newOpportunity, Long id) {
        Opportunity opportunity = opportunityRepository.findById(id).get();
        System.out.println(opportunity.toString());
        opportunity.setName(newOpportunity.getName());

    }

    public List<Opportunity> listOpportunities() {
        return new ArrayList<>(opportunityRepository.findAll());
    }

}