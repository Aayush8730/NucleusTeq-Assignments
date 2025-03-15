import java.util.*;

public class reverseString {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string :");
        String word  = sc.next(); // takes the first word
        String reverse = "";

        for(int i = word.length()-1; i>=0 ; i--){
          reverse += word.charAt(i);
        }
        System.out.println("Reversed String :" + reverse);
     }
}

// string in java are immutable unlike in cpp

