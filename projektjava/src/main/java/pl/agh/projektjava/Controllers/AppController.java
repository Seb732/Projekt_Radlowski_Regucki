package pl.agh.projektjava.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Services.CarServices;
import pl.agh.projektjava.Services.UserServices;

@Controller
public class AppController {

    private CarServices carServices;
    private UserServices userServices;


    public AppController(CarServices carServices, UserServices userServices) {
        this.carServices = carServices;
        this.userServices = userServices;
    }
    


    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping("/")
    public String mainPage(Model model)
    {
        model.addAttribute("cars",carServices.getAllHired());
        return "index";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings(Model model)
    {
        model.addAttribute("users",userServices.getAll());
        return "settings";
    }

}

