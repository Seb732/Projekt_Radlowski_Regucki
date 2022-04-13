package pl.agh.projektjava.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.agh.projektjava.Services.DamageServices;

@Controller
public class DamagesController {

    private DamageServices services;

    public DamagesController(DamageServices services) {
        this.services = services;
    }



    @RequestMapping("/damages/delete/{id}")
    public void deleteDamage(@PathVariable Long id)
    {
        services.deleteDamage(id);
    }
    
}
