package generics;

import java.util.ArrayList;

import com.app.core.Mgr;
import static utils.GenericUtils.*;

public class Test5 {

	public static void main(String[] args) {
		ArrayList<Mgr> mgrs=new ArrayList<>();
		mgrs.add(new Mgr(1000));
		mgrs.add(new Mgr(2000));
		mgrs.add(new Mgr(3000));
		System.out.println("sum ="+sumOfSalaries(mgrs));
		//Vector<SalesMgr> : Try it (Lab work)

	}

}
