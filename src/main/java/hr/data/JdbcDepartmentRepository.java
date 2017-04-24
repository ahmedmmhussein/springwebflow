package hr.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.beans.Department;

@Repository
public class JdbcDepartmentRepository implements DepartmentRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcDepartmentRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Department> findDepartments() {
		// TODO Auto-generated method stub
		return jdbc.query("select * from Department", new BeanPropertyRowMapper(Department.class));
	}

	@Override
	public Department findById(int id) {
		return (Department) jdbc.queryForObject("select * from Department where departmentId = ?",
				new BeanPropertyRowMapper(Department.class), id);
	}

}
