import java.util.Scanner;

public class countVowels {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string :");
        String str = sc.nextLine(); // takes entire line
        int lengthOfString = str.length();
        str = str.toLowerCase();
        int count = 0;
        for(int i = 0 ; i < lengthOfString ; i++){
          if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || 
              str.charAt(i) == 'i' || str.charAt(i) == 'o' || 
              str.charAt(i) == 'u') {
              count++;
              }
        }
        System.out.println("Vowel count :" + count);
   }
}
