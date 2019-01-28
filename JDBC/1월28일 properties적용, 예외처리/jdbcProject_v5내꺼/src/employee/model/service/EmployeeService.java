package employee.model.service;

//import common.JDBCTemplate;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import employee.exception.EmployeeException;
import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;

//Connection 관리와 트랜잭션 처리가 주목적임
public class EmployeeService {
	//DI
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeService() {}

	public HashMap<String, Employee> selectMap() throws EmployeeException{
		/*Connection conn = JDBCTemplate.getConnection();
		ArrayList<Employee> empList = edao.selectList(conn);
		JDBCTemplate.close(conn);		
		return empList;*/
		Connection conn = getConnection();
		HashMap<String, Employee> empMap = edao.selectMap(conn);
		close(conn);
		return empMap;
	}

	public Employee selectOne(String empId) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		Employee emp = edao.selectOne(conn, empId);
		//JDBCTemplate.close(conn);		
		close(conn);
		return emp;
	}

	public HashMap<String, Employee> selectJobMap(String jobId) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		HashMap<String, Employee> empMap = edao.selectJobMap(conn, jobId);
		//JDBCTemplate.close(conn);
		close(conn);		
		return empMap;
	}

	public HashMap<String, Employee> selectDeptMap(String deptId) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		HashMap<String, Employee> empMap = edao.selectDeptMap(conn, deptId);
		//JDBCTemplate.close(conn);		
		close(conn);		
		return empMap;
	}

	public int insert(Employee emp) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		int result = edao.insert(conn, emp);
		if(result > 0)
			//JDBCTemplate.commit(conn);
			commit(conn);
		
		//JDBCTemplate.close(conn);
		close(conn);
		return result;
	}

	public int updatePhone(Employee emp) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		int result = edao.updatePhone(conn, emp);
		if(result > 0)
			//JDBCTemplate.commit(conn);
			commit(conn);
		
		//JDBCTemplate.close(conn);
		close(conn);
		return result;
	}

	public int updateBonusPct(Employee emp) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		int result = edao.updateBonusPct(conn, emp);
		if(result > 0)
			//JDBCTemplate.commit(conn);
			commit(conn);
		
		//JDBCTemplate.close(conn);
		close(conn);
		return result;
	}

	public int delete(String empId) throws EmployeeException{
		//Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		int result = edao.delete(conn, empId);
		if(result > 0)
		//	JDBCTemplate.commit(conn);
			commit(conn);
		
		//JDBCTemplate.close(conn);
		close(conn);		
		return result;
	}
}
