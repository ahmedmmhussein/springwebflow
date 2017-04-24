package hr.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable("request")
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	Employee sender;
	Department receiverDepartment;
	String subject;
	String body;
	boolean notify;
	Employee notifiedEmployee;

	public Request() {
		notifiedEmployee = new Employee();
		sender = new Employee();
		receiverDepartment = new Department();
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public Department getReceiverDepartment() {
		return receiverDepartment;
	}

	public void setReceiverDepartment(Department receiverDepartment) {
		this.receiverDepartment = receiverDepartment;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Employee getNotifiedEmployee() {
		return notifiedEmployee;
	}

	public void setNotifiedEmployee(Employee notifiedEmployee) {
		this.notifiedEmployee = notifiedEmployee;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

}
