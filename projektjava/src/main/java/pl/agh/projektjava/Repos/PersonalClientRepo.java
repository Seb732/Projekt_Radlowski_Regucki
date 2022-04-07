package pl.agh.projektjava.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.PersonalClient;

@Repository
public interface PersonalClientRepo extends ClientRepo<PersonalClient>
{
    
    @Query("SELECT c FROM PersonalClient c WHERE c.pesel=:pesel")
    public Optional<PersonalClient> getByPesel(@Param("pesel") String pesel);
}
