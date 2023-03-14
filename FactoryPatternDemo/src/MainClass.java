
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza P1=new YourPizza().creatPizza("vegetarian");
		P1.makePizza();
		Pizza P2=new YourPizza().creatPizza("build your own");
		P2.makePizza();
		Pizza P3=new YourPizza().creatPizza("cheese");
		P3.makePizza();
		Pizza P4=new YourPizza().creatPizza("Paparoni");
		P4.makePizza();
		Pizza P5=new YourPizza().creatPizza("Test");
		P5.makePizza();
	}

}
