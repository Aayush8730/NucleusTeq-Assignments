


class MyThread extends Thread {
  public void run() {
    System.out.println("Thread running: " + Thread.currentThread().getName());
    }
  }


public class ThreadExample {
  public static void main(String[] args) {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();

    t1.start(); // Starts first thread
    t2.start(); // Starts second thread
}
}
