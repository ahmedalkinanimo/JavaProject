
public class Investor implements Observer{
	private String name;
	private int shares;
	private double price;
	
	public Investor(String name,int shares,double price) {
		this.name=name;
		this.shares=shares;
		this.price=price;
	}
	public void update(double price) {
		this.price=price;
	}
	
  public String getName() {
  return name;}
  public void setName(String name) {
  this.name = name;}
  public int getShares() {
  return shares;}
  public void setShares(int shares) {
  this.shares = shares;}
  public double getPrice() {
  return price;}
  public void setPrice(double price) {
  this.price = price;}
  
  public String toString() {
		return "Investor name: "+name+"\n# of Shares: "+shares+"\nStock price: "+price;

  }
  
}
