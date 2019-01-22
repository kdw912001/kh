package employee.controller;

import employee.model.dao.EmployeeDao;

public class EmployeeController {
	//의존성 주입 : di
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeController() {}
	
}
