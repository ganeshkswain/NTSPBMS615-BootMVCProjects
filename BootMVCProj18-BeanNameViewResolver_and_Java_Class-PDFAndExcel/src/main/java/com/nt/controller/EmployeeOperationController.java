package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHome(){
		// return LVN
		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map, @RequestParam("type") String type) {
		// use service
		List<Employee> empsList = service.getAllEmployees();
		map.put("empsList", empsList);
		// return Lvn based on the hyper link that is clicked
		if (type.equalsIgnoreCase("excel"))
			return "excel_report";
		else
			return "pdf_report";
	}
}
