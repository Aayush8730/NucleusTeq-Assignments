import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFile{

  public static void main(String[] args) {
      String fileName = "aayush.txt"; // Reading from "aayush.txt"

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read line by line
                System.out.println(line);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } 
        catch (IOException e) {
            System.out.println("Error reading the file.");
        }
  }
}

