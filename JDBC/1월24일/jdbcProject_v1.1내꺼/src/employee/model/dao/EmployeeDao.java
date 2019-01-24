package employee.model.dao;

import java.sql.*;
import java.util.ArrayList;

import employee.model.vo.Employee;

//dao : database access object
//jdbc 코드 : 비즈니스 로직
//데이터베이스에 대한 CRUD 소스 구현
//C(Create : insert), R(Read : select), U(Update : update),
//D(Delete : delete)
public class EmployeeDao {

	public EmployeeDao() {}
	
	//직원 전체 조회 처리용 메소드
	public ArrayList<Employee> selectList() {
		ArrayList<Employee> empList = new ArrayList</*Employee*/>();
		//앞에 제네릭 선언하면 뒤에 제네릭은 생략가능
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee";
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이버 등록 성공!");
			
			//2. 데이터베이스 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			//System.out.println("conn : " + conn);
			
			//3. 쿼리문 가지고 db에 가서 실행하고 나서 
			//결과 가지고 돌아오는 객체 생성함.
			stmt = conn.createStatement();
			
			//4. 쿼리문 보내서 실행하고 결과받기
			rset = stmt.executeQuery(query);
			
			//5. ResultSet 에 조회해 온 결과 행들의 컬럼값들을
			//하나씩 꺼내서 변수|필드에 옮겨 담기
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rset.getString("EMP_ID"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpNo(rset.getString("EMP_NO"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setHireDate(rset.getDate("HIRE_DATE"));
				emp.setJobId(rset.getString("JOB_ID"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonusPct(rset.getDouble("BONUS_PCT"));
				emp.setMarriage(rset.getString("MARRIAGE"));
				emp.setMgrId(rset.getString("MGR_ID"));
				emp.setDeptId(rset.getString("DEPT_ID"));
				
				empList.add(emp);
			}
			
		} catch (ClassNotFoundException e) {
			//Class.forName안에 오타나거나 ojdbc6.jar를 add안했을 때 발생
			e.printStackTrace();
		} catch (SQLException e) {
			//오타가 나거나 서버에 문제가 생겨 연결이 끊어졌을 때 발생
			e.printStackTrace();
		} finally {
			try {
				rset.close();//나중에 실행된 순서 먼저 close();
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList;
	}

	public Employee selectOne(String empId) {
		Employee emp = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where emp_id = '" + empId + "'";
		//쿼리문 사이에 공백을 조심해야 함. 자신없으면 그냥 한문장으로 쓰길
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			//3.
			stmt = conn.createStatement();
			//4.
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				emp = new Employee();
				emp.setEmpId(rset.getString("EMP_ID"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpNo(rset.getString("EMP_NO"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setHireDate(rset.getDate("HIRE_DATE"));
				emp.setJobId(rset.getString("JOB_ID"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonusPct(rset.getDouble("BONUS_PCT"));
				emp.setMarriage(rset.getString("MARRIAGE"));
				emp.setMgrId(rset.getString("MGR_ID"));
				emp.setDeptId(rset.getString("DEPT_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return emp;
	}

	public ArrayList<Employee> selectJobList(String jobId) {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where job_id = '"+jobId+"'";
		
		try {
		
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			//3.
			stmt = conn.createStatement();
			//4.
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rset.getString("EMP_ID"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpNo(rset.getString("EMP_NO"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setHireDate(rset.getDate("HIRE_DATE"));
				emp.setJobId(rset.getString("JOB_ID"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonusPct(rset.getDouble("BONUS_PCT"));
				emp.setMarriage(rset.getString("MARRIAGE"));
				emp.setMgrId(rset.getString("MGR_ID"));
				emp.setDeptId(rset.getString("DEPT_ID"));
				
				empList.add(emp);
			}
		} catch (Exception e) {//그냥 Exception으로 해도 됨.
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	public ArrayList<Employee> selectDeptList(String deptId) {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where dept_id = '"+deptId+"'";
		
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			//3.
			stmt = conn.createStatement();
			//4.
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rset.getString("EMP_ID"));
				emp.setEmpName(rset.getString("EMP_NAME"));
				emp.setEmpNo(rset.getString("EMP_NO"));
				emp.setEmail(rset.getString("EMAIL"));
				emp.setPhone(rset.getString("PHONE"));
				emp.setHireDate(rset.getDate("HIRE_DATE"));
				emp.setJobId(rset.getString("JOB_ID"));
				emp.setSalary(rset.getInt("SALARY"));
				emp.setBonusPct(rset.getDouble("BONUS_PCT"));
				emp.setMarriage(rset.getString("MARRIAGE"));
				emp.setMgrId(rset.getString("MGR_ID"));
				emp.setDeptId(rset.getString("DEPT_ID"));
				
				empList.add(emp);
			}
		} catch (Exception e) {//그냥 Exception으로 해도 됨.
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	public int insert(Employee emp) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String query = "insert into employee "
				+ "values (empid_seq.nextval, '"
				+ emp.getEmpName() + "', '"
				+ emp.getEmpNo()+ "', '"
				+ emp.getEmail()+ "', '"
				+ emp.getPhone()+ "', '"
				+ emp.getHireDate()+ "', '"
				+ emp.getJobId() + "', "
				+ emp.getSalary() + ", "
				+ emp.getBonusPct() + ", '"
				+ emp.getMarriage() + "', '"
				+ emp.getMgrId() + "', '"
				+ emp.getDeptId() + "')";
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			conn.setAutoCommit(false);//DB에서 자동 commit 못하게 함
			//3.
			stmt = conn.createStatement();
			//4.
			result = stmt.executeUpdate(query);
			//5.
			if(result > 0) 
				conn.commit();
			else
				conn.rollback();
		} catch (Exception e) {//그냥 Exception으로 해도 됨.
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updatePhone(Employee emp) {
		int result= 0;
		Connection conn = null;
		Statement stmt = null;
		
		String query = "update employee set phone = '"
				+ emp.getPhone() + "' where emp_id = '"
				+ emp.getEmpId() + "'";
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 데이터베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			//3. 쿼리문 실행용 객체 생성
			stmt = conn.createStatement();
			//4. 쿼리문 전송해서 실행시키고 결과받기
			result = stmt.executeUpdate(query);
			//5. 받은 결과에 대한 처리
			if(result > 0) {
				conn.commit();
			}else
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateBonusPct(Employee emp) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String query = "update employee set bonus_pct = "
				+ emp.getBonusPct() + " where emp_id = '"
				+ emp.getEmpId() + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int delete(String empId) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		String query = "delete from employee where emp_id = '"
					+ empId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0)
				conn.commit();
			else
				conn.rollback();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
