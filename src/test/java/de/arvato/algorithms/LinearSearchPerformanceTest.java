package de.arvato.algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LinearSearchPerformanceTest {
	
	LinearSearch linearSearch ;
	List <String> list1 ;
	List <String> list2 ;
	
	@Before
	public void setUp() throws Exception {
		 linearSearch = new LinearSearch();
		 list1 = new ArrayList<String>();
		 list2 = new ArrayList<String>();
	}

	@Test(timeout =300)
	public void testLinearSearchPerformance() {
		list1.addAll(Arrays.asList("Text1","Text4","text5","text7","text9","text11,text21"));		
		list1.addAll(Arrays.asList("Text14","Text12","text2","text6","text8","text10,text21"));
		linearSearch.performance(list1, list2);
	}

}
