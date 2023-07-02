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