package org.rony;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class MockitoWithRunner {
	@Mock
	EmployeeDetails mockEmployeeDetails;
	@Spy
	EmployeeDetails spy_ed = new EmployeeDetails("Karim", 1200.0, 22);
	
	@Test
	public void testMocks() {
		EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic(mockEmployeeDetails);
		when(mockEmployeeDetails.getMonthlySalary()).thenReturn(1.0);
		assertEquals(empBusinessLogic.calculateYearlySalary(), 12, 0);
	}
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
