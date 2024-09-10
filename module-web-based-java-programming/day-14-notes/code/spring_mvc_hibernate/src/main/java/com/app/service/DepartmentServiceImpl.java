package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;
@Service
@Transactional//to enable auto tx management support
public class DepartmentServiceImpl implements DeparmentService {
	//depcy
	@Autowired	
	private DepartmentDao deptDao;
	@Override
	public List<Department> listAllDepartments() {
		// TODO Auto-generated method stub
		return deptDao.getAllDepartments();
	}

}
