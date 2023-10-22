package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeMgmtController {
	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		System.out.println("EmployeeMgmtController.showEmployeeReport()");
		List<Employee> list = service.getAllEmployees();
		map.put("empData", list);
		return "employee_report";
	}

	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		emp.setJob("CLERK");
		return "employee_register";
	}
	//Basic Solution with PRG pattern

	/*	@PostMapping("/add")
		public String addEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
			System.out.println("EmployeeMgmtController.addEmployee()");
			// use service
			String result = service.registerEmployee(emp);
			map.put("resultData", result);
			return "redirect:report";
		}*/
	
	//Improved Solution1 PRG pattern with Redirect Scope flash attributes
	
	/*	@PostMapping("/add")
		public String addEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
			System.out.println("EmployeeMgmtController.Employee()");
			//use service
			String result=service.registerEmployee(emp);
			//keep result in model attributes (Redirect Attributes)
			attrs.addFlashAttribute("resultData",result);
			//return LVN
			return "redirect:report";
		}*/
	
	//Improved Solution2 PRG Pattern with redirect scope Flash attributes
	@PostMapping("/add")
	public String addEmployee(HttpSession ses,@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeMgmtController.addEmployee()");
		//use service
		String result=service.registerEmployee(emp);
		//keep result in session Attributes
		ses.setAttribute("resultData",result);
		//return LVN
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
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		// use service
		String msg = service.editEmployee(emp);
		//keep results as flashattributes inredirect scope
		attrs.addFlashAttribute("resultData", msg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,RedirectAttributes attrs) {
		String msg = service.deleteEmployee(no);
		attrs.addFlashAttribute("resultData", msg);
		return "redirect:report";

	}
}
