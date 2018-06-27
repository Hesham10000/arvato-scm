package de.arvato.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaSearch implements SearchAlgorithm {

	public Map<String, List<String>> search(List<String> list1, List<String> list2) {
		// TODO Auto-generated method stub
		List<String>inBothLists = new ArrayList<String>(list1);
		List<String>onlyInList1 = new ArrayList<String>(list1);
		List<String>onlyInList2 = new ArrayList<String>(list2);
		
		Map <String,List<String>> map1 = new HashMap<String, List<String>>();
		
		inBothLists.retainAll(list2);
		onlyInList1.removeAll(list2);
		onlyInList2.removeAll(list1);
		
		
		map1.put("onlyInList1", onlyInList1);
		map1.put("onlyinList2", onlyInList2);
		map1.put("inBothLists", inBothLists);
		
		return map1;
	}
	

}