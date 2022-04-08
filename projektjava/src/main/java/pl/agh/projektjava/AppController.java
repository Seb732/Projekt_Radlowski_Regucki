package pl.agh.projektjava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.agh.projektjava.Entities.Car;
import pl.agh.projektjava.Entities.Validation;
import pl.agh.projektjava.Exceptions.ExceptionWrongProdYear;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegistNumb;
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
        if(model.getAttribute("car")==null)
        {
            model.addAttribute("car", new Car());
        }
        return "createCar";
    }
    
    @PostMapping("/cars")
    public String saveCar(@ModelAttribute("car") Car car, Model model)
    {
        try {
            if(Validation.ValVIN(car.getVIN())){} else {throw new ExceptionWrongVIN("Incorrect VIN");}
            if(Validation.ValProdYear(car.getProdYear())){} else {throw new ExceptionWrongProdYear("Incorrect roduction year");}
            if(Validation.ValRegistNumb(car.getRegistNumb())){} else {throw new ExceptionWrongRegistNumb("Incorrect  registration number");}
            car.setStatus(Car.Status.unavailable);
            carServices.saveCar(car);
            return "redirect:/cars";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            model.addAttribute("car", car);
            return newCar(model);
        }
        
    }
}

