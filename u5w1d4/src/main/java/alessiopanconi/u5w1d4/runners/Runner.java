package alessiopanconi.u5w1d4.runners;

import alessiopanconi.u5w1d4.entities.Drink;
import alessiopanconi.u5w1d4.entities.Pizza;
import alessiopanconi.u5w1d4.entities.Topping;
import alessiopanconi.u5w1d4.services.DrinkService;
import alessiopanconi.u5w1d4.services.PizzaService;
import alessiopanconi.u5w1d4.services.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private ToppingService toppingService;

    @Autowired
    @Qualifier("lemonade")
    private Drink lemonade;

    @Autowired
    @Qualifier("water")
    private Drink water;

    @Autowired
    @Qualifier("wine")
    private Drink wine;

    @Autowired
    @Qualifier("toppings_tomato")
    private Topping tomato;

    @Autowired
    @Qualifier("toppings_cheese")
    private Topping cheese;

    @Autowired
    @Qualifier("toppings_ham")
    private Topping ham;

    @Autowired
    @Qualifier("toppings_pineapple")
    private Topping pineapple;

    @Autowired
    @Qualifier("toppings_salami")
    private Topping salami;

    @Autowired
    @Qualifier("pizza_margherita")
    private Pizza pizzaMargherita;

    @Autowired
    @Qualifier("hawaiian_pizza")
    private Pizza hawaiianPizza;

    @Autowired
    @Qualifier("salami_pizza")
    private Pizza salamiPizza;

    @Override
    public void run(String... args) throws Exception {

        drinkService.saveDrink(lemonade);
        drinkService.saveDrink(water);
        drinkService.saveDrink(wine);

        toppingService.saveTopping(tomato);
        toppingService.saveTopping(cheese);
        toppingService.saveTopping(ham);
        toppingService.saveTopping(pineapple);
        toppingService.saveTopping(salami);

        pizzaService.savePizza(pizzaMargherita);
        pizzaService.savePizza(salamiPizza);
        pizzaService.savePizza(hawaiianPizza);
    }
}
