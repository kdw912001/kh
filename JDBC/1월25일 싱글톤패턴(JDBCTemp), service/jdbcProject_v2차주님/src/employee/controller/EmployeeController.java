package employee.controller;

import java.util.ArrayList;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeController {
	//DI 선언
	private EmployeeService eservice = 
			new EmployeeService();	
	
	public EmployeeController() {}

	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> empList = eservice.selectList();
		
		if(empList.size() > 0) {
			System.out.println("전체조회 성공!");
		}else{
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}		
		
		return empList;
	}

	public Employee selectEmployee(String empId) {
		Employee emp = eservice.selectOne(empId);
		
		if(emp == null) {
			System.out.println(empId + " 사번 직원이 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return emp;
	}

	public ArrayList<Employee> selectJobId(String jobId) {
		ArrayList<Employee> empList = 
				eservice.selectJobList(jobId);
		
		if(empList.size() == 0) {
			System.out.println("\n해당 직급의 직원정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empList;
	}

	public ArrayList<Employee> selectDeptId(
			String deptId) {
		ArrayList<Employee> empList = 
				eservice.selectDeptList(deptId);
		
		if(empList.size() == 0) {
			System.out.println("\n해당 부서에 근무하는 직원정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empList;
	}

	public void insertEmployee(Employee emp) {
		int result = eservice.insert(emp);
		
		if(result > 0) { 
			System.out.println("\n직원 정보 등록 성공!");
		}else{
			System.out.println("\n새 직원 등록 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
		return;
	}

	public void updatePhone(Employee emp) {
		int result = eservice.updatePhone(emp);
		
		if(result > 0) {
			System.out.println("\n직원의 전화번호 변경 성공!");
		}else {
			System.out.println("\n전화번호 변경 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
		return;		
	}

	public void updateBonusPct(Employee emp) {
		int result = eservice.updateBonusPct(emp);
		
		if(result > 0) {
			System.out.println("\n직원의 보너스포인트 변경 성공!");
		}else {
			System.out.println("\n보너스포인트 변경 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
		return;
	}

	public void deleteEmployee(String empId) {
		int result = eservice.delete(empId);
		
		if(result > 0) {
			System.out.println("\n직원 정보 삭제 성공!");
		}else {
			System.out.println("\n직원 정보 삭제 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		
		return;
	}

}










