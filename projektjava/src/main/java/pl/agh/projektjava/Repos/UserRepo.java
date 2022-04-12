package pl.agh.projektjava.Repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.User;

@Repository
public interface UserRepo extends CrudRepository<User,String>
{
    /**
     * Returns users with given email
     * @param email
     * @return
     */
    @Query("SELECT usr FROM User usr WHERE usr.email=:email")
    public User getUserByEmail(@Param("email") String email);

    // @Query("SELECT usr FROM User usr WHERE usr.username=:username")
    // public User getUserByUsernam(@Param("username") String username);

    // @Query("DELETE  FROM User WHERE username=:username")
    // public void deleteByUsername(@Param("username") String username);
}
