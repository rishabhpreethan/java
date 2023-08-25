import java.util.*;
//Add your code for Class Point here
class Point<T extends Number>{
    private T x;
    private T y;
    
    public Point(T x, T y){
        this.x = x;
        this.y = y;
    }
    
    public T getX(){
        return x;
    }
    
    public T getY(){
        return y;
    }
    
    public Point<Double> mid(Point<? extends Number> other){
        double midX = (this.x.doubleValue() + other.x.doubleValue()) / 2.0;
        double midY = (this.y.doubleValue() + other.y.doubleValue()) / 2.0;
        return new Point<Double>(midX, midY);
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point<Integer> p1 = new Point<Integer>(sc.nextInt(), sc.nextInt());
        Point<Double> p2 = new Point<Double>(sc.nextDouble(), sc.nextDouble());
        Point<Double> p3 = p1.mid(p2);
        System.out.println(p3);        
    }
}