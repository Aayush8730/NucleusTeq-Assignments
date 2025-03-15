import java.util.*;

public class tempratureConverter {
  
  public static double celciusToFahrenheit(double celcius){
      return celcius*((double)9/5) + 32;
  }

  public static double fahrenheitToCelcius(double fahrenheit){
       return (fahrenheit-32)*((double)5/9);
  }

  public static void main(String[] args) {
      Scanner sc  = new Scanner(System.in);

      System.out.println("Choose the temperature scale");
      System.out.println("Choose 1 the for celcius to farenheit");
      System.out.println("Choose 2 the for farenheit to celcius");

      int choice  = sc.nextInt();

      switch(choice){
        case 1:
            System.out.println("Enter the temperature in degree celcius");
            double temperatureInCelcius = sc.nextDouble();
            System.out.println("Temperature in Fahrenheit " + celciusToFahrenheit(temperatureInCelcius));
            break;
        case 2:
            System.out.println("Enter the temperature in degree Fahrenheit");
            double temperatureInFahrenheit = sc.nextDouble();
            System.out.println("Temperature in Fahrenheit " + fahrenheitToCelcius(temperatureInFahrenheit));
            break;
        default:
            System.out.println("Enter a valid choice among one and two");
            break;
      }
  }
}
