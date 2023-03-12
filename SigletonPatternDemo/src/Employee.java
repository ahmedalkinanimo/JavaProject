public class Employee {
    private String name;
    private String title;
    
    public Employee() {
        this.name = "";
        this.title = "";
    }
    
    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }
    
    // getters and setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
	
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
