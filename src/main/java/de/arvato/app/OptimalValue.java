package de.arvato.app;

import java.util.List;

public class OptimalValue {
	int index ;
	float value ;
	
	public OptimalValue() {}
	public OptimalValue(int index, float value) {
		this.index = index;
		this.value = value ;
	}
	/*min() function*/
	public static OptimalValue min (List<OptimalValue>l1) {
		OptimalValue min = l1.get(0);
		
		for (OptimalValue o1 : l1) {
			if(o1.getValue() < min.getValue()) {
				min = o1 ;
			}
		}
	
		return min;
	}
	/*setters and getters */
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}

	

}

