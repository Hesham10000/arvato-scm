package de.arvato.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.arvato.app.Item;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float money = 30 ;
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item("A","15","10");
		Item item2 = new Item("B","13","9");
		Item item3 = new Item("C","12","8");
		Item item4 = new Item("d","9","7"); 
		Item item5 = new Item("e","7","6");
		Item item6 = new Item("f","6","5");
		Item item7 = new Item("g","5","4");
		
		items.addAll(Arrays.asList(item1,item2,item3,item4,item5,item6,item7));
		
		Item.sortList(items);
		System.out.println(items);
		Item.getOptimalValue(money, items);
	}/*End of Main*/
}
