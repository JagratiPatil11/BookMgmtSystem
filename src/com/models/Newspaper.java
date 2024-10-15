package com.models;

public class Newspaper {
	public int newspaperId;
	public String newspaperName;
	public String language;
	public int newspaperStock;
	
	
	public Newspaper() {
		
	}
	
	public Newspaper(int newspaperId, String newspaperName, String language, int newspaperStock) {
		this.newspaperId= newspaperId;
		this.newspaperName = newspaperName;
		this.language = language;
		this.newspaperStock = newspaperStock;
	}

	public void display(Newspaper newspaper) {
		System.out.println("Newspaper Name : " + newspaper.newspaperName + "\nNewspaper Id " + newspaper.newspaperId
				+ "\nlanguage " + newspaper.language + "\nstock " + newspaper.newspaperStock);
	}
	
}
