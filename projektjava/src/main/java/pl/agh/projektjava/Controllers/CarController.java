package pl.agh.projektjava.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Entities.Car;
import pl.agh.projektjava.Entities.Validation;
import pl.agh.projektjava.Exceptions.ExceptionWrongProdYear;
import pl.agh.projektjava.Exceptions.ExceptionWrongRegistNumb;
import pl.agh.projektjava.Exceptions.ExceptionWrongVIN;
import pl.agh.projektjava.Services.CarServices;

@Controller
public class CarController {
    private CarServices carServices;

    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping("/cars")
    public String cars(Model model){
        model.addAttribute("cars", carServices.getAll());
        return "cars";}
    
    /**
     * Returns form to create new car
     * @param model
     * @return
     */
    // @GetMapping("/cars/new")
    @RequestMapping(value = "/cars/new", method = RequestMethod.GET)
    public String newCar(Model model)
    {
        if(model.getAttribute("car")==null)
        {
            model.addAttribute("car", new Car());
        }
        return "createCar";
    }
    
    /**
     * Checks if all car info is valid and saves it. If it's not valid then returns error to form.
     * @param car
     * @param model
     * @return
     */
    @PostMapping("/cars/new")
    public String saveCar(@ModelAttribute("car") Car car, Model model)
    {
        try {
            if(Validation.ValVIN(car.getVIN())){} else {throw new ExceptionWrongVIN("Incorrect VIN");}
            if(Validation.ValProdYear(car.getProdYear())){} else {throw new ExceptionWrongProdYear("Incorrect roduction year");}
            if(Validation.ValRegistNumb(car.getRegistNumb())){} else {throw new ExceptionWrongRegistNumb("Incorrect  registration number");}
            car.setStatus(Car.Status.unavailable);
            carServices.saveCar(car);
            model.addAttribute("message", "Car saved");
            return "redirect:/cars";
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            model.addAttribute("car", car);
            return newCar(model);
        }
    }

    /**
     * Returns details of car with given vin
     * @param vin
     * @param model
     * @return
     */
    @GetMapping("/cars/details/{vin}")
    public String summaryCar(@PathVariable String vin, Model model)
    {
        model.addAttribute("car",carServices.getCarByVin(vin).get());
        return "carDetails";
    }

    /**
     * Returns edit page for car
     * @param vin
     * @param model
     * @return
     */
    @RequestMapping(value = "/cars/edit/{vin}",method = RequestMethod.GET)
    public String editCarForm(@PathVariable String vin, Model model)
    {
        model.addAttribute("car", carServices.getCarByVin(vin).get());
        return "editCar";
    }

    /**
     * Checks all params and update car, if data not correct then returns error message
     * @param car
     * @param model
     * @return
     */
    @PostMapping("/cars/edit/{vin}")
    public String saveEditedCar(@ModelAttribute("car") Car car, Model model)
    {
        try {
            if(Validation.ValVIN(car.getVIN())){} else {throw new ExceptionWrongVIN("Incorrect VIN");}
            if(Validation.ValProdYear(car.getProdYear())){} else {throw new ExceptionWrongProdYear("Incorrect roduction year");}
            if(Validation.ValRegistNumb(car.getRegistNumb())){} else {throw new ExceptionWrongRegistNumb("Incorrect  registration number");}
            carServices.saveCar(car);
            model.addAttribute("message", "Car info updated");
            return cars(model);
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            model.addAttribute("car", car);
            return editCarForm(car.getVIN(),model);
        }
    }

    @PostMapping("/cars/delete/{vin}")
    public String deleteCar(@PathVariable String vin, Model model)
    {
        carServices.deleteCarByVin(vin);
        model.addAttribute("message", "Car succefully deleted");
        return cars(model);
    }
}
