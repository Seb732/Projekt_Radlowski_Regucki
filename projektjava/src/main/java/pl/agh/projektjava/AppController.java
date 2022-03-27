package pl.agh.projektjava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping("/")
    public String hello()
    {
        return "index";
    }
    
}
