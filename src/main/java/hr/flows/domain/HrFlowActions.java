package hr.flows.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import hr.beans.Department;
import hr.beans.Employee;
import hr.beans.Request;
import hr.service.DepartmentManger;
import hr.service.EmployeeManger;

@Component
public class HrFlowActions {
	static List<Request> requests;
	@Autowired
	DepartmentManger departmentManger;
	@Autowired
	EmployeeManger employeeManger;
	@Autowired
	JavaMailSender mailSender;

	public HrFlowActions() {
		requests = new ArrayList<Request>();
	}

	public void addRequest(Request request) {
		requests.add(request);
	}

	public List<Employee> findEmployees() {
		return employeeManger.findEmployees();
	}

	public List<Department> findDepartments() {
		return departmentManger.findDepartments();
	}

	public Employee findEmployeeById(int id) {
		return employeeManger.findEmployeeById(id);
	}

	public Department findDepartmentById(int id) {
		return departmentManger.findDepartmentById(id);
	}

	public void sendRequestAsEmail(Request request) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(request.getSender().getEmail());
		message.setTo(request.getReceiverDepartment().getDepartmentEmail());
		if (request.getNotifiedEmployee() != null) {
			message.setCc(request.getNotifiedEmployee().getEmail());
		}
		message.setSubject(request.getSubject());
		message.setText(request.getBody());
		mailSender.send(message);
	}

	public DepartmentManger getDepartmentManger() {
		return departmentManger;
	}

	public void setDepartmentManger(DepartmentManger departmentManger) {
		this.departmentManger = departmentManger;
	}

	public EmployeeManger getEmployeeManger() {
		return employeeManger;
	}

	public void setEmployeeManger(EmployeeManger employeeManger) {
		this.employeeManger = employeeManger;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

}
