

import java.util.Scanner;

public class patterns {

  public static void main(String[] args) {
    // create a square on side of length n 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the square:");

    int length = sc.nextInt();
    // square
    for(int row = 1 ;  row <= length ; row++){
      for(int col = 1 ; col <= length ; col++){
          if(row == 1 || row == length)System.out.print("* ");
          else if (row >=2 && row <= length-1 && (col == 1 || col == length)){
              System.out.print("* ");
          }
          else{
            System.out.print("  ");
          }
      }
      System.out.println("");
    }
  }
}
