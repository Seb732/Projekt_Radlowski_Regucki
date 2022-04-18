package pl.agh.projektjava.Controllers;

import java.time.LocalDate;

import org.hibernate.event.spi.LockEventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.agh.projektjava.Entities.Car;
import pl.agh.projektjava.Entities.RentOrder;
import pl.agh.projektjava.Services.CarServices;
import pl.agh.projektjava.Services.ClientServices;
import pl.agh.projektjava.Services.RentOrderServices;

@Controller
public class OrderController {
    private RentOrderServices rentOrderServices;
    private CarServices carServices;
    private ClientServices clientServices;

    public OrderController(RentOrderServices rentOrderServices, CarServices carServices, ClientServices clientServices){
        this.rentOrderServices = rentOrderServices;
        this.carServices=carServices;
        this.clientServices=clientServices;
    }

    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public String orders(Model model){
        model.addAttribute("PersonalIds", rentOrderServices.getPersonalClientsIds());
        model.addAttribute("CompanyIds", rentOrderServices.getCompanyClientsIds());
        model.addAttribute("orders", rentOrderServices.getAllRentOrders());
        return "orders";
    }

    @RequestMapping(value = "/orders/new",method = RequestMethod.GET)
    public String newOrder(Model model)
    {   
        model.addAttribute("rentOrder", new RentOrder());
        model.addAttribute("cars", carServices.getAllAvailable());
        model.addAttribute("PersonalClients", clientServices.getAllPersonalClients());
        model.addAttribute("CompanyClients", clientServices.getAllCompanyClients());
        
        return "createOrder";
    }

    @PostMapping("/orders/new")
    public String saveNewOrder(@ModelAttribute("rentOrder") RentOrder rentOrder,Model model)
    {
        try {
            rentOrder.setCar(carServices.getCarByVin(rentOrder.getCar().getVIN()).get());
            rentOrder.setClient(clientServices.getById(rentOrder.getClient().getId()).get());
            rentOrder.getCar().setStatus(Car.Status.hired);
            rentOrder.setRentStartDate(LocalDate.now());
            rentOrder.setStatus(RentOrder.OrderStatus.active);
            rentOrderServices.saveOrder(rentOrder);
            model.addAttribute("message","Rent order saved");
            return orders(model);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return newOrder(model);
        }
    }

}
