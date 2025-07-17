package alessiopanconi.u5w1d4.repositories;

import alessiopanconi.u5w1d4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long> {

    Drink findByName(String name);

}
