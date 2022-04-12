package pl.agh.projektjava.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Entities.User;
import pl.agh.projektjava.Repos.UserRepo;

@Service
public class UserServices {

    @Autowired
    private UserRepo repo;

    public UserServices(UserRepo repo) {
        this.repo = repo;
    }

    public Iterable<User> getAll()
    {
        return repo.findAll();
    }

    public void deleteUser(String username)
    {
        repo.deleteById(username);
    }

    public void addUser(User user)
    {
        repo.save(user);
    }

    
}
