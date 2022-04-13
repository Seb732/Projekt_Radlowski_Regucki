package pl.agh.projektjava.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Entities.Client;
import pl.agh.projektjava.Entities.CompanyClient;
import pl.agh.projektjava.Entities.PersonalClient;
import pl.agh.projektjava.Repos.ClientRepo;
import pl.agh.projektjava.Repos.CompanyClientRepo;
import pl.agh.projektjava.Repos.PersonalClientRepo;

@Service
public class ClientServices {
    
    @Autowired
    private CompanyClientRepo company;
    
    @Autowired
    private PersonalClientRepo personal;

    @Autowired
    private ClientRepo<Client> allClients;


    public ClientServices(CompanyClientRepo company, PersonalClientRepo personal, ClientRepo<Client> allClients) {
        this.company = company;
        this.personal = personal;
        this.allClients = allClients;
    }
    
    
    // GET 
    
    /**
     * Returnś all clients
     * @return
     */
    public Iterable<? extends Client> getAllClients()
    {
        return allClients.findAll();
    }

    /**
     * Returns all company clients
     * @return
     */
    public Iterable<CompanyClient> getAllCompanyClients()
    {
        return company.findAll();
    }

    /**
     * Returns all personal clients
     * @return
     */
    public Iterable<PersonalClient> getAllPersonalClients()
    {
        return personal.findAll();
    }

    /**
     * Returns comapanies where name like
     * @param name
     * @return
     */
    public Iterable<CompanyClient> getCompanyByName(String name)
    {
        return company.getCompanyByName(name);
    }

    /**
     * Returns company with given nip
     * @param nip
     * @return
     */
    public Optional<CompanyClient> getCompanyByNIP(String nip)
    {
        return company.getCompanyByNIP(nip);
    }

    /**
     * Returns company with given regon
     * @param regon
     * @return
     */
    public Optional<CompanyClient> getCompanyByRegon(String regon)
    {
        return company.getCompanyByREGON(regon);
    }

    /**
     * Add personal client
     * @param client
     */
    public void addPersonalClient(PersonalClient client)
    {
        personal.save(client);
    }

    public void addCompanyClient(CompanyClient client)
    {
        company.save(client);
    }

    
    
}
