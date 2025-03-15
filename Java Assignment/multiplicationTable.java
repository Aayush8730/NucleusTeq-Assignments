import java.util.*;

public class multiplicationTable {
   public static void main(String[] args) {
       System.out.println("Enter the table number:"); // >=1
       Scanner sc  = new Scanner(System.in);
       int number = sc.nextInt();
       for(int i = 1 ; i<=10 ; i++){
          System.out.println( number + "*" + i + " = " +(number*i));
       }

   }
}
