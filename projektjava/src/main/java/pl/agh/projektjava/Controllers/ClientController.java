package pl.agh.projektjava.Controllers;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Entities.Address;
import pl.agh.projektjava.Entities.Client;
import pl.agh.projektjava.Entities.CompanyClient;
import pl.agh.projektjava.Entities.PersonalClient;
import pl.agh.projektjava.Entities.Validation;
import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongNIP;
import pl.agh.projektjava.Exceptions.ExceptionWrongPesel;
import pl.agh.projektjava.Exceptions.ExceptionWrongPostalCode;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegon;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;
import pl.agh.projektjava.Services.AddressServices;
import pl.agh.projektjava.Services.ClientServices;

@Controller
public class ClientController {

    public ClientServices clientServ;
    public AddressServices addressServices;

    public ClientController(ClientServices clientServ, AddressServices addressServices) {
        this.clientServ = clientServ;
        this.addressServices=addressServices;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String allClients(Model model)
    {
        model.addAttribute("personalClients",clientServ.getAllPersonalClients());
        model.addAttribute("companyClients", clientServ.getAllCompanyClients());
        return "clients";
    }

    @RequestMapping(value = "/clients/new", method = RequestMethod.GET)
    public String newClients(Model model)
    {
        if(model.getAttribute("person")==null)
        {
            model.addAttribute("person",new PersonalClient());
        }
        if(model.getAttribute("company")==null)
        {
            model.addAttribute("company", new CompanyClient());
        }
        if(model.getAttribute("address1")==null)
        {
            model.addAttribute("address1", new Address());
        }
        if(model.getAttribute("address2")==null)
        {
            model.addAttribute("address2", new Address());
        }
        return "createClient";
    }

    @PostMapping("/clients/new/personal")
    public String savePersonalClient(@ModelAttribute("person") PersonalClient person,@ModelAttribute("address1") Address address, Model model)
    {
        try {
            if(Validation.ValPesel(person.getPesel())){}else{throw new ExceptionWrongPesel("Pesel is not correct");}
            if(Validation.ValTeleNumb(person.getTeleNumb())){}else{throw new ExceptionWrongTeleNumb("Telephone number is not correct");}
            if(Validation.ValEmail(person.getEmail())){}else{throw new ExceptionWrongEmail("Email is not correct");}
            if(Validation.ValPostalCode(address.getPostalCode())){}else{throw new ExceptionWrongPostalCode("Postal code incorrect");}
            person.setBalance(0.00);
            
            if(address.getLocalNumb()=="")
            {address.setLocalNumb(null);}

            person.setAddress(addressServices.saveIfNotInDB(address));
            clientServ.addPersonalClient(person);
            model.addAttribute("message", "Client added") ;
            return allClients(model);  
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("person",person);
            model.addAttribute("address1", address);
            return newClients(model);
        }
    }

    @PostMapping("/clients/new/company")
    public String saveCompanyClient(@ModelAttribute("company") CompanyClient company,@ModelAttribute("address2") Address address, Model model)
    {
        try {
            // Validation
            if(Validation.ValNIP(company.getNIP())){}else{throw new ExceptionWrongNIP("NIP is not correct");}
            if(Validation.ValREGON(company.getREGON())){}else{throw new ExceptionWrongRegon("REGON is not correct");}
            if(Validation.ValTeleNumb(company.getTeleNumb())){}else{throw new ExceptionWrongTeleNumb("Telephone number is not correct");}
            if(Validation.ValEmail(company.getEmail())){}else{throw new ExceptionWrongEmail("Email is not correct");}
            if(Validation.ValPostalCode(address.getPostalCode())){}else{throw new ExceptionWrongPostalCode("Postal code incorrect");}
            
            company.setBalance(0.00);   //settings balance to 0

            if(address.getLocalNumb()=="")  
            {address.setLocalNumb(null);}

            company.setAddress(addressServices.saveIfNotInDB(address));  //saving address and setting to company
            clientServ.addCompanyClient(company);   //saving company
            model.addAttribute("message", "Client added") ;
            return allClients(model);  
        } catch (Exception e) {
            // model.addAttribute("error", e.getMessage());
            model.addAttribute("error", e.getMessage());
            model.addAttribute("company",company);
            model.addAttribute("address2", address);
            return newClients(model);
        }
    }

    @PostMapping("/clients/pay/{id}")
    public String payAll(@PathVariable Long id, Model model)
    {
        Client client=clientServ.getById(id).get();
        client.setBalance(0.00);
        clientServ.updateClient(client);
        model.addAttribute("message","All paid");
        return allClients(model);
    }

}
