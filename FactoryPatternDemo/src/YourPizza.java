
public class YourPizza {
	public Pizza creatPizza(String pizza) {
		if(pizza.equalsIgnoreCase("cheese")) {
			return new CheesePizza();
		}else if(pizza.equalsIgnoreCase("Paparoni")) {
			return new PaparoniPizza();
		}else if(pizza.equalsIgnoreCase("vegetarian")) {
			return new VegetarianPizza();
		}else if(pizza.equalsIgnoreCase("build your own")) {
			return new buildUrOwn();
		}else {
			System.out.println("Invalid shape type: \"" + pizza+"\"");
			System.out.println("You will be given a chance to build your won Pizza");
			return new buildUrOwn();
		}
	}
}
