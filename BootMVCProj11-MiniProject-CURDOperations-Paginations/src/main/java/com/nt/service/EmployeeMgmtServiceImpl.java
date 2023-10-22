package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empRepo")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		int idVal = empRepo.save(emp).getEmpno();
		return "Employee is saved with the id value:: " + idVal;
	}

	@Override
	public Employee getEmployeeByNo(Integer no) {
		Employee emp = empRepo.findById(no).get();
		return emp;
	}

	@Override
	public String editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		int idVal = empRepo.save(emp).getEmpno();
		return idVal + " Employee is Updated";
	}

	@Override
	public String deleteEmployee(int no) {
		empRepo.deleteById(no);
		return no + " emp no Employee is Deleted";
	}

	@Override
	public Page<Employee> getEmployeesPageData(Pageable pageable) {
		Page<Employee> page=empRepo.findAll(pageable);
		return page;
	}

}
