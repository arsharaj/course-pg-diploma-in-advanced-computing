package com.app.dao;

import com.app.pojos.Address;

public interface AddressDao {
//add a method to link adr to emp
	String assignEmpAddress(Long empId,Address adr);
}
