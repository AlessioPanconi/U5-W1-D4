package alessiopanconi.u5w1d4.repositories;

import alessiopanconi.u5w1d4.entities.Pizza;
import alessiopanconi.u5w1d4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping,Long> {

    Topping findByName(String name);

    List<Topping> findByNameIn(List<String> toppingNames);
}

