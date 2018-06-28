package de.arvato.algorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LinearSearchTest {
	
	LinearSearch linearSearch ;
	List <String> list1 ;
	List <String> list2 ;
	List <String> expectedInBothLists;
	List <String> expectedOnlyInList1 ;
	List <String> expectedOnlyInList2 ;

	Map <String,List<String>> map1 ;
	
	List<String>inBothLists ;
	List<String>onlyInList1 ;
	List<String>onlyInList2 ;
	
	@Before 
	public void setUp() throws Exception {
		linearSearch = new LinearSearch();
		list1 = new ArrayList<String>();
		list2 = new ArrayList<String>();
		expectedInBothLists = new ArrayList<String>();
		expectedOnlyInList1 = new ArrayList<String>();
		expectedOnlyInList2 = new ArrayList<String>();

		map1 = new HashMap<String, List<String>>();
		
		inBothLists = new ArrayList<String>();
		onlyInList1 = new ArrayList<String>();
		onlyInList2 = new ArrayList<String>();

	}

	@Test
	public void testEmptyList() {
		/*arrange*/
		/*act*/
		map1 = linearSearch.search(list1, list2);
		inBothLists = map1.get("inBothLists");
		onlyInList1 = map1.get("onlyInList1");
		onlyInList2 = map1.get("onlyInList2");
		/*assert*/
		assertThat(inBothLists, (IsEmptyCollection.empty()));
		assertThat(onlyInList1, (IsEmptyCollection.empty()));
		assertThat(onlyInList2, (IsEmptyCollection.empty()));
		
		
	}//------
	@Test
	public void testEmptyString() {
		/*arrange*/
		list1.addAll(Arrays.asList("","Text4"));		
		list2.addAll(Arrays.asList("","Text3"));
		/*act*/
		map1 = linearSearch.search(list1, list2);
		inBothLists = map1.get("inBothLists");
		onlyInList1 = map1.get("onlyInList1");
		onlyInList2 = map1.get("onlyInList2");
		/*assert*/
		assertThat(inBothLists, hasItems(""));
		
		
	} //------*/
	@Test
	public void caseSensitivity() {
		/*arrange*/
		list1.addAll(Arrays.asList("Text1","Text4"));		
		list2.addAll(Arrays.asList("text1","Text3"));
		/*act*/
		map1 = linearSearch.search(list1, list2);
		inBothLists = map1.get("inBothLists");
		onlyInList1 = map1.get("onlyInList1");
		onlyInList2 = map1.get("onlyInList2");
		/*assert*/
		assertThat(inBothLists, hasItems("text1"));
		
	} //------*/
	@Test
	public void testInBothList() {
		/*arrange*/
		list1.addAll(Arrays.asList("word1","word2","word5","word6"));		
		list2.addAll(Arrays.asList("word5","word6","word3","word4"));
		
		expectedInBothLists = Arrays.asList("word5","word6");
		
		/*act*/
		map1 = linearSearch.search(list1, list2);
		inBothLists = map1.get("inBothLists");
		onlyInList1 = map1.get("onlyInList1");
		onlyInList2 = map1.get("onlyInList2");
		/*assert*/
		assertThat(inBothLists, is(expectedInBothLists));
		
	} //------*/
	@Test
	public void testOnlyInList1() {
		/*arrange*/
		list1.addAll(Arrays.asList("word1 word5","word2 words3","word5","word6 word5"));		
		list2.addAll(Arrays.asList("word5","word6","word3","word4"));
		
		expectedOnlyInList1 = Arrays.asList("word1 word5","word2 words3","word6 word5");
		
		/*act*/
		map1 = linearSearch.search(list1, list2);
		inBothLists = map1.get("inBothLists");
		onlyInList1 = map1.get("onlyInList1");
		onlyInList2 = map1.get("onlyInList2");
		/*assert*/
		assertThat(onlyInList1, is(expectedOnlyInList1));
		
	} //------*/
	@Test
	public void testOnlyInList2() {
		/*arrange*/
		list1.addAll(Arrays.asList("arvato-scm"));		
		list2.addAll(Arrays.asList("word5","word6","word3","word4","arvato-scm"));
		
		expectedOnlyInList2 = Arrays.asList("word5","word6","word3","word4");
		
		/*act*/
		map1 = linearSearch.search(list1, list2);
		inBothLists = map1.get("inBothLists");
		onlyInList1 = map1.get("onlyInList1");
		onlyInList2 = map1.get("onlyInList2");
		/*assert*/
		assertThat(onlyInList2, is(expectedOnlyInList2));
		
	} //------*/
}
