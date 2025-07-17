package alessiopanconi.u5w1d4.services;

import alessiopanconi.u5w1d4.entities.Drink;
import alessiopanconi.u5w1d4.entities.Pizza;
import alessiopanconi.u5w1d4.exceptions.NotFoundException;
import alessiopanconi.u5w1d4.exceptions.ValidationException;
import alessiopanconi.u5w1d4.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void savePizza(Pizza newPizza)
    {
        if (pizzaRepository.findByName(newPizza.getName()) != null) throw new ValidationException("Una pizza con questo nome: " + newPizza.getName() + " esiste già");
        pizzaRepository.save(newPizza);
        System.out.println("La pizza " + newPizza + " è stato salvato correttamente");
    }

    public Pizza findById(long id)
    {
        return pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findPizzaByIdAndUpdate(long id, Pizza updatedPizza)
    {
        Pizza found= this.findById(id);

        found.setCalories(updatedPizza.getCalories());
        found.setName(updatedPizza.getName());
        found.setPrice(updatedPizza.getPrice());
        found.setToppingList(updatedPizza.getToppingList());

        pizzaRepository.save(found);
        System.out.println("La pizza con id: "+ id + " è stata modificata correttamente");
    }

    public void findPizzaByIdAndDelete(long id)
    {
        Pizza found= this.findById(id);
        pizzaRepository.delete(found);
        System.out.println("La pizza con id: "+ id + " è stata eliminata correttamente");
    }
}
