// Create an abstract class StringOperations that has the following abstract methods:
//     String reverse(String s)
//     int vowelCount(String s)

// Create StringReverse class that extends StringOperations class but defines only String reverse(String s) method. It reverses the string which is passed as parameter and returns the reversed string.
// Create UpdatedStrings class that extends StringReverse class and defines int vowelCount(String s) method.  It counts the vowels in the string which is passed as parameter and returns the count.


import java.util.*;
abstract class StringOperations{
  public abstract String reverse(String s);
  public abstract int vowelCount(String s);
}
//Fill the code here
class StringReverse extends StringOperations{
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public int vowelCount(String s) {
        throw new UnsupportedOperationException();
  }
}

class UpdatedStrings extends StringReverse{
    public int vowelCount(String s){
        int c = 0;
        // String ls = s.toLowerCase();
        for(int i = 0; i < s.length(); i++){
            char j = s.charAt(i);
            if(j == 'a' || j == 'e' || j == 'i' || j == 'o' || j == 'u' || j == 'A' || j == 'E' || j == 'I' || j == 'O' || j == 'U'){
                c += 1;
            }
        }
        return c;
    }
}
class Example {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    UpdatedStrings str = new UpdatedStrings();
    System.out.println("Reverse of "+ s + " is "+ str.reverse(s));
    System.out.println("Vowel count of "+ s + " is "+ str.vowelCount(s));
  }
}