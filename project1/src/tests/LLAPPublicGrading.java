package tests;
import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import code.LLAPSearch;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LLAPPublicGrading {


	String initialState1 = "50;" +
			"12,12,12;" +
			"50,60,70;" +
			"30,2;19,2;15,2;" +
			"300,5,7,3,20;" +
			"500,8,6,3,40;";


	@Test(timeout = 120000)
	public void testa1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "BF", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void testb1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "DF", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void testc1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "UC", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void testd1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "ID", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void teste1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "GR1", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void testf1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "GR2", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void testg1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "AS1", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

	@Test(timeout = 120000)
	public void testh1() throws Exception {
		String solution = LLAPSearch.solve(initialState1, "AS2", true);
		System.out.println(solution);
		solution = solution.replace(" ", "");
		LLAPPlanChecker pc = new LLAPPlanChecker(initialState1);
		assertTrue("The output actions do not lead to a goal state.", pc.applyPlan(initialState1, solution));
	}

}