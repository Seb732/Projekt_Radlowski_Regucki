package pl.agh.projektjava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.agh.projektjava.Services.CarServices;

@Controller
public class AppController {

    private CarServices carServices;

    public AppController(CarServices carServices)
    {
        this.carServices=carServices;
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


    @GetMapping("/cars")
    public String clients(Model model){
        model.addAttribute("cars", carServices.getAll());
        return "cars";}

    
}

