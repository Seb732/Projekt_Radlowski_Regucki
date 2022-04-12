package pl.agh.projektjava.Controllers;


import java.lang.ProcessBuilder.Redirect;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Entities.User;
import pl.agh.projektjava.Security.MyUserDetails;
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
        MyUserDetails user=(MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("cars",carServices.getAllHired());
        model.addAttribute("role", user.getRole());
        return "index";
    }

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
        return "createUser";
    }

    @PostMapping("/settings/new")
    public String savenewUser(@ModelAttribute("user") User user,Model model)
    {
        try {
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userServices.addUser(user);
            model.addAttribute("message", "User saved");
            return settings(model);
        } catch (Exception e) {
            model.addAttribute("error", "Error - user not save");
            return newUser(model);
        }
        
    }

}

