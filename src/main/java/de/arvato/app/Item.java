package de.arvato.app;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import de.arvato.app.OutputResult;

public class Item {
	String name;
	String price;
	String rating;
	
	public Item(String name, String price, String rating) {
		this.name = name;
		this.price = price;
		this.rating = rating;
	}
	public String getName() {
	return this.name;
	}
	public void setName(String value) {
	this.name = value;
	}
	public String getPrice() {
	return this.price;
	}
	public void setPrice(String value) {
	this.price = value;
	}
	public String getRating() {
	return this.rating;
	}
	public void setRating(String value) {
	this.rating = value;
	}
	
/*-------------------Sort elements in the list----------------------------*/
	public static void sortList (List<Item>items) {
		
		Comparator<Item> c = new Comparator<Item>()
        {
            public int compare(Item u1, Item u2)
            {
                return (int) (Float.parseFloat(u1.getPrice()) - Float.parseFloat(u2.getPrice()));
            }
        };
        Collections.sort(items,c);
	}
/*------------------------getOptimalValue()------------------------------------------------*/
	public static int getOptimalValue(float money, List<Item>items) {
		int res = 0 ;
		if((money <= 0) || (items.size() <=0) )  {
			System.out.println("Kindly ask Florian to fill his List, \nor try to increase the money amount :) ");
			return -1 ;
		} 
        List<Integer> optimalList1 = new ArrayList<Integer>();/* list of all potential combination*/
        List<OptimalValue> optimalValueList = new ArrayList <OptimalValue>(); /*this is just to hold the index of the optimal value, so we can print the combination of optimal value  in console*/
        List<Float> ratingList1 = new ArrayList<Float>(); /*list containing sum of rating for the highest configurations */
        List<Float> maxRatingList = new ArrayList<Float>();
        List<String> stringList1 = new ArrayList<String>();/*to print the optimal combination(after we get the optimal value) on the console*/
        
        List<Float> potentialResult = new ArrayList<Float>(); /*potential results after backtracking*/
        OutputResult outputResult = new OutputResult();	/*object to hold the output results*/
        List<String> listOfPrices = Item.toList(items);	/*List of all the prices*/
        int accuracy = 0 ;   /*if accuracy ==0 it means we search for the combination that add the exact result(amount of money)*/
        					/*if accuracy ==1, and money = 24, then we search for all combination that add to 23*/
       for(int i = 0 ; i <= money; i++) {
    	   accuracy = i ;
    	   /*
    	    * if money = 24:
    	    * then we search all combination that adds to 24, then all the combination that adds to 23
    	    * */
    	   
    	   findNumbers(items,money,accuracy,potentialResult,outputResult,listOfPrices,0);
    	   optimalList1.addAll(optimalList(outputResult.str));
    	   ratingList1.addAll(ratingList(outputResult.rating));
    	   stringList1.addAll(stringList(outputResult.str));
    	   outputResult.clearAll();
    	   potentialResult.clear();
       }
       
       // now we get the max value of the rating 
        Float max = Collections.max(ratingList1);
        // loop to get all the elements that have the same max value
        for(int k = 0 ; k < ratingList1.size() ; k++) {
        	if(max.equals(ratingList1.get(k))) {
        		maxRatingList.add(max);
        // choose all the elements from optimalList1 that have the same index as the elements in the maxRatingList		
        		optimalValueList.add( new OptimalValue(k , optimalList1.get(k)));
        	}	
        }
        // Print the result on console	
        res = (int) OptimalValue.min(optimalValueList).getValue();
        System.out.println("Max Rating is: "+ max+"\n");
        System.out.println("optimalValue is: "+ res+"\n");
        /* type the combination for the optimal Value*/
        int index =  OptimalValue.min(optimalValueList).getIndex();
        System.out.println("Combination of the optimal Value are: \n"+ "["+stringList1.get(index).replaceAll(",", " EUR  -- ")+" EUR ]");
       

        return res;
	}
/*---------------------------findNumber()----------------------------------*/
	//Returns all combinations of items that have given a specific sum.
		 public static String findNumbers(List<Item> items, float sum,int accuracy,List<Float> r,OutputResult o, List<String> l1, int i )
	     {
		 
		// map the items prices to list
			 
			 
	     // If  current sum becomes negative
	     if (sum < 0)
	     	
	        return o.str ;

	     // if we get exact answer
	     if (sum == accuracy )
	     {
	      
	        o.row +=r ;
	        /* now after we return o.result +=r
	         * will return [1,2,3,4][1,4,6,7]
	         * we want to manipulate it to return string pattern we can split after in an easy way
	         * we separate between each elements with "," char ; 
	         * 
	         * then we want to return str containing the index and the rating of each result
	         * */        
	        String str="",ind = "",rating ="";
	        String separatingChar = ""; 
	        float value = 0;
	        int index =0;
	        for(int l = 0 ; l< r.size(); l++ ) {
	        	separatingChar = (l==0)? (""): (",");
	        	 value = r.get(l);
	        	 index = l1.indexOf( Integer.toString((int)value));
	        	str += separatingChar + Float.toString(value);
	        	ind += separatingChar + Integer.toString(index);
	        	rating += separatingChar + Float.parseFloat(items.get(index).getRating());
	        } 
	        /*Add ";" to separate between results */
	        o.str += str+";" ;
	        o.ind +=ind + ";"; /*We may not use this ind now...but I return it for future purposes*/
	        o.rating += rating + ";";
	        return o.str;
	     } 

	     // Recur for all remaining elements that
	     // have value smaller than sum.
	     while (i < items.size() && sum - Float.parseFloat(items.get(i).getPrice()) >= 0)
	     {

	        // Till every element in the array starting
	        // from i which can contribute to the sum
	        r.add(Float.parseFloat(items.get(i).getPrice())); // add them to list

	        // recur for next numbers
	         findNumbers(items, sum - Float.parseFloat(items.get(i).getPrice()),accuracy,r,o,l1, i);
	   
	        i++;

	        // remove number from list (backtracking)
	        r.remove(r.size()-1);
	     }
	     return o.str;

	     }
/*----------------------------optimalList()---------------------------*/ 
			public static List<Integer> optimalList(String s){
				 List<Integer>l1 = new ArrayList<Integer>() ;
				 String[] arr = s.split(";");
				  for(String str: arr) {
					  String[] arr2 = str.split(",");
					  l1.add(arr2.length);  
				  }
				return l1;
			 }
/*------------------------------------ratingList()-----------------------*/			
			public static List<Float> ratingList(String s){
				 List<Float>l1 = new ArrayList<Float>() ;
				 float sum = 0;
				 String[] arr = s.split(";");
				  for(String str: arr) {
					  String[] arr2 = str.split(",");
					  for(String str2 : arr2) {
						  if (str2.length() > 0) {  // test if str2 isn't empty
							  sum += Float.parseFloat(str2);  
						  }
					  }  
					  l1.add(sum);
					  sum = 0;
				  }
				return l1;
			 }
	/*-------------------------------------stringList()--------------------*/		
			/* 
			 * convert the output from the combination search to list of strings
			 * 
			 * */

			public static Collection<? extends String> stringList(String s){
			 List<String>l1 = new ArrayList<String>() ;
				 String[] arr = s.split(";");
				  for(String str: arr) {
			
					  l1.add(str);  
				  }
				return l1;
			 }
	
	/*------------------------get list of prices from the items ------------*/
	public static List<String> toList(List<Item> items){
		List<String> out = new ArrayList<String>();
		for(int k = 0 ; k< items.size(); k++) {
			out.add(items.get(k).getPrice());
		}
		return out;
	}
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Item item = (Item) object;
		return java.util.Objects.equals(name, item.name);
		}
		public int hashCode() {
		return Objects.hash(super.hashCode(), name);
		}
}

