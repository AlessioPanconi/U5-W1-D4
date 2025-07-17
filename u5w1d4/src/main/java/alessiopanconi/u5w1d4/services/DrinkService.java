package alessiopanconi.u5w1d4.services;

import alessiopanconi.u5w1d4.entities.Drink;
import alessiopanconi.u5w1d4.exceptions.NotFoundException;
import alessiopanconi.u5w1d4.exceptions.ValidationException;
import alessiopanconi.u5w1d4.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    public void saveDrink(Drink newDrink)
    {
        if (drinkRepository.findByName(newDrink.getName()) != null) throw new ValidationException("Un drink con questo nome: " + newDrink.getName() + " esiste già");
        drinkRepository.save(newDrink);
        System.out.println("Il drink " + newDrink + " è stato salvato correttamente");
    }

  public Drink findById(long id)
  {
      return drinkRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
  }

  public void findDrinkByIdAndUpdate(long id, Drink updatedDrink)
  {
      Drink found= this.findById(id);

      found.setCalories(updatedDrink.getCalories());
      found.setName(updatedDrink.getName());
      found.setPrice(updatedDrink.getPrice());

      drinkRepository.save(found);
      System.out.println("Il drink con id: "+ id + " è stato modificato correttamente");
  }

  public void findDrinkByIdAndDelete(long id)
  {
      Drink found= this.findById(id);
      drinkRepository.delete(found);
      System.out.println("Il drink con id: "+ id + " è stato eliminato correttamente");
  }

}
