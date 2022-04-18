package pl.agh.projektjava.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Services.DamageServices;

@Controller
public class DamagesController {

    private DamageServices services;

    public DamagesController(DamageServices services) {
        this.services = services;
    }



    @RequestMapping(value="/damages/delete/{id}", method = RequestMethod.POST)
    public void deleteDamage(@PathVariable Long id)
    {
        services.deleteDamage(id);
    }
    
}
