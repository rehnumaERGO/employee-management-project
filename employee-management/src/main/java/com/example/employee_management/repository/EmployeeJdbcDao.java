package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeJdbcDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Employee> employeeRowMapper = new RowMapper<>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee e = new Employee();
            e.setId(rs.getLong("id"));
            e.setName(rs.getString("name"));
            e.setDepartment(rs.getString("department"));
            e.setRole(rs.getString("role"));
            e.setSalary(rs.getDouble("salary"));
            return e;
        }
    };

    public List<Employee> findAllByDepartment(String department) {
        return jdbcTemplate.query(
                "SELECT * FROM employee WHERE department = ?",
                new Object[] { department },
                employeeRowMapper);
    }
}