package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validations.EmployeeValidator;

@Controller
public class EmployeeMgmtController {
	@Autowired
	private IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showEmployeeReport(
			@PageableDefault(page = 0, size = 3, sort = "ename", direction = Direction.ASC) Pageable pagaeble,
			Map<String, Object> map) {
		System.out.println("EmployeeMgmtController.showEmployeeReport()");
		// use service
		Page<Employee> page = service.getEmployeesPageData(pagaeble);
		// put the result in model attributes
		map.put("empData", page);
		// return LVN
		return "employee_report";

	}

	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		emp.setJob("CLERK");
		return "employee_register";
	}

	@PostMapping("/add")
	public String addEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		System.out.println("EmployeeMgmtController.Employee()");
		if (emp.getVflag().equalsIgnoreCase("no")) {
			if (errors.hasFieldErrors())
				return "employee_register";

			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
			}
			if (errors.hasErrors())
				return "employee_register";

			if (emp.getJob().equalsIgnoreCase("hacker")) {
				errors.rejectValue("job", "job.reject");
				return "employee_register";
			}
		}

		// use service
		String result = service.registerEmployee(emp);

		// keep result in model attributes (Redirect Attributes)
		attrs.addFlashAttribute("resultData", result);

		// return LVN
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		// get employee details dynamically based on the given emp no
		Employee emp1 = service.getEmployeeByNo(no);
		// emp=emp1
		BeanUtils.copyProperties(emp1, emp);
		// return LVN
		return "employee_edit";

	}

	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs, BindingResult errors) {
		// checking for type Mismatch error
		if (emp.getVflag().equalsIgnoreCase("no")) {
			if (errors.hasFieldErrors())
				return "employee_edit";
			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
			}
			if (errors.hasErrors())
				return "employee_edit";
		}

		if (emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_edit";
		}
		// use service
		String msg = service.editEmployee(emp);
		// keep results as flash attributes in redirect scope
		attrs.addFlashAttribute("resultData", msg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, RedirectAttributes attrs) {
		String msg = service.deleteEmployee(no);
		attrs.addFlashAttribute("resultData", msg);
		return "redirect:report";
	}

	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries() {
		System.out.println("EmployeeMgmtController.populateCountries()");
		// use service
		Set<String> countrySet = service.getAllCountries();
		return countrySet;
	}
   
	@PostMapping("/statesurl")
	public String showStatesByCountry(@RequestParam("country") String country, @ModelAttribute("emp") Employee emp,
			Map<String, Object> map) {
		// use service
		List<String> statesList = service.getStatesByCountries(country);
		// put states list in Model Attribute
		map.put("statesInfo", statesList);
		return "employee_register";

	}
}
