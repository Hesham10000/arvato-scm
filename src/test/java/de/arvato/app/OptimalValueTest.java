package de.arvato.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OptimalValueTest {
	Item item1, item2, item3, item4, item5, item6, item7 ;
	List<Item> items;
	int expectedResult, actualResult;

	@Before
	public void setUp() throws Exception {
		 expectedResult = 0;
		 actualResult = 0;
		 items = new ArrayList<Item>();
		 item1 = new Item("A","15","10");
		 item2 = new Item("B","13","9");
		 item3 = new Item("C","12","8");
		 item4 = new Item("d","9","7"); 
		 item5 = new Item("e","7","6");
		 item6 = new Item("f","6","5");
		 item7 = new Item("g","5","4"); 
		
	}

	@Test
	public void testEmptyList() {
	/*arrange*/
		float money = 30 ;		
		Item.sortList(items);
	/*act*/
		actualResult = Item.getOptimalValue(money, items);
	/*assert*/	
		assertEquals(actualResult, -1);
	}
	@Test
	public void testNoEnoughMoney() {
	/*arrange*/
		float money = 10 ;
		items.add(item1);
		Item.sortList(items);
	/*act*/
		actualResult = Item.getOptimalValue(money, items);
	/*assert*/	
		assertEquals(actualResult, 0);
	}
	@Test
	public void testOptimalValue() {
	/*arrange*/
		float money = 24 ;
		items.addAll(Arrays.asList(item1,item2,item3,item4,item5,item6,item7));	
		Item.sortList(items);
	/*act*/
		actualResult = Item.getOptimalValue(money, items);
	/*assert*/	
		assertEquals(actualResult, 4);
	}

}
