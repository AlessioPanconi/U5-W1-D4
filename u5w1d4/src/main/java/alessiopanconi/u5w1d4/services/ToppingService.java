package alessiopanconi.u5w1d4.services;

import alessiopanconi.u5w1d4.entities.Drink;
import alessiopanconi.u5w1d4.entities.Topping;
import alessiopanconi.u5w1d4.exceptions.NotFoundException;
import alessiopanconi.u5w1d4.exceptions.ValidationException;
import alessiopanconi.u5w1d4.repositories.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public void saveTopping(Topping newTopping)
    {
        if (toppingRepository.findByName(newTopping.getName()) != null) throw new ValidationException("Un topping con questo nome: " + newTopping.getName() + " esiste già");
        toppingRepository.save(newTopping);
        System.out.println("Il topping " + newTopping + " è stato salvato correttamente");
    }

    public Topping findById(long id)
    {
        return toppingRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findToppingByIdAndUpdate(long id, Topping updatedTopping)
    {
         Topping found= this.findById(id);

        found.setCalories(updatedTopping.getCalories());
        found.setName(updatedTopping.getName());
        found.setPrice(updatedTopping.getPrice());

        toppingRepository.save(found);
        System.out.println("Il topping con id: "+ id + " è stato modificato correttamente");
    }

    public void findToppingByIdAndDelete(long id)
    {
        Topping found= this.findById(id);
        toppingRepository.delete(found);
        System.out.println("Il Topping con id: "+ id + " è stato eliminato correttamente");
    }


}
