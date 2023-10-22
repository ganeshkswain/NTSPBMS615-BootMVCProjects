package com.nt.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(Integer no);
	public String editEmployee(Employee emp);
	public String deleteEmployee(int no);
	public Page<Employee> getEmployeesPageData(Pageable pageable);
	public  Set<String> getAllCountries();
	public List<String> getStatesByCountries(String country);

}
