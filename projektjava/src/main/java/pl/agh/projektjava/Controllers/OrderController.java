package pl.agh.projektjava.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.agh.projektjava.Services.RentOrderServices;

@Controller
public class OrderController {
    private RentOrderServices rentOrderServices;

    public OrderController(RentOrderServices rentOrderServices){
        this.rentOrderServices = rentOrderServices;
    }

    @GetMapping("/orders")
    public String orders(Model model){
        model.addAttribute("PersonalIds", rentOrderServices.getPersonalClientsIds());
        model.addAttribute("CompanyIds", rentOrderServices.getCompanyClientsIds());
        model.addAttribute("orders", rentOrderServices.getAllRentOrders());
        return "orders";
    }

}
