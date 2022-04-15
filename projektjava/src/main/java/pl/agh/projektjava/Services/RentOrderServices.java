package pl.agh.projektjava.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Repos.CompanyClientRepo;
import pl.agh.projektjava.Repos.PersonalClientRepo;
import pl.agh.projektjava.Repos.RentOrderRepo;
import pl.agh.projektjava.Entities.RentOrder;


@Service
public class RentOrderServices {
    
    @Autowired
    private RentOrderRepo repo;

    @Autowired
    private CompanyClientRepo companyClientRepo;

    @Autowired
    private PersonalClientRepo personalClientRepo;
    public RentOrderServices(){}

    public RentOrderServices(RentOrderRepo repo, CompanyClientRepo companyClientRepo, PersonalClientRepo personalClientRepo) {
        this.repo = repo;
        this.companyClientRepo = companyClientRepo;
        this.personalClientRepo = personalClientRepo;
    }

    public Iterable<RentOrder> getAllRentOrders(){
        return repo.findAll();
    }

    public Iterable<String> getCompanyClientsIds(){return companyClientRepo.getCompanyClientsIds();}
    public Iterable<String> getPersonalClientsIds(){return personalClientRepo.getPersonalClientsIds();}
}
