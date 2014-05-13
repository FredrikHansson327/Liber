package logic;

import java.util.ArrayList;

import database.*;


public class DocumentCommander {

	
	ArrayList<String> cart = new ArrayList<String>();
	ArrayList<String> searchResult = new ArrayList<String>();
	
	public DocumentCommander(){}
	
	
	public void searchDocument(String search, String key){
		
		
		if(search.equals("Titel"))
			this.searchResult = Querys.getDocByTitle(key);
		else if(search.equals("Författare"))
			this.searchResult = Querys.getDocByAuthor(key);
		else if(search.equals("ISBN"))
			this.searchResult = Querys.getDocByID(key);
		
		
	
	}

	
	
	public void addDocumentToCart(String document){
	
		this.cart.add(document);
		
	}
	
	
	public void removeDocumentFromCart(String document){
		
		this.cart.remove(document);
		
	}
	
	
	public String[] getCartDocuments(){
		
		String[] temp = new String[cart.size()];
		cart.toArray(temp);
		return temp;
		
	}
	
	
	public String[] getSearchDocuments(){
		
		String[] temp = new String[searchResult.size()];
		searchResult.toArray(temp);
		return temp;
	}
	
	
	
}
