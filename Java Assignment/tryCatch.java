


public class tryCatch {
  public static void main(String[] args) {
      int[] numbers = {1, 2, 3};

      try {
          System.out.println(numbers[5]);  // Accessing an invalid index
      } 
      catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("Error: Index out of bounds!");
      }

      System.out.println("Program continues...");
  }
}
