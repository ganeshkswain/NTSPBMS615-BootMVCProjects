package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empRepo")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;
	@Autowired
	private Environment env;

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
		Page<Employee> page = empRepo.findAll(pageable);
		return page;
	}

	@Override
	public Set<String> getAllCountries() {
		// get all locales of the world(Languages and countries)
		Locale locales[] = Locale.getAvailableLocales();
		Set<String> countrySet = new TreeSet<String>();
		for (Locale l : locales) {
			if (l != null)
				countrySet.add(l.getDisplayCountry());
		}

		return countrySet;
	}

	@Override
	public List<String> getStatesByCountries(String country) {
		// get States of a country through Environment object
		String statesInfo = env.getRequiredProperty(country);
		// convert comma Separated value in List collection using "," as delimiter
		List<String> statesList = Arrays.asList(statesInfo.split(","));
		// sort collections
		Collections.sort(statesList);
		return statesList;
	}

}
