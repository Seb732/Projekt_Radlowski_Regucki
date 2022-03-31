package pl.agh.projektjava.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Entities.Car;
import pl.agh.projektjava.Repos.CarRepo;

@Service
public class CarServices {

    @Autowired
    private CarRepo carRepo;

    public CarServices()
    {}

    public Iterable<Car> getAll()
    {
        return carRepo.findAll();
    }
    
}
