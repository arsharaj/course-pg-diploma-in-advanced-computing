package lists;

import java.util.ArrayList;

public class IntegerList {

	public static void main(String[] args) {
		// Create empty AL to hold Integer type refs
		ArrayList<Integer> intList=new ArrayList<>();//size =0, init capa=10
		System.out.println("Def contents of AL");
		for(int i : intList)
			System.out.println(i);
		int[] data= {10,1,34,-10,10,23,55,6,67,121,10,25};
		//populate AL with above data
		for(int i : data) //i=data[0] ,....no impl conversion !
			intList.add(i);//auto boxing
		System.out.println("AL contents via toString : "+intList);
		//can u use for loop ? YES
		System.out.println("AL contents via  for loop");
		for(int i=0;i<intList.size();i++)
			System.out.print(intList.get(i)+" ");
		System.out.println();
		//can u use for-each loop ? YES
		System.out.println("AL contents via  for-each loop");
		for(int i : intList)
			System.out.print(i+" ");
		//insert 999 at 0th index
		intList.add(0, 999);
		System.out.println("AL contents via toString : "+intList);
		//remove last elem
		System.out.println("removed "+intList.remove(intList.size()-1));
		System.out.println("AL contents via toString : "+intList);
		System.out.println("AL contains 10"+intList.contains(10));
		System.out.println(intList.indexOf(10)+" "+intList.lastIndexOf(10));
		//replace last elem by it's double
		System.out.println("Replaced "+intList.set(intList.size()-1, 
				(intList.get((intList.size()-1))*2)));
		System.out.println("AL "+intList);

	}

}
