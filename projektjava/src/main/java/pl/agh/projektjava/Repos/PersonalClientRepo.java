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

    @Query("SELECT c FROM PersonalClient c WHERE c.pesel like %:query% OR c.firstName like %:query% OR c.lastName like %:query% OR c.idCard like %:query%")
    public Iterable<PersonalClient> getByQuery(@Param("query") String query);

    @Query("SELECT id FROM PersonalClient")
    public Iterable<String> getPersonalClientsIds();
}
