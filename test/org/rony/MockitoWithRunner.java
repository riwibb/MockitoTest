package org.rony;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoWithRunner {
	@Mock EmployeeDetails mockEmployeeDetails;
	/*
	//This will pass stand alone
	@InjectMocks EmpBusinessLogic injectEbl;
	@Test
	public void testInject() {
		doReturn(30.0).when(mockEmployeeDetails).getMonthlySalary();
		assertEquals(injectEbl.calculateYearlySalary(), 360.0, 0);
	}*/
	@Test
	public void testMocks() {
		EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic(mockEmployeeDetails);
		when(mockEmployeeDetails.getMonthlySalary()).thenReturn(1.0);
		assertEquals(empBusinessLogic.calculateYearlySalary(), 12, 0);
	}
	
	@Spy EmployeeDetails spy_ed = new EmployeeDetails("Karim", 1200.0, 22);
	@Test
	public void testSpy() {
		doNothing().when(spy_ed).anotherCrapFunction();
		EmpBusinessLogic eb = new EmpBusinessLogic(spy_ed);
		// Calls Real function of ED
		assertEquals(eb.calculateAppraisal(), 500.0, 0);
		// Does not call real function of ED
		eb.callcCrapFunction();
	}
	

}
