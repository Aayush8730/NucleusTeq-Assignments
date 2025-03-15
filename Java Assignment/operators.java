public class operators{
   public static void main(String[] args) {
      //arithmatic operators
        int a = 10, b = 5;
        System.out.println("Addition: " + (a + b));  // 15
        System.out.println("Subtraction: " + (a - b));  // 5
        System.out.println("Multiplication: " + (a * b));  // 50
        System.out.println("Division: " + (a / b));  // 2
        System.out.println("Modulus: " + (a % b));  // 0
      //relational operators
        System.out.println(a == b);  // false
        System.out.println(a != b);  // true
        System.out.println(a > b);   // true
        System.out.println(a < b);   // false
        System.out.println(a >= b);  // true
        System.out.println(a <= b);  // false
      //logical operators
        boolean c = true, d = false;
        System.out.println(c && d);  // false
        System.out.println(c || d);  // true
        System.out.println(!c);      // false
   }
}
