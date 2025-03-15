
  // Defining an abstract class
abstract class Animal {
  abstract void makeSound();  // Abstract method

  void sleep() {  // Concrete method
      System.out.println("Sleeping...");
  }
}

// Concrete class inheriting abstract class
class Dog extends Animal {
  public void makeSound() {  // Must provide implementation
      System.out.println("Woof! Woof!");
  }
}

public class AbstractClassExample {
  public static void main(String[] args) {
      Dog dog = new Dog();
      dog.makeSound();  // Output: Woof! Woof!
      dog.sleep();  // Output: Sleeping...
  }
}


