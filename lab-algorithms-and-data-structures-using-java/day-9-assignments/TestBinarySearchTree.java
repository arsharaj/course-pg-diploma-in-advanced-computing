import java.util.Scanner;

public class TestBinarySearchTree {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int choice = 0;
			BinarySearchTree bst = new BinarySearchTree();
			do {
				try {
					System.out.println("--- Binary Search Tree Operations ---");
					System.out.println("1. Insert the data into the binary search tree.");
					System.out.println("2. Show the contents using inorder traversal.");
					System.out.println("3. Show the contents using preorder traversal.");
					System.out.println("4. Show the contents using postoder traversal.");
					System.out.println("0. Exit.");
					System.out.println("Enter your choice : ");
					choice = scan.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter the data : ");
						bst.insert(scan.nextInt());
						break;
					case 2:
						bst.displayInOrder();
						break;
					case 3:
						bst.displayPreOrder();
						break;
					case 4:
						bst.displayPostOrder();
						break;
					case 0:
						System.out.println("Thank you for using our services.");
						break;
					default:
						System.out.println("Enter a valid choice !");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 0);
		}
	}

}
