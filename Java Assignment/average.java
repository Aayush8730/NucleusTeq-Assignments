
import java.util.*;
public class average {
  public static void main(String[] args) {
    //input array of numbers 
    Scanner sc  = new Scanner(System.in);
    System.out.println("Enter the length of array or total numbers :");
    int lengthOfArray = sc.nextInt();

    //taking the numbers as an input and also calculating the sum

    int[] arr = new int[lengthOfArray];
    int sum  = 0 ;
    for(int i = 0 ; i<lengthOfArray;i++){
      arr[i] = sc.nextInt();
      sum  =  sum + arr[i];
    }

    //average  = sum/lengthOfArray
     double average = (double) sum / lengthOfArray;
     System.out.println("The Average is : " + average);
  }
}

