package pl.agh.projektjava.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.agh.projektjava.Entities.User;
import pl.agh.projektjava.Repos.UserRepo;

public class UserDetailsServicesImplement implements UserDetailsService
{
    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByEmail(String email)
    {
        User user=userRepo.getUserByEmail(email);
        if(user==null)
        {
            throw new UsernameNotFoundException("email not found");
        }
        return new MyUserDetails(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.getUserByUsernam(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("username not found");
        }
        return new MyUserDetails(user);
    }
}
