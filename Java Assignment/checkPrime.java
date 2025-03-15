import java.util.Scanner;

public class checkPrime {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a natural number:");
    int number = sc.nextInt();
    boolean flag = true;
    for(int i = 2 ; i <= number/2 ; i++){
      if(number%i == 0){
        System.out.println("Not a Prime Number");
        flag = false;
        break;
      }
    }
    if(number <= 1)System.out.println("Not a Prime Number"); //edge case 
    else if(flag)System.out.println("Prime Number");
  }
}
