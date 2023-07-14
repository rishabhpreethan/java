# NOTES


## WEEK 1
### Typing
* Every variable we use has a type
* Python determines the type based on the current value
    * Dynamic typing - names derive type from the current value
    ```python
    x = 10 - x  # x is of type int
    x = 7.5     # x is of type float
    ```
* Static typing - associate a type in advance with a name
    * Need to declare names and their types in advance value
    * ```int x, float a, ...```
    * Cannot assign an incompatible value ```x = 7.5``` is no longer legal


### Static Analysis
* Identify errors as early as possible - saves cost, effort
* Compilers cannot check that a program will work correctly
    * <b>Halting problem - Alan Turing</b>
* With variable declarations, compilers can detect type errors at compile time - static analysis
    * Dynamic typing would catch these errors only when the code runs
    * Executing code also slows down due to simultaneous monitoring for type correctness
* Compilers also perform optimizations based on static analysis
    * Reorder statements to optimize reads and writes
    * Store previously computed expressions to re-use later

### Scope of a variable
* When the variable is available for use
* In the following code, the x in f() is not in scope within call to g()
```python
def f(l):
    ...
    for x in l:
        y = y + g(x)
    ...


def g(m):
    ...
    for x in range(m):
        ...
```

* Lifetime of a variable
    * How long the storage remains allocated
    * Above lifetime of x in f() is till f() exits
    * "Hole in scope" - variable is alive but not in scope

### Memory Stack
* Create activation record when function is called
* Activation records are stacked
    * Popped when function exits
    * Control link points to start of previous record
    * Return value link tells where to store result
* Scope of a variable
    * Variable in activation record at top of stack
    * Access global variables by following control links

### Passing arguments to functions
##### Two ways to initialise parameters
* Call by value - copy the value
    * Updating the value inside the function has no side-effect
* Call by reference - parameter points to same location as argument
    * Can have side-effects
    * Can update the contents, but cannot change the reference itself


## WEEK 3
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