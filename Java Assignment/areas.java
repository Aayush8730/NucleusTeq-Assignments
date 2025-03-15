
import java.util.*;
public class areas {
  // create diff functions for area for triangle circle and rectangle
  public static double circleArea(double radius){
    return Math.PI*radius*radius;
  }
  public static double triangleArea(double base , double height){
    return 0.5*base*height;
  }
  public static double rectangleArea(double length , double breadth){
    return  length*breadth;
  }
  public static void main(String[] args) {
    Scanner scanner =  new Scanner(System.in);
    System.out.println("Choose a shape to calculate the area:");
    System.out.println("1. Circle");
    System.out.println("2. Rectangle");
    System.out.println("3. Triangle");
    
    System.out.print("Enter your choice (1/2/3): ");
    int choice = scanner.nextInt();
    switch (choice) {
        case 1:
            System.out.println("Enter the radius of the circle");
            double radius = scanner.nextDouble();
            System.out.println("The area of the circle is: " + circleArea(radius));
            break;
        case 2:
            System.out.print("Enter the length of the rectangle: ");
            double length = scanner.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = scanner.nextDouble();
            System.out.printf("The area of the rectangle is: " + rectangleArea(length, width));
            break;
        case 3:
            System.out.print("Enter the base of the triangle: ");
            double base = scanner.nextDouble();
            System.out.print("Enter the height of the triangle: ");
            double height = scanner.nextDouble();
            System.out.printf("The area of the triangle is: " + triangleArea(base, height));
            break;
        default:
           System.out.println("Enter the valid number");
    }
  }
}
