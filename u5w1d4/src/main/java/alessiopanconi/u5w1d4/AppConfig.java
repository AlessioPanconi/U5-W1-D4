package alessiopanconi.u5w1d4;

import alessiopanconi.u5w1d4.entities.Drink;
import alessiopanconi.u5w1d4.entities.Pizza;
import alessiopanconi.u5w1d4.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@PropertySource("application.properties")
@Configuration
public class AppConfig {
	@Bean(name = "toppings_tomato")
	public Topping toppingTomatoBean() {
		return new Topping("Tomato", 0, 0);
	}

	@Bean(name = "toppings_cheese")
	public Topping toppingCheeseBean() {
		return new Topping("Cheese", 92, 0.69);
	}

	@Bean(name = "toppings_ham")
	public Topping toppingHamBean() {
		return new Topping("Ham", 35, 0.99);
	}

	@Bean(name = "toppings_pineapple")
	public Topping toppingPineappleBean() {
		return new Topping("Pineapple", 24, 0.79);
	}

	@Bean(name = "toppings_salami")
	public Topping toppingSalamiBean() {
		return new Topping("Salami", 86, 0.99);
	}


	@Bean(name = "pizza_margherita")
	public Pizza pizzaMargheritaBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		return new Pizza("Pizza Margherita", tList);
	}

	@Bean(name = "hawaiian_pizza")
	public Pizza pizzaHawaiianBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingHamBean());
		tList.add(toppingPineappleBean());
		return new Pizza("Hawaiian Pizza", tList);
	}

	@Bean(name = "salami_pizza")
	public Pizza pizzaSalamiBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingSalamiBean());
		return new Pizza("Salami Pizza", tList);
	}

	@Bean(name = "salami_pizza_xl")
	public Pizza pizzaSalamiXlBean() {
		List<Topping> tList = new ArrayList<>();
		tList.add(toppingTomatoBean());
		tList.add(toppingCheeseBean());
		tList.add(toppingSalamiBean());
		return new Pizza("Salami Pizza XL", tList);
	}

	@Bean(name = "lemonade")
	public Drink lemonadeBean() {
		return new Drink("Lemonade", 128, 1.29);
	}

	@Bean(name = "water")
	public Drink waterBean() {
		return new Drink("Water", 0, 1.29);
	}

	@Bean(name = "wine")
	public Drink wineBean() {
		return new Drink("Wine", 607, 7.49);
	}


	//MENU
	@Bean(name = "pizzaList")
	public List<Pizza> pizzaList() {
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(pizzaMargheritaBean());
		pizzaList.add(pizzaHawaiianBean());
		pizzaList.add(pizzaSalamiBean());
		pizzaList.add(pizzaSalamiXlBean());

		return pizzaList;
	}

	@Bean(name = "drinkList")
	public List<Drink> drinkList() {
		List<Drink> drinkList = new ArrayList<>();
		drinkList.add(lemonadeBean());
		drinkList.add(waterBean());
		drinkList.add(wineBean());

		return drinkList;
	}

	@Bean(name = "toppingsList")
	public List<Topping> toppingsList() {
		List<Topping> toppingsList = new ArrayList<>();
		toppingsList.add(toppingTomatoBean());
		toppingsList.add(toppingCheeseBean());
		toppingsList.add(toppingSalamiBean());
		toppingsList.add(toppingHamBean());
		toppingsList.add(toppingPineappleBean());

		return toppingsList;
	}

//	//TAVOLI
//	@Bean(name = "tavolo1")
//	public Tavolo tavolo1(){
//		return new Tavolo(1,2,Stato.LIBERO);
//	}
//	@Bean(name = "tavolo2")
//	public Tavolo tavolo2(){
//		return new Tavolo(2,4, Stato.LIBERO);
//	}
//	@Bean(name = "tavolo3")
//	public Tavolo tavolo3(){
//		return new Tavolo(3,2, Stato.LIBERO);
//	}
//	@Bean(name = "tavolo4")
//	public Tavolo tavolo4(){
//		return new Tavolo(4,6, Stato.LIBERO);
//	}
//
//	//Liste
//	@Bean(name = "listPizzeOrdine1")
//	public List<Pizza> listPizzeOrdine1(){
//		List<Pizza> listPizzeOrdine1 = new ArrayList<>();
//
//		listPizzeOrdine1.add(pizzaHawaiianBean());
//		listPizzeOrdine1.add(pizzaMargheritaBean());
//		listPizzeOrdine1.add(pizzaMargheritaBean());
//
//		return listPizzeOrdine1;
//	}
//
//	@Bean(name = "listDrinkOrdine1")
//	public List<Drink> listDrinkOrdine1(){
//		List<Drink> listDrinkOrdine1 = new ArrayList<>();
//		listDrinkOrdine1.add(waterBean());
//		listDrinkOrdine1.add(wineBean());
//		listDrinkOrdine1.add(waterBean());
//
//		return listDrinkOrdine1;
//	}
//
//	@Bean(name = "costoOrdine")
//	public double costoOrdine(@Value("${costo.coperto}") double coperto) {
//		double tot = listPizzeOrdine1().stream().mapToDouble(Item::getPrice).sum() +
//				listDrinkOrdine1().stream().mapToDouble(Item::getPrice).sum() +
//				(coperto * tavolo1().getNumeroCoperti());
//		return tot;
//	}
}
