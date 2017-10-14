package org.rony;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class MockitoTest {

	EmployeeDetails mockEmployeeDetails;
	EmpBusinessLogic ebl;

	
	@Before
	public void init() {
		mockEmployeeDetails= mock(EmployeeDetails.class);
		ebl = new EmpBusinessLogic(mockEmployeeDetails);
		
	}
	
	@Test
	public void testMocks() {
		assertEquals(mockEmployeeDetails.getAge(),0);
		assertNull(mockEmployeeDetails.grabString());
	}	
	
	@Test
	public void testDummy() {
		assertEquals(mockEmployeeDetails.getAge(),0);
		assertTrue(ebl.dummyFunction());
		verify(mockEmployeeDetails).grabString();
		when(mockEmployeeDetails.getMonthlySalary()).thenReturn(1.0);
		assertEquals(ebl.calculateYearlySalary(),12,0);
	}
	
	@Test
	public void testExceptionProper(){
		EmployeeDetails ed = new EmployeeDetails();
		EmpBusinessLogic eb = new EmpBusinessLogic(ed);
		
		EmpBusinessLogic spy_eb = spy(eb);
		
	    doNothing().when(spy_eb).crapFunction();
		spy_eb.crapFunction();
	}
	
	@Test
	public void testExceptionProper1(){
		EmployeeDetails ed = new EmployeeDetails();
		ed.setName("Karim");
		ed.setMonthlySalary(1200.0);
		ed.setAge(22);
		
		EmployeeDetails spy_ed = spy(ed);
		doNothing().when(spy_ed).anotherCrapFunction();
		
		EmpBusinessLogic eb = new EmpBusinessLogic(spy_ed);
		
		//Calls Real unction of ED
		assertEquals(eb.calculateAppraisal(), 500.0,0);
		//Does not call real function of ED
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

				
	}
	
	
}
