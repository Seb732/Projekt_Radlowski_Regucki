package pl.agh.projektjava.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Services.ClientServices;

@Controller
public class ClientController {

    public ClientServices client;

    public ClientController(ClientServices client) {
        this.client = client;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String allClients(Model model)
    {
        model.addAttribute("personalClients",client.getAllPersonalClients());
        model.addAttribute("companyClients", client.getAllCompanyClients());
        return "clients";
    }

}
