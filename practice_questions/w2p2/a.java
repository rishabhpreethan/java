import java.util.*;
class Employee{
    String name;
    String[] projects;
//***** Define constructor(s) here
    public Employee(String name, String[] projects){
        this.name = name;
        this.projects = Arrays.copyOf(projects, projects.length);
    }
    
    public Employee(Employee other){
        this.name = name;
        this.projects = Arrays.copyOf(other.projects, other.projects.length);
    }
    public void setName(String n) {
        name = n;
    }
    public void setProject(int index, String proj) {
        projects[index] = proj;
    }
    public String getName() {
        return name;
    }
    public String getProject(int indx) {
        return projects[indx];
    }
}
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] proj =  {"PJ1", "PJ2", "PJ3"};
        Employee e1 = new Employee("Surya", proj);
        Employee e2 = new Employee(e1);
        e2.setName(sc.next());
        e2.setProject(0, sc.next());
        System.out.println(e1.getName() + ": " + e1.getProject(0));
        System.out.println(e2.getName() + ": " + e2.getProject(0));
    }
}