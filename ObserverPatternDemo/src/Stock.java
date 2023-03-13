import java.util.ArrayList;

public class Stock {
	private String ticker;
	private String name;
	private double price;
	private ArrayList<Observer> observers=new ArrayList<>();
	
	public Stock() {
		ticker="";
		name="";
		price=0.0;
	}
	
	public Stock(String name,String ticker, double price) {
		this.ticker=ticker;
		this.name=name;
		this.price=price;
	}
	
	public String getTicker() {
	  return ticker;}
	
	public void setTicker(String ticker) {
	  this.ticker = ticker;
	}
	public String getName() {
	  return name;
	}  
	public void setName(String name) {
	  this.name = name;}
	public double getPrice() {
	  return price;
	}
	public void setPrice(double price) {
	  this.price = price;
	}
	public ArrayList<Observer> getObservers() {
	  return observers;
	}
	public void setObservers(ArrayList<Observer> observers) {
	  this.observers = observers;
	}
	public void priceUpdate(double price) {
		this.price=price;
		this.notifyObservers();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(price);
		}
	}
	
	public String toString() {
		return "Stocke name: "+name+"\nStock ticker: "+ticker+"\nStock price: "+price;
	}
}
