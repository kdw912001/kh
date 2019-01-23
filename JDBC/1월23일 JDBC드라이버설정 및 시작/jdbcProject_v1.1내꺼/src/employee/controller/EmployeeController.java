package employee.controller;

import java.util.ArrayList;

import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;
import employee.view.EmployeeMenu;

public class EmployeeController {
	//DI 선언
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeController() {}
	
	public ArrayList<Employee> selectAll() {
		ArrayList<Employee> empList = edao.selectList();
		
		if(empList.size() == 0 || empList==null) {
			System.out.println("\n직원 정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		return empList;
	}

	public Employee selectEmployee(String empId) {
		Employee emp = edao.selectOne(empId);
		if(emp == null) {
			System.out.println(empId + " 사번 직원이 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();//원래는 이 방식으로 호출 안함.
											//나중에 배운다고 함.
		}
		return emp;
	}

	public ArrayList<Employee> selectJobId(String jobId) {
		ArrayList<Employee> empList = edao.selectJobList(jobId);
		
		if(empList.size() == 0) {
			System.out.println("\n해당 직급의 직원정보가 존재하지 않습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empList;
	}

	public ArrayList<Employee> selectDeptId(String deptId) {
		ArrayList<Employee> empList = edao.selectDeptList(deptId);
		
		if(empList.size() == 0) {
			System.out.println("\n해당 부서에 근무하는 직원정보가 없습니다.");
			new EmployeeMenu().displayMenu();
		}
		
		return empList;
	}

	public void insertEmployee(Employee emp) {
		int result = edao.insert(emp);
		
		if(result <= 0) {
			System.out.println("\n새 직원 등록 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		return;//return 하기 때문에 
			//new EmployeeMenu().displayMenu();할 필요없음
	}
}
