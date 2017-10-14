package org.rony;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

public class MockitoTest {

	EmployeeDetails mockEmployeeDetails;
	EmpBusinessLogic empBusinessLogic;

	@Before
	public void init_before_every_test_call() {
		mockEmployeeDetails = mock(EmployeeDetails.class);
		empBusinessLogic = new EmpBusinessLogic(mockEmployeeDetails);
	}

	@Test
	public void testMocks() {
		assertEquals(mockEmployeeDetails.getAge(), 0);
		assertNull(mockEmployeeDetails.grabString());
	}

	@Test
	public void testDummy() {
		assertEquals(mockEmployeeDetails.getAge(), 0);
		assertTrue(empBusinessLogic.dummyFunction());
		verify(mockEmployeeDetails).grabString();
		when(mockEmployeeDetails.getMonthlySalary()).thenReturn(1.0);
		assertEquals(empBusinessLogic.calculateYearlySalary(), 12, 0);
	}

	@Test
	public void testExceptionProper() {
		EmployeeDetails ed = new EmployeeDetails();
		EmpBusinessLogic eb = new EmpBusinessLogic(ed);

		EmpBusinessLogic spy_eb = spy(eb);
		doNothing().when(spy_eb).crapFunction();
		spy_eb.crapFunction();
	}

	@Test
	public void testExceptionProper1() {
		EmployeeDetails ed = new EmployeeDetails();
		ed.setName("Karim");
		ed.setMonthlySalary(1200.0);
		ed.setAge(22);

		EmployeeDetails spy_ed = spy(ed);
		doNothing().when(spy_ed).anotherCrapFunction();
		EmpBusinessLogic eb = new EmpBusinessLogic(spy_ed);
		// Calls Real function of ED
		assertEquals(eb.calculateAppraisal(), 500.0, 0);
		// Does not call real function of ED
		eb.callcCrapFunction();
	}

	@Test
	public void testList() {
		List<String> list = new ArrayList<String>();
		List<String> spyList = spy(list);
		doReturn("3").when(spyList).get(anyInt());
		spyList.add("34");
		spyList.add("35");
		spyList.add("37");
		assertEquals(spyList.get(1), "3");
	}

	@Test
	public void testParams() {
		empBusinessLogic.forceAgeChange(37);		
		verify(mockEmployeeDetails).setAge(ArgumentMatchers.eq(37));
		verify(mockEmployeeDetails, never()).setAge(ArgumentMatchers.eq(39));
		verify(mockEmployeeDetails, atLeastOnce()).setAge(anyInt());
		verifyNoMoreInteractions(mockEmployeeDetails);
	}

}
