
import src.tester.Point2DMain;
import java.util.Scanner;

public class Testpoints {
    public static void main(String[] args){
           System.out.println("enter no of points to plot: ");
           int num1;
           Scanner sc=new Scanner(System.in);
           num1=sc.nextInt();
           Point2D[] parr=new Point2D[num1];
           for (int i=0;i<num1;i++){
               parr[i]=new Point2D(sc.nextFloat(),sc.nextFloat());
               if (parr[i]==parr[num1-i-1])
               System.out.println("already");
               else{
                   System.out.println(" ");
               }
           }


           for (Point2D point2d : parr) {
            System.out.println(point2d.show());
           }
           sc.close();
        }
}
