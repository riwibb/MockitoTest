package org.rony;

public class EmpBusinessLogic {
	private EmployeeDetails employeeDetails;
	public EmpBusinessLogic(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	// Calculate the yearly salary of employee
	public double calculateYearlySalary() {
		double yearlySalary = 0;
		yearlySalary = this.employeeDetails.getMonthlySalary() * 12;
		return yearlySalary;
	}

	// Calculate the appraisal amount of employee
	public double calculateAppraisal() {
		double appraisal = 0;

		if (this.employeeDetails.getMonthlySalary() < 10000) {
			appraisal = 500;
		} else {
			appraisal = 1000;
		}

		return appraisal;
	}
	public boolean dummyFunction() {
		this.employeeDetails.grabString();
		return true;
	}
	public void crapFunction() {
		int m = 4/0;
	}
	public void callcCrapFunction() {
		employeeDetails.anotherCrapFunction();
	}
	public void forceAgeChange(int age) {
		this.employeeDetails.setAge(age);
	}
}
