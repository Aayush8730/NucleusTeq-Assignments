
import java.util.Scanner;

public class linearSearch {
  public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    System.out.println("Enter the length of array or total numbers :");
    int lengthOfArray = sc.nextInt();
    // array input
    int[] arr = new int[lengthOfArray];
    for(int i = 0 ; i<lengthOfArray;i++){
      arr[i] = sc.nextInt();
    }
    // target
    System.out.println("Enter the number you want to search");
    int target = sc.nextInt();
    boolean flag = false;// boolean variable to check it exits or not

    for(int i = 0 ; i<lengthOfArray ; i++){
      if(arr[i] == target){
        System.out.println("The number exists");
        flag = true;
      }
    }

    if(!flag)System.out.println("The number does not exist");

  }
}
