package in.rohitc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rohitc.entity.Employee;
import in.rohitc.repository.EmployeeRepository;
import in.rohitc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Integer saveEmployee(Employee employee) {
		employee = employeeRepo.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeRepo.findAll();
		return list;
	}

	// shorcut key ctrl+space
	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);

	}

	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = employeeRepo.findById(id);
		if (opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}
		// TODO : else throw exception Employee not found
		return null;
	}
	
	public void updateEmployee(Employee e) {
		employeeRepo.save(e);
		}

}
