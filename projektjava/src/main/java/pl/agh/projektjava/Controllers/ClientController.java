package pl.agh.projektjava.Controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Entities.Client;
import pl.agh.projektjava.Entities.CompanyClient;
import pl.agh.projektjava.Entities.PersonalClient;
import pl.agh.projektjava.Services.ClientServices;

@Controller
public class ClientController {

    public ClientServices clientServ;

    public ClientController(ClientServices clientServ) {
        this.clientServ = clientServ;
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
        return "createClient";
    }

    @PostMapping("/clients/new/personal")
    public String savePersonalClient(@ModelAttribute("PC") PersonalClient client, Model model)
    {
        try {
            clientServ.addClient(client);
            model.addAttribute("message", "Added succefully") ;
            return allClients(model);  
        } catch (Exception e) {
            model.addAttribute("message", "Error- client not saved");
            return allClients(model);
        }
    }

    @PostMapping("/clients/new/personal")
    public String saveCompanyClient(@ModelAttribute("CC") CompanyClient client, Model model)
    {
        try {
            clientServ.addClient(client);
            model.addAttribute("message", "Added succefully") ;
            return allClients(model);  
        } catch (Exception e) {
            model.addAttribute("message", "Error- client not saved");
            return allClients(model);
        }
    }

}
