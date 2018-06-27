package de.arvato.algorithms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinearSearch implements SearchAlgorithm {

	public Map<String, List<String>> search(List<String> list1, List<String> list2) {
		// TODO Auto-generated method stub
		List<String>inBothLists = new ArrayList<String>();
		List<String>onlyInList1 = new ArrayList<String>();
		List<String>onlyInList2 = new ArrayList<String>();
		
		Map <String,List<String>> map1 = new HashMap<String, List<String>>();
		/*doSearch takes two lists and returns the common values and the unique values in the first list*/
		map1 = doSearch(list1,list2);
		inBothLists = map1.get("commonValue"); 	/*get common values*/
		onlyInList1 = map1.get("uniqueValue");	/*get unique values in list1*/
		map1 = doSearch(list2, inBothLists);
		onlyInList2 = map1.get("uniqueValue");	/*get unique values in list2*/
		
		map1.remove("commonValue");	/*remove unused keys*/
		map1.remove("uniqueValue");
		map1.put("onlyInList1", onlyInList1);
		map1.put("onlyinList2", onlyInList2);
		map1.put("inBothLists", inBothLists);
		return map1;
		
	}
	/*------------------------------------------ doSearch function--------------------------------------------------------*/
	public Map<String,List<String>> doSearch(List<String> list1, List<String> list2){
		Map <String,List<String>> map1 = new HashMap<String, List<String>>();
		List<String> inBothLists = new ArrayList<String>();
		List<String> onlyInList1 = new ArrayList<String>();
		/*get size of both lists*/
		int size1 = list1.size();
		int size2 = list2.size();
		/*Test if one of the lists is empty*/
		if((size1 ==0)||(size2 ==0)) { 
			map1.put("commonValue", inBothLists);
			map1.put("uniqueValue", list1);
			return map1;
		}
		String s1,s2;
		for (int i=0; i <size1;i++) { 		/*1- Loop thru each element in the first list */			
        	for(int j=0 ; j< size2; j++) {  /*2- Loop thru the second list */
        		s1 = list1.get(i).toLowerCase();
        		s2 = list2.get(j).toLowerCase();     			        		
        		if(s1.equals(s2)) {  		/*3- If you find common value: */     							   
        			inBothLists.add(s1);		/*put it in the common List and switch to the next element in the first list*/ 
        			break ;
        		}      		
        		else { 						/*4- If you don't find that element and you reached the end of the second list:*/
        			if( (j == size2-1) ) { /* then put this element in onlyInList1 */ 
        				onlyInList1.add(s1);
        			}
        		}
        	}// End of Second For
        } // End of First For
		
		map1.put("commonValue", inBothLists);
		map1.put("uniqueValue", onlyInList1);
		return map1;
	}

}

