import java.util.Scanner;

class Division {
public static void main(String[] args)
 {
  //create Scanner cls instance to wrap : stdin => System.in (InputStream)
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter 2 double nos");
   double d1=sc.nextDouble();
   double d2=sc.nextDouble();
   System.out.println("Div of "+d1+" "+d2+" = "+(d1/d2));
   //before terminating the app : close scanner
   sc.close();
   
  }
}