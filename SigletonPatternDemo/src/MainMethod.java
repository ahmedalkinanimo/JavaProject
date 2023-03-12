/***
 * 
 * @author aaljanabi
 * The Singleton pattern is a design pattern used in software engineering to 
 * ensure that a class has only one instance, while providing a global point of 
 * access to this instance.
 * The purpose of this pattern is to control the instantiation of a class by 
 * allowing only one instance to be created, and to provide a way to access this 
 * instance globally. This is useful when there is a need to limit the number of 
 * instances of a class that can be created, or when it is necessary to have 
 * a single point of access to a resource.
 * Having multiple instances of these objects could lead to issues like 
 * conflicting or inconsistent. By limiting the number of instances to one, 
 * the Singleton pattern ensures that such issues do not arise.
 */
public class MainMethod {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
	  Manager M1=Manager.getInsteance("Adam","Game Design","Adam@GameLeft.com","816-777-8888","Y101",6666.99,6);
	  M1.addEmployee("Adam", "Game Tester");
	  M1.addEmployee("Ali", "Software Engineer");
	  M1.addEmployee("Lulu", "food provider");
	  M1.addProject("GOT", "2026");
	  M1.addProject("Dark Souls 4", "2030");
	  M1.addProject("Soul Revier", "2025");
	  System.out.println(M1);
	  M1.removeEmployee("Ali");
	  M1.removeProject("GOT");
	  System.out.println(M1);
	  
  }
}
