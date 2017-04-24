package hr.flows.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.beans.Department;
import hr.beans.Employee;
import hr.beans.Request;
import hr.data.DepartmentDao;
import hr.data.EmployeeDao;

@Component
public class HrFlowActions {
	static List<Request> requests;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	EmployeeDao employeeDao;

	public HrFlowActions() {
		requests = new ArrayList<Request>();
	}

	public void addRequest(Request request) {
		requests.add(request);
	}

	public List<Employee> findEmployees() {
		return employeeDao.findEmployees();
	}

	public List<Department> findDepartments() {
		return departmentDao.findDepartments();
	}

	public Employee findEmployeeById(int id) {
		return employeeDao.findEmployeeById(id);
	}

	public Department findDepartmentById(int id) {
		return departmentDao.findDepartmentById(id);
	}

}
