import java.util.Scanner;

class OperationsTwoNumbers {
  static void generateMenu() {
    System.out.println("--- Operations ---");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");
    System.out.println("5. Exit");
  }

  public static void main(String args[]) {
   int firstNum, secondNum, choice;
   float result = 0.0f;
   Scanner scan = new Scanner(System.in);
   System.out.print("Enter first number : ");
   firstNum = scan.nextInt();
   System.out.print("Enter second number : ");
   secondNum = scan.nextInt();
   do {
    generateMenu();
    System.out.print("Enter your choice : ");
    choice = scan.nextInt();
    switch (choice) {
      case 1: result = firstNum + secondNum; break;
      case 2: result = firstNum - secondNum; break;
      case 3: result = firstNum * secondNum; break;
      case 4: result = (float) firstNum / secondNum; break;
      case 5: break;
      default: System.out.println("Enter a valid choice.");
    }
    System.out.println("Result : " + result);
   } while (choice != 5);
   scan.close();
  }
}
