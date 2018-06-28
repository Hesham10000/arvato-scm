package de.arvato.app;

public class OutputResult {
	String str = "";
	String row ="";
	String ind ="";
	String rating = "";

	/*clearAll function*/
	public void clearAll() {
		this.str = "";
		this.rating = "";
		this.ind = "";
		this.row ="";
	}
	/*setters and getters*/
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getInd() {
		return ind;
	}
	public void setInd(String ind) {
		this.ind = ind;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	

}

