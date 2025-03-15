// Defining an interface
interface Animal {
    void makeSound();  // Abstract method
}

// Implementing the interface
class Dog implements Animal {
    public void makeSound() {  // Must provide implementation
        System.out.println("Woof! Woof!");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();  // Output: Woof! Woof!

        Animal cat = new Cat();
        cat.makeSound();  // Output: Meow! Meow!
    }
}

