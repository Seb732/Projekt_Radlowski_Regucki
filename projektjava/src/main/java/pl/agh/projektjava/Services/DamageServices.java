package pl.agh.projektjava.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agh.projektjava.Entities.Damage;
import pl.agh.projektjava.Repos.DamageRepo;

@Service
public class DamageServices {

    @Autowired
    private DamageRepo repo;

    public DamageServices(DamageRepo repo) {
        this.repo = repo;
    }

    /**
     * Saves damage to DB
     * @param damage
     */
    public void saveDamage(Damage damage)
    {
        repo.save(damage);
    }

    /**
     * Deletes repo with given id
     * @param id
     */
    public void deleteDamage(Long id)
    {
        repo.deleteById(id);
    }

    

}
