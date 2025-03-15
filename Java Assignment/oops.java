
class Student {
  // created the attributes
  private String name;
  private int rollNumber;
  private int marks;

  // a public constructor to be accessed outside
  public Student(String name, int rollNumber, int marks) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.marks = marks;
  }

  // encapsulation : getter methods
  public String getName() {
    return name;
  }

  public int getRollNumber() {
    return rollNumber;
  }

  public int getMarks() {
    return marks;
  }

  // display performance
  public void displayPerformance() {
    if (marks >= 80)
      System.out.println("Good Performance");
    else if (marks >= 60 && marks < 80)
      System.out.println("Okayish Performance");
    else
      System.out.println("Poor Performance ... needs improvement");
  }
}

class GraduateStudent extends Student {
  private String researchTopic;

  // Constructor (Calling parent constructor using super)
  public GraduateStudent(String name, int rollNumber, int marks, String researchTopic) {
    super(name, rollNumber, marks);
    this.researchTopic = researchTopic;
  }

  // polymorphism same method name but with diff arguments

  public void displayPerformance() {
    super.displayPerformance(); // calling the parent function
  }

  public void displayPerformance(boolean includeTopic) {
    super.displayPerformance();
    if (includeTopic) {
      System.out.println("Research Topic: " + researchTopic);
    }
  }

}

// main class
public class oops {

  // create a object of the class

  public static void main(String[] args) {

    // created an instance of student class
    Student s1 = new Student("aayush", 1, 67);
    System.out.println("Student Performance :");
    s1.displayPerformance();
    System.out.println();

    // created an instance of graduate student
    GraduateStudent gs1 = new GraduateStudent("Bob", 201,
     92, "Machine Learning");
    System.out.println("Graduate Student Details:");
    gs1.displayPerformance(); // Calls overridden method in child class
    gs1.displayPerformance(true);
  }
}
