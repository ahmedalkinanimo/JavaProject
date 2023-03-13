
public class MainClass {
	
	public static void main(String arg[]) {
		Stock S1=new Stock("Apple","APP", 267.89);
		Investor investor1=new Investor("Adam",100,S1.getPrice());
		Investor investor2=new Investor("Ali",200,S1.getPrice());
		S1.addObserver(investor1);
		S1.addObserver(investor2);
		System.out.println(S1);
		System.out.println("--------------------------------");
		System.out.println(investor1);
		System.out.println("--------------------------------");
		System.out.println(investor2);
		System.out.println("--------------------------------");
		S1.priceUpdate(300.99);
		System.out.println(S1);
		System.out.println("--------------------------------");
		System.out.println(investor1);
		System.out.println("--------------------------------");
		System.out.println(investor2);
		System.out.println("--------------------------------");
	}
	
}
