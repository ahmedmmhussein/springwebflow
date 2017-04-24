package hr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import hr.beans.Department;
import hr.beans.Employee;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcEmployeeRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Employee> findEmployees() {
		return jdbc.query("select * from Employee, Department where department = departmentId",
				new EmployeeRowMapper());
	}

	@Override
	public Employee findById(long id) {
		return jdbc.queryForObject("select * from Employee , Department where department = departmentId AND id=?",
				new EmployeeRowMapper(), id);
	}

	
	@Override
	public void addEmployee(Employee employee) {
		jdbc.update(
				"insert into Employee (name, jobTitle, department, email, dataofBirth, salary)"
						+ " values (?, ?, ?, ?, ?, ?)",
				employee.getName(), employee.getJobTitle(), employee.getDepartment().getDepartmentId(),
				employee.getEmail(), employee.getDataofBirth(), employee.getSalary());
	}


	@Override
	public void updateEmployee(Employee employee) {
		jdbc.update(
				"UPDATE Employee SET name = ?, salary= ?, jobTitle=?, department=?, email=?, dataofBirth=?  WHERE id = ?",
				employee.getName(), employee.getSalary(), employee.getJobTitle(), employee.getDepartment(),
				employee.getEmail(), employee.getDataofBirth(), employee.getId());
	}


	@Override
	public void deleteEmployee(long id) {
		jdbc.update("DELETE FROM Employee WHERE id=?", id);
	}

	private static class EmployeeRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Department department = new Department();
			department.setDepartmentId(rs.getInt("departmentId"));
			department.setDepartmentName(rs.getString("departmentName"));
			return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("jobTitle"),
					rs.getLong("salary"), department, rs.getDate("dataofBirth"));

		}
	}

}
