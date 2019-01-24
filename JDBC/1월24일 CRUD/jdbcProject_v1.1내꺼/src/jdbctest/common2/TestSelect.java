package jdbctest.common2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import employee.model.vo.Employee;

public class TestSelect {

	public static void main(String[] args) {
		select();

	}
	public static void select() {
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where emp_id = 100";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Employee e = new Employee();
				e.setEmpId(rset.getString("emp_id"));
				e.setEmpName(rset.getString("emp_name"));
				e.setEmpNo(rset.getString("emp_no"));
				e.setEmail(rset.getString("email"));
				e.setPhone(rset.getString("phone"));
				e.setHireDate(rset.getDate("hire_date"));
				e.setJobId(rset.getString("job_id"));
				e.setSalary(rset.getInt("salary"));
				e.setBonusPct(rset.getDouble("bonus_pct"));
				e.setMarriage(rset.getString("marriage"));
				e.setMgrId(rset.getString("mgr_id"));
				e.setDeptId(rset.getString("dept_id"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Employee g: list)
			System.out.println(g);
	}

}
