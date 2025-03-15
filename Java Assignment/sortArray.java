import java.util.Scanner;

public class sortArray {
  public static void main(String[] args) {
    //sorting array using bubble sort

    Scanner sc  = new Scanner(System.in);
    System.out.println("Enter the length of array or total numbers :");
    int lengthOfArray = sc.nextInt();
    // array input
    int[] arr = new int[lengthOfArray];
    for(int i = 0 ; i<lengthOfArray;i++){
      arr[i] = sc.nextInt();
    }

    for(int i  = 0 ; i < lengthOfArray ;i++){
      boolean swapped  = false;
      for(int j = 1 ; j < lengthOfArray-i ;j++){
           if(arr[j-1]>arr[j]){
              int temp =  arr[j];
              arr[j] = arr[j-1];
              arr[j-1] = temp;
              swapped = true;
           }
      }
      if(!swapped)break; // not even once that means already sorted
    }

    for(int i = 0 ; i<lengthOfArray ;i++)System.out.print(arr[i] + " ");
  }
}
