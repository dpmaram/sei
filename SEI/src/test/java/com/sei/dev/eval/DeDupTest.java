package com.sei.dev.eval;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeDupTest {
	public int[] testData = {1,2,34,34,25,1,45};
	public int[] result_WITH_ORDER_change = {1,2,25,34,45};
	public int[] result_WITHOUT_order_change = {1,2,34,25,45};
	DeDup test = null;

	@Before
	public void setUp() throws Exception {
		test = new DeDup();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
	@Test	
	public void testSortAndFindUnique() {
		assertTrue(Arrays.equals(result_WITH_ORDER_change, test.sortAndFindUnique(testData)));
	}

	
	@Test
	public void testFindUnique() {
		assertTrue(Arrays.equals(result_WITHOUT_order_change, test.findUnique(testData)));
	}	
	
		
	@Test
	public void testFindUniqueNoOrderChange() {
		assertTrue(Arrays.equals(result_WITHOUT_order_change, test.findUniqueNoOrderChange(testData)));
	}
	
	
}
