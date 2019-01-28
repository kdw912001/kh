package employee.controller;

import java.util.HashMap;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeController {
	//DI 선언
	private EmployeeService eservice = new EmployeeService();
	
	public EmployeeController() {}
	
	public HashMap<String, Employee> selectAll() {
		HashMap<String, Employee> empMap = eservice.selectMap();
		
		if(empMap.size() == 0 || empMap==null) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		return empMap;
	}

	public Employee selectEmployee(String empId) {
		Employee emp = eservice.selectOne(empId);
		if(emp == null) {
			System.out.println(empId + " 사번 직원이 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();//원래는 이 방식으로 호출 안함.
											//나중에 배운다고 함.
		}
		return emp;
	}

	public HashMap<String, Employee> selectJobId(String jobId) {
		HashMap<String, Employee> empMap = eservice.selectJobMap(jobId);
		
		if(empMap.size() == 0) {
			System.out.println("\n해당 직급의 직원정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empMap;
	}

	public HashMap<String, Employee> selectDeptId(String deptId) {
		HashMap<String, Employee> empMap = eservice.selectDeptMap(deptId);
		
		if(empMap.size() == 0) {
			System.out.println("\n해당 부서에 근무하는 직원정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empMap;
	}

	public void insertEmployee(Employee emp) {
		int result = eservice.insert(emp);
		
		if(result > 0) {
			System.out.println("\n직원 정보 등록 성공!");
		}else {
			System.out.println("\n새 직원 등록 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		return;//return 하기 때문에 
			//new EmployeeMenu().displayMenu();할 필요없음
	}

	public void updatePhone(Employee emp) {
		int result = eservice.updatePhone(emp);
		
		if(result > 0) {
			System.out.println("\n직원의 전화번호 변경 성공!");
		}else {
			System.out.println("\n전화번호 변경 실패!");
			System.out.println("확인하고 다시 시도하십시오");
		}
		return;
	}

	public void updateBonusPct(Employee emp) {
		int result = eservice.updateBonusPct(emp);
		if(result > 0) {
			System.out.println("\n직원의 보너스포인트 변경 성공!");
		}else {
			System.out.println("\n보너스포인트 변경 실패!");
			System.out.println("확인하고 다시 시도하십시오");
		}
		return;
	}

	public void deleteEmployee(String empId) {
		int result = eservice.delete(empId); 
		if(result > 0) {
			System.out.println("\n직원 정보 삭제 성공!");
		}else {
			System.out.println("\n");
			System.out.println("확인하고 다시 시도하십시오");
		}
		return;
	}
}
