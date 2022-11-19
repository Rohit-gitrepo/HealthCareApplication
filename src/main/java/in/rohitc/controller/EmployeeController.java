package in.rohitc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.rohitc.entity.Employee;
import in.rohitc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService; // Has-A relationship

	/**
	 * if end user regiter add in address bar this method is called and load
	 * EmployeeRegister.html page from template folder
	 * 
	 * @return
	 */
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}

	/**
	 * on form submit(/save+POST) read data as object using @ModelAttribute call
	 * service layer with object,read ID back and create create message as string
	 * use Model Memory to send MESSAGE to UI and Return back to
	 * EmployeeRegister.html
	 */
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {

		Integer id = employeeService.saveEmployee(employee);
		String message = "Employee" + id + "Created";
		model.addAttribute("message", message);
		return "EmployeeRegister";

	}

	/**
	 * feth data from DB using service send data to UI using Model Return
	 * EmployeeData.html
	 */
	@GetMapping("/all")
	public String viewAllEmployees(Model model) {
		List<Employee> list = employeeService.getAllEmployee();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	/**
	 * Read id from request url call service for delete get latest data,create
	 * sucess message send data to UI Using model Return back to employeeData.html
	 */

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, Model model) {
		// call service
		employeeService.deleteEmployee(id);
		// one success message
		String message = "Employee '" + id + "' Deleted";
		model.addAttribute("message", message);
		// get latest data
		List<Employee> list = employeeService.getAllEmployee();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	/**
	 * 
	 */
	@GetMapping("/edit")
	public String showEmployeeEdit(@RequestParam Integer id, Model model) {
		// load object from DB
		Employee employee = employeeService.getOneEmployee(id);
		// send object to UI
		model.addAttribute("employee", employee);
		// return to View page
		return "EmployeeEdit";
	}

	/**
	 * Read FORM data from Edit page
	 * Call service
	 * redirect to all
	 */
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:all";
	}
}
