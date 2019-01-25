package employee.model.dao;

import java.sql.*;
import java.util.ArrayList;

import employee.model.vo.Employee;

public class EmployeeDao {

	public EmployeeDao() {}
	
	//직원 전체 조회 처리용 메소드
	public ArrayList<Employee> selectList(Connection conn) {
		ArrayList<Employee> empList = 
				new ArrayList<Employee>();		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee";		
		
		try {	
			stmt = conn.createStatement();
			
			//4. 쿼리문 보내서 실행하고 결과받기
			rset = stmt.executeQuery(query);
			
			//5. ResultSet 에 조회해 온 결과 행들의 컬럼값들을
			//하나씩 꺼내서 변수|필드에 옮겨 담기
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNo(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobId(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
				
				empList.add(emp);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList;
	}

	public Employee selectOne(
			Connection conn, String empId) {
		Employee emp = null;		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee "
				+ "where emp_id = ?";  
		
		try {			
			//3.
			pstmt = conn.prepareStatement(query);
			//? 에 값 적용
			pstmt.setString(1, empId);
			
			//4.
			rset = pstmt.executeQuery();
			//5.
			if(rset.next()) {
				emp = new Employee();
				
				emp.setEmpId(empId);
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNo(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobId(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return emp;
	}

	public ArrayList<Employee> selectJobList(
			Connection conn, String jobId) {
		ArrayList<Employee> empList = 
				new ArrayList<Employee>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee "
				+ "where job_id = ?";  
		
		try {			
			//3.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, jobId);
			
			//4.
			rset = pstmt.executeQuery();
			//5.
			while(rset.next()) {
				Employee emp = new Employee();
				
				emp.setEmpId(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNo(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobId(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
				
				empList.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return empList;
	}

	public ArrayList<Employee> selectDeptList(
			Connection conn, String deptId) {
		ArrayList<Employee> empList = 
				new ArrayList<Employee>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee "
				+ "where dept_id = ?";  
		
		try {			
			//3.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deptId);
			
			//4.
			rset = pstmt.executeQuery();
			//5.
			while(rset.next()) {
				Employee emp = new Employee();
				
				emp.setEmpId(rset.getString("emp_id"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setEmpNo(rset.getString("emp_no"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setHireDate(rset.getDate("hire_date"));
				emp.setJobId(rset.getString("job_id"));
				emp.setSalary(rset.getInt("salary"));
				emp.setBonusPct(rset.getDouble("bonus_pct"));
				emp.setMarriage(rset.getString("marriage"));
				emp.setMgrId(rset.getString("mgr_id"));
				emp.setDeptId(rset.getString("dept_id"));
				
				empList.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		
		return empList;
	}

	public int insert(Connection conn, Employee emp) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = "insert into employee "
				+ "values (empid_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {			
			//3.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setDate(5, emp.getHireDate());
			pstmt.setString(6, emp.getJobId());
			pstmt.setInt(7, emp.getSalary());
			pstmt.setDouble(8, emp.getBonusPct());
			pstmt.setString(9, emp.getMarriage());
			pstmt.setString(10, emp.getMgrId());
			pstmt.setString(11, emp.getDeptId());
			
			//4.
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {				
				pstmt.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return result;
	}

	public int updatePhone(
			Connection conn, Employee emp) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = "update employee "
				+ "set phone = ? where emp_id = ?";
						
		try {			
			//3. 쿼리문 실행용 객체 생성
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getPhone());
			pstmt.setString(2, emp.getEmpId());
			
			//4. 쿼리문 전송해서 실행시키고 결과받기
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		
		return result;
	}

	public int updateBonusPct(
			Connection conn, Employee emp) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = "update employee "
				+ "set bonus_pct = ? where emp_id = ?";				
		
		try {			
			//3. 쿼리문 실행용 객체 생성
			pstmt = conn.prepareStatement(query);
			pstmt.setDouble(1, emp.getBonusPct());
			pstmt.setString(2, emp.getEmpId());
			
			//4. 쿼리문 전송해서 실행시키고 결과받기
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		
		return result;
	}

	public int delete(Connection conn, String empId) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = "delete from employee where emp_id = ?"; 
		
		try {			
			//3.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empId);
			
			//4. 
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		
		return result;
	}

}








