import java.util.Scanner;

public class checkAnagrams {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string 1:");
        String str1 = sc.next();
        System.out.println("Enter a string 2:");
        String str2 = sc.next();
        boolean check = true;
        int[] arr =  new int[26]; // array for mapping alphabets

         str1 = str1.toLowerCase();
         str2  = str2.toLowerCase();

        // check the lengths of the strings
        if(str1.length()!= str2.length()){
          System.out.println("Not anagrams");
        }
        else{
           for(int i = 0 ; i<str1.length() ;i++){
              arr[str1.charAt(i)- 'a']++;
           }
           for(int i = 0 ; i<str1.length() ;i++){
            arr[str2.charAt(i)- 'a']--;
           }
        }
        
        for(int i = 0 ; i<26 ; i++){
           if(arr[i]!=0)check = false;
        }

        if(check)System.out.println("Yes they are anagrams");
        else System.out.println("Not anagrams for sure");
  }
}
