package hr.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.beans.Department;

@Component
public class DepartmentDao {
	@Autowired
	DepartmentRepository departmentRepository;

	public DepartmentRepository getDepartmentRepository() {
		return departmentRepository;
	}

	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public List<Department> findDepartments() {
		return departmentRepository.findDepartments();
	}

	public Department findDepartmentById(int id) {
		return departmentRepository.findById(id);
	}
}
