
public class Project {
    private String name;
    private String dueDate;
    
    public Project() {
        this.name = "";
        this.dueDate = "";
    }
    
    public Project(String name, String dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }
    
    // getters and setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
    
}
