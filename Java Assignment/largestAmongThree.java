
import java.util.Scanner;

public class largestAmongThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter three numbers (Integers):");
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter c: ");
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("All three numbers are equal: " + a);
        } else if (a >= b && a >= c) {
            if (a == b) System.out.println("The largest numbers are a and b: " + a);
            else if (a == c) System.out.println("The largest numbers are a and c: " + a);
            else System.out.println("The largest number is a: " + a);
        } else if (b >= c) {
            if (b == c) System.out.println("The largest numbers are b and c: " + b);
            else System.out.println("The largest number is b: " + b);
        } else {
            System.out.println("The largest number is c: " + c);
        }

        sc.close();
    }
}
