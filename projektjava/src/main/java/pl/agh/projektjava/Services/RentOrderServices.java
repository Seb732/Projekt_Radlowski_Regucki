package pl.agh.projektjava.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Repos.RentOrderRepo;

@Service
public class RentOrderServices {
    
    @Autowired
    private RentOrderRepo repo;


    public RentOrderServices(RentOrderRepo repo) {
        this.repo = repo;
    }

    
}
