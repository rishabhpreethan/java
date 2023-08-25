import java.util.*;
//Add your code for Class Student here
class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double[] getMarks() {
        return marks;
    }

    public double findTotal() {
        int total = 0;
        for (double m : marks) {
            total += m;
        }
        return total;
    }
    
    @Override
    public String toString(){
        return name;
    }
}

public class Test{
    // Define the method getMax() here
    public static Student getMax(Student[] arr){
        Student maxStudent = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i].findTotal() > maxStudent.findTotal()){
                maxStudent = arr[i];
            }
        }
        return maxStudent;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] arr = new Student[3];   
        for(int i = 0; i < 3; i++){
            String name = sc.next();
            double[] m = {sc.nextDouble(), sc.nextDouble(), sc.nextDouble()};
            arr[i] = new Student(name, m);
        }
        System.out.println(getMax(arr));  
    }
}