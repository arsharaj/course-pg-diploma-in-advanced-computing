import java.util.Scanner;

class Compare {
public static void main(String[] args)
 {
  //create Scanner cls instance to wrap : stdin => System.in (InputStream)
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter 2 integers");
   int num1=sc.nextInt();
   int num2=sc.nextInt();
  if(num1 < num2)
	  System.out.println("1st no < 2nd no");
  else if (num1 > num2)
	  System.out.println("1st no > 2nd no");
  else
   System.out.println("1st no = 2nd no");
   //before terminating the app : close scanner
   sc.close();
   
  }
}