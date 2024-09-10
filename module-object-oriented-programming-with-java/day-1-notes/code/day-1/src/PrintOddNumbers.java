import java.util.Scanner;

class PrintOddNumbers {
public static void main(String[] args)
 {
  //create Scanner cls instance to wrap : stdin => System.in (InputStream)
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter 2 integers");
   int begin=sc.nextInt();
   int end=sc.nextInt();
   for(int i=begin;i<=end;i++) {
	   if(i % 2 !=0)
		   System.out.println("Next odd no "+i);
   }
  
   //before terminating the app : close scanner
   sc.close();
   
  }
}