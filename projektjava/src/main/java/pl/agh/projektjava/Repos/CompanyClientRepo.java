package pl.agh.projektjava.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.agh.projektjava.Entities.CompanyClient;

@Repository
public interface CompanyClientRepo extends ClientRepo<CompanyClient>
{
    @Query("SELECT c FROM CompanyClient c WHERE c.NIP=:nip")
    public Optional<CompanyClient> getCompanyByNIP(@Param("nip") String nip);

    @Query("SELECT c FROM CompanyClient c WHERE c.REGON=:regon")
    public Optional<CompanyClient> getCompanyByREGON(@Param("regon") String regon);

    @Query("SELECT c FROM CompanyClient c WHERE c.name like %:name%")
    public Iterable<CompanyClient> getCompanyByName(@Param("name") String name);

    // QUERY SEARCH
    @Query("SELECT c FROM CompanyClient c WHERE c.NIP like %:query% OR c.name like %:query% OR c.REGON like %:query%")
    public Iterable<CompanyClient> getByQuery(@Param("query") String query);
}
