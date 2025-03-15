
import java.util.Scanner;

public class fibbonacci {
  public static void main(String[] args) {
    // fibonacci sequence upto nth number : for all n>=1
    System.out.println("Enter a position upto which you want fibbonaci sequence:");
    Scanner sc  = new Scanner(System.in);
    int position = sc.nextInt();

    int first  = 0 ;
    int second  = 1;
    int third; // sum of the prev two values
    
    System.out.print(first + " ");
    if(position!=1)System.err.print(second + " ");
    for(int i = 1 ; i <= position-2 ;i++){
        third = first + second;
        first = second;
        second = third;
        System.out.print(third + " ");
    }
  }
}
