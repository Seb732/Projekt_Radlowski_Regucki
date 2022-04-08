package pl.agh.projektjava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.agh.projektjava.Entities.Car;
import pl.agh.projektjava.Exceptions.ExceptionWrongVIN;
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

    // CARS CONTROLLERS

    @GetMapping("/cars")
    public String cars(Model model){
        model.addAttribute("cars", carServices.getAll());
        return "cars";}
    
    @GetMapping("/cars/new")
    public String newCar(Model model)
    {
        try {
            model.addAttribute("car", new Car());
            return "createCar";
        } catch (Exception e) {
            return "/";
        }
    }

    @ExceptionHandler(ExceptionWrongVIN.class)
    public String vinError(Model model)
    {
        model.addAttribute("blad", "zly win");
        return newCar(model);
    }
    
    @PostMapping("/cars")
    public String saveCar(@ModelAttribute("car") Car car, Model model)
    {
        car.setStatus(Car.Status.unavailable);
        carServices.saveCar(car);
        return "redirect:/cars";
        
    }
}

