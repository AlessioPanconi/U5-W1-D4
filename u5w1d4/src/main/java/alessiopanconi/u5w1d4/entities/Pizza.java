package alessiopanconi.u5w1d4.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "pizza")
@NoArgsConstructor
@ToString
public class Pizza extends Item {

	private String name;

	@ManyToMany
	@JoinTable(
			name = "pizza_topping",
			joinColumns = @JoinColumn(name = "pizza_id"),
			inverseJoinColumns = @JoinColumn(name = "topping_id")
	)
	private List<Topping> toppingList;

	public Pizza(String name, List<Topping> toppingList) {
		super(1012, 4.3);
		this.name = name;
		this.toppingList = toppingList;
		this.calories = setCalories(toppingList);
		this.price = setPrice(toppingList);
	}

	public String getName() {
		return name;
	}
	public List<Topping> getToppingList() {
		return toppingList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setToppingList(List<Topping> toppingList) {
		this.toppingList = toppingList;
	}

	public int setCalories(List<Topping> toppingList) {
		int tot = 1012;
		if (toppingList != null) {
			for (int i = 0; i < toppingList.size(); i++) {
				tot += toppingList.get(i).getCalories();
			}
		}
		return tot;
	}

	public double setPrice(List<Topping> t) {
		double tot = 4.30;
		if (t != null) {
			for (int i = 0; i < t.size(); i++) {
				tot += t.get(i).getPrice();
			}
		}
		return tot;
	}

}
