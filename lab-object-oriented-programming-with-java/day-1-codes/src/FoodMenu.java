import java.util.Scanner;

class FoodMenu {
  static void generateMenu() {
    System.out.println("--- Menu --- ");
    System.out.println("1. Idli     : Rs 10");
    System.out.println("2. Samosa   : Rs 20");
    System.out.println("3. Namkeen  : Rs 15");
    System.out.println("4. Biscuit  : Rs 5");
    System.out.println("5. Uttapa   : Rs 15");
    System.out.println("6. Paratha  : Rs 30");
    System.out.println("7. Chapati  : Rs 10");
    System.out.println("8. Naan     : Rs 15");
    System.out.println("9. Generate Bill");
    System.out.println("10. Exit");
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int choice;
    float price = 0.0f;
    do {
      generateMenu();
      System.out.println("Enter your choice : ");
      choice = scan.nextInt();
      switch (choice) {
        case 1: price += 10; break;
        case 2: price += 20; break;
        case 3: price += 15; break;
        case 4: price += 5; break;
        case 5: price += 15; break;
        case 6: price += 30; break;
        case 7: price += 10; break;
        case 8: price += 15; break;
        case 9: System.out.println("Total price : " + price); break;
        case 10: break;
        default: System.out.println("Enter a valid choice.");
      }
    } while(choice != 10);
    scan.close();
  }
}
