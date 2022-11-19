package in.rohitc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emptab")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private Integer id;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_sal")
	private String empSal;
	
	@Column(name = "emp_dept")
	private String empDept;
	
	@Column(name = "emp_add")
	private String empAdd;

}
