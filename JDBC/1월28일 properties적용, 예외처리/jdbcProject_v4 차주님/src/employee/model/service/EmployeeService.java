package employee.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;

//Connection 관리와 트랜잭션 처리가 주목적임
public class EmployeeService {
	//DI
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeService() {} 

	public HashMap<String, Employee> selectMap() {		
		Connection conn = getConnection();
		HashMap<String, Employee> empMap = 
				edao.selectMap(conn);
		close(conn);
		return empMap;
	}

	public Employee selectOne(String empId) {		
		Connection conn = getConnection();
		Employee emp = edao.selectOne(conn, empId);
		close(conn);
		return emp;
	}

	public HashMap<String, Employee> selectJobMap(String jobId) {
		Connection conn = getConnection();
		HashMap<String, Employee> empMap = 
				edao.selectJobMap(conn, jobId);		
		close(conn);
		return empMap;
	}

	public HashMap<String, Employee> selectDeptMap(String deptId) {
		Connection conn = getConnection();
		HashMap<String, Employee> empMap = 
				edao.selectDeptMap(conn, deptId);
		close(conn);
		return empMap;
	}

	public int insert(Employee emp) {
		Connection conn = getConnection();
		int result = edao.insert(conn, emp);
		
		if(result > 0)			
			commit(conn);
		else			
			rollback(conn);		
		close(conn);
		
		return result;
	}

	public int updatePhone(Employee emp) {
		Connection conn = getConnection();
		int result = edao.updatePhone(conn, emp);
		
		if(result > 0)			
			commit(conn);
		else			
			rollback(conn);		
		close(conn);
		
		return result;
	}

	public int updateBonusPct(Employee emp) {		
		Connection conn = getConnection();
		int result = edao.updateBonusPct(conn, emp);
		
		if(result > 0)			
			commit(conn);
		else			
			rollback(conn);		
		close(conn);
		
		return result;
	}

	public int delete(String empId) {		
		Connection conn = getConnection();
		int result = edao.delete(conn, empId);
		
		if(result > 0)			
			commit(conn);
		else			
			rollback(conn);		
		close(conn);
		
		return result;
	}
}
