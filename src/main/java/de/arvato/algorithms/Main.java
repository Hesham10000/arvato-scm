package de.arvato.algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import arvato.BinarySearch;
//import arvato.JavaSearch;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> list1 = new ArrayList<String>();
		List <String> list2 = new ArrayList<String>();
		
		Map<String,List<String>> map1 = new HashMap<String, List<String>>();
		Map<String,List<String>> map2 = new HashMap<String, List<String>>();
		
		// file the first list
		list1.addAll(Arrays.asList("Text2","Text4","Text6",""," ","text10"));
		
		// fill the second list
		list2.addAll(Arrays.asList("Text1","Text3","Text5","Text10",""," "));
		
		/*javaSearch implements the built-in Library and it's case sensitive*/
		JavaSearch javaSearch = new JavaSearch();
		/*linearSearch is better in performance and it's case-insensitive*/
		LinearSearch linearSearch = new LinearSearch();
	
		//  apply the two search algorithm
		map1 = javaSearch.search(list1, list2);
		map2 = linearSearch.search(list1, list2);
		// Print out the result
		System.out.println(map1);
		System.out.println(map2);


	}

}

