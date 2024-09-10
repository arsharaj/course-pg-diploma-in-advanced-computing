package dao;

import java.sql.*;
import static utils.DBUtils.*;

public class BankAccountDaoImpl implements BankAccountDao {
	//state
	private Connection cn;
	private CallableStatement cst1;
	//def ctor
	public BankAccountDaoImpl() throws SQLException{
		// open cn
		cn=openConnection();
		cst1=cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		//register OUT param (to tell JVM about JDBC data types of OUT params)
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("acct dao created...");
	}
	@Override
	public String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		// set IN params
		cst1.setInt(1, srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		//execution : exec
		cst1.execute();
		return "Updated src bal : "+cst1.getDouble(4)+" dest bal "+cst1.getDouble(5);
	}
	public void cleanUp() throws SQLException
	{
		if(cst1 != null)
			cst1.close();
		closeConnection();
		System.out.println("acct dao cleaned up!");
	}

}
