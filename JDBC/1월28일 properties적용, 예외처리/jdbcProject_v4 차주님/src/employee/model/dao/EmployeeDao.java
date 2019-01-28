package employee.model.dao;

//import common.JDBCTemplate;
import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

import employee.model.vo.Employee;

public class EmployeeDao {
	//DI
	private Properties prop = new Properties();
	
	public EmployeeDao() {
		try {
			prop.load(new FileReader("properties/query.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//직원 전체 조회 처리용 메소드
	public HashMap<String, Employee> selectMap(Connection conn) {
		HashMap<String, Employee> empMap = 
				new HashMap<String, Employee>();		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectall");		
		
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
				
				empMap.put(emp.getEmpId(), emp);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {			
			close(rset);
			close(stmt);
		}
		
		return empMap;
	}

	public Employee selectOne(
			Connection conn, String empId) {
		Employee emp = null;		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectone");  
		
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
			/*JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);*/
			close(rset);
			close(pstmt);
		}
		
		return emp;
	}

	public HashMap<String, Employee> selectJobMap(
			Connection conn, String jobId) {
		HashMap<String, Employee> empMap = 
				new HashMap<String, Employee>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectjob");  
		
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
				
				empMap.put(emp.getEmpId(), emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {			
			close(rset);
			close(pstmt);
		}
		
		return empMap;
	}

	public HashMap<String, Employee> selectDeptMap(
			Connection conn, String deptId) {
		HashMap<String, Employee> empMap = 
				new HashMap<String, Employee>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectdept");  
		
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
				
				empMap.put(emp.getEmpId(), emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {			
			close(rset);
			close(pstmt);
		}		
		
		return empMap;
	}

	public int insert(Connection conn, Employee emp) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insert");
		
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
			//JDBCTemplate.close(pstmt);
			close(pstmt);
		}
		
		
		return result;
	}

	public int updatePhone(
			Connection conn, Employee emp) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updatep");
						
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
			//JDBCTemplate.close(pstmt);
			close(pstmt);
		}		
		
		return result;
	}

	public int updateBonusPct(
			Connection conn, Employee emp) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateb");				
		
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
			//JDBCTemplate.close(pstmt);
			close(pstmt);
		}		
		
		return result;
	}

	public int delete(Connection conn, String empId) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("delete"); 
		
		try {			
			//3.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empId);
			
			//4. 
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//JDBCTemplate.close(pstmt);
			close(pstmt);
		}		
		
		return result;
	}

}








