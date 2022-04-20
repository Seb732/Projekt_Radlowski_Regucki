package pl.agh.projektjava.Controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Entities.Address;
import pl.agh.projektjava.Entities.User;
import pl.agh.projektjava.Entities.Validation;
import pl.agh.projektjava.Exceptions.ExceptionWrongEmail;
import pl.agh.projektjava.Exceptions.ExceptionWrongTeleNumb;
import pl.agh.projektjava.Security.MyUserDetails;
import pl.agh.projektjava.Services.AddressServices;
import pl.agh.projektjava.Services.CarServices;
import pl.agh.projektjava.Services.UserServices;

@Controller
public class AppController {

    private CarServices carServices;
    private UserServices userServices;
    private AddressServices addressServices;


    public AppController(CarServices carServices, UserServices userServices, AddressServices addressServices) {
        this.carServices = carServices;
        this.userServices = userServices;
        this.addressServices=addressServices;
    }
    


    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping("/")
    public String mainPage(Model model)
    {
        MyUserDetails user=(MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cars",carServices.getAllHired());
        model.addAttribute("role", user.getRole());
        return "index";
    }

    @GetMapping("")
    public String toMain()
    {
        return "redirect:/";
    }

    // SETTINGS AND USERS


    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings(Model model)
    {
        model.addAttribute("users",userServices.getAll());
        return "settings";
    }

    @RequestMapping(value = "/settings/new", method = RequestMethod.GET)
    public String newUser(Model model)
    {
        if(model.getAttribute("user")==null)
        {
            model.addAttribute("user", new User());
        }
        if(model.getAttribute("address")==null)
        {
            model.addAttribute("address", new Address());
        }
        return "createUser";
    }

    @PostMapping("/settings/new")
    public String savenewUser(@ModelAttribute("user") User user,@ModelAttribute("address") Address address,Model model)
    {
        try {
            if(user.getPassword()==null||user.getPassword()==""){throw new Exception("Set password");}
            if(user.getRole()==null){throw new Exception("Set role");}
            if(Validation.ValEmail(user.getEmail())){}else{throw new ExceptionWrongEmail("Your email is incorrect");}
            if(Validation.ValTeleNumb(user.getTeleNumb())){}else{throw new ExceptionWrongTeleNumb("Your telephone number is incorrect.");}
            if(Validation.ValPostalCode(address.getPostalCode())){}else{throw new ExceptionWrongEmail("Postal code is incorrect");}
            
            // sprawdzanie czy adres jest juz zapisany
            if(address.getLocalNumb()=="")
            {address.setLocalNumb(null);}
            user.setAddress(addressServices.saveIfNotInDB(address));


            // encrypting password
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userServices.addUser(user);
            model.addAttribute("message", "User saved");
            return settings(model);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return newUser(model);
        }
        
    }

    @PostMapping("/settings/delete/{username}")
    public String deleteUser(@PathVariable("username") String username, Model model)
    {
        userServices.deleteUser(username);
        model.addAttribute("message", "Uzytkownik usunięty");
        return settings(model);
    }

}

