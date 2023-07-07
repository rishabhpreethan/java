# NOTES

## Week 3
### Philosophy of OO Programming
* Behaviour - what methods do we need to operate on objects
* State - how does the object react when methods are invoked?
    * State is the information in the instance variables
    * Encapsulation - should not change unless a method operates on it
* Identity - distinguish between different objects of the same class
    * State may be the same - two orders may contain the same item
* These features interact
    * State will typically affect behaviour
    * Cannot add an item to an order that has been shipped
    * Cannot ship an empty order
* Dependence
    * order needs account to check credit status
    * Item does not depend on account
    * Robust design minimises dependecies, or coupling between classes
* Aggregation
    * Order contains item objects
* Inheritance
    * One object is a specialised version of another
    * ExpressOrder inherits from Order
    * Extra methods to compute shipping charges, priority handling

### Subclasses and Inheritance
* An Employee class
```java
public class Employee{
    private String name;
    private double salary;

    // Some constructors

    // mutator methods
    public boolean setName(String s){..}
    public boolean setSalary(double x){..}

    // accessor methods
    public String getName(){..}
    public double getSalary(){..}

    // other methods
    public double bonus(float percent){
        return (percent/100.0)*salary;
    }
}
```

##### Subclasses
* Managers are special types of employees with extra features
* Manager is a subclass of employee
* Manager objects inherit other fields and methods from employee
> Manager objects do not automatically have access to private data of parent class
```java
public class Manager extends Employee{
    private String secretary;
    public boolean setSecretary(name s){..}
    public String getSecretary(){..}
}
```
<br>


## WEEK 4
### Abstract interfaces
* Forces subclasses to provide a concrete implementation
* Provide an abstract definition in shape<br>
```java 
public abstract double perimeter;
```
* Cannot create objects from a class that has abstract functions
* Shape must itseld be declared to be abstract
```java
public abstract class Shape{
    ...
    public abstract double perimeter();
    ...
}
```
* Can still declare variables whose type is an abstract class
```java
Shape arr[] = new Shape[3];
int arr = new int[3];
arr[0] = new Circle(...);
arr[1] = new Square(...);
arr[2] = new Rectangle(...);

for(i=0; i<2; i++){
    sizearr[i] = arr[i].perimeter();
        // dynamic dispatch
        // each arr[i] calls the appropriate method
    ...
}
```
* Use abstract classes to specify generic properties
```java
public abstract class Comparable{
    public abstract int cmp(Comparable s);
        // return -1 if this < s,
        //         0 if this ==0,
        //         1 if this > s
}
```
* Now we can sort any array of objects that extend <b><span style="color: red;">Comparable</span></b>
```java
public class SortFunctions{
    public static void quickSort(Comparable[] a){
        ...
        // Usual code for quicksort, except that
        // to compare a[i] and a[j] we use a[i].cmp(a[j])
    }
}
```
* To use this definition of quicksort, we write
```java
public class Myclass extends Comparable{
    private double size;        // quantity used for comparison

    public int cmp(Comparable s){
        if(s instanceof Myclass){
            // compare this.size and ((Myclass) s).size
            // Note that cast to access s.size
        }
    }
}
```

### Multiple Interfaces
* Java does not allow classes to extend multiple classes
* An interface is an abstract class with no concrete components
```java
pulblic inteface Comparable{
    public abstract int cmp(Comparable s);
}
```
* A class that extends an interface is said to implement it
```java
public class Circle extends Shape implements Comparable{
    public double perimeter(){...}
    public int cmp(Comparable s){...}
        ...
}
```
> Can extend only one class but can implement multiple interfaces