package in.rohitc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rohitc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
