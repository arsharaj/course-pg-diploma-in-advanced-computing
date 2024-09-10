import java.util.Scanner;

class PrintSeason {
public static void main(String[] args)
 {
  //create Scanner cls instance to wrap : stdin => System.in (InputStream)
   Scanner sc=new Scanner(System.in);
   //exit flag
   boolean exit=false;
  // System.out.println(exit);
   while(!exit) {
	   System.out.println("Enter month no : 1-12");
	   switch(sc.nextInt()) {
		    case 1:
			case 2 :
			case 11 : 
			case 12 :  System.out.println("Winter!!!");
			break;
			case 3 :
			case 4 :
			case 5 :
			case 6 : System.out.println("Summer!!!");
			break;
			case 7 :
			case 8 :
			case 9 :
			case 10 : System.out.println("Monsoon!!!");			
			break;
			default :
			exit=true;
			System.out.println("Invalid month , Terminating the app!!!!!");		
	   }
   }
  
  
   //before terminating the app : close scanner
   sc.close();
   
  }
}