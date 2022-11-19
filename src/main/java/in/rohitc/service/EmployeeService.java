package in.rohitc.service;

import java.util.List;

import in.rohitc.entity.Employee;

public interface EmployeeService {
	
	Integer saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	void deleteEmployee(Integer id);
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee e);

}
