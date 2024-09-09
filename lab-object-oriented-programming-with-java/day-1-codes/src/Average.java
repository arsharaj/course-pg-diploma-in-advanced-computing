import java.util.Scanner;

class Average {
  public static void main(String args[]) {
    double firstNum = 0.0, secondNum = 0.0;
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter first number : ");
    if (scan.hasNextDouble()) {
      firstNum = scan.nextDouble();
    } else if (scan.hasNext()) {
      System.out.println("Enter a valid first number.");
    }
    
    scan.nextLine();
    
    System.out.print("Enter second number : ");
    if (scan.hasNextDouble()) {
      secondNum = scan.nextDouble();
    } else if (scan.hasNext()) {
      System.out.println("Enter a valid second number.");
    }
    
    double average = (firstNum + secondNum) / 2;
    System.out.println("Average : " + average);
    scan.close();
  }
}
