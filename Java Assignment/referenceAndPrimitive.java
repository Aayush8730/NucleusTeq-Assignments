
import java.util.Arrays;

public class referenceAndPrimitive {
  public static void main(String[] args) {
      int a = 10;
      int b = a; // copy of a is assigned to b
      b = 30;
      System.out.println(a); //10 a remains the same
      System.out.println(b); //30

      int[] arr1 = {1, 2, 3}; // arr1 points to an array object in memory
      int[] arr2 = arr1; // arr2 now points to the SAME array object

      arr2[0] = 100; // Modifying arr2 modifies arr1 as well

      System.out.println("arr1: " + Arrays.toString(arr1)); // [100, 2, 3]
      System.out.println("arr2: " + Arrays.toString(arr2)); // [100, 2, 3]
  }
}


//primitive 
//The primitive type is the variable that stores the actual value in the memory
//memory efficient eg int a = 10; takes 32bits of memory
//faster
//changes does not affect the original 

//refernce
//The reference type is a variable that stores the reference object in memory again.
//not memory efficient eg Integer a = 10; takes 128bits of memory
//slower
//changes affect the original (in case of same object reference)
