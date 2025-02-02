package com.controllers;

import com.models.Book;
import com.models.History;
import com.models.Newspaper;
import com.views.BookView;

public class LibraryController {

    Book[] books;
    History[] history;
    Newspaper[] newspapers;

    public LibraryController(Book[] books, History[] history, Newspaper[] newspapers) {
        this.books = books;
        this.history = history;
        this.newspapers = newspapers;
    }

    public void listAllHistory(String fromDate, String toDate) {
        for (History history : history) {
            if (history.date.compareTo(fromDate) >= 0 && history.date.compareTo(toDate) <= 0) {
                history.display();
            }
        }
    }

    History[] addHistory(History[] history, History h) {
        History[] newHistory = new History[history.length + 1];
        for (int i = 0; i < history.length; i++) {
            newHistory[i] = history[i];
        }
        newHistory[history.length] = h;
        return newHistory;
    }
    
	 public Book returnBook(Book book) {
	        for (Book b : books) {
	            if (b.name.equals(book.name)) {
	                b.stock++;
	                history = addHistory(history, History.logReturnBook(book, "2020-01-01"));
	                return b;
	            }
	        }
	        return null;
	    }
	 
	 public Book borrowBook(String name) {
	        for (Book book : books) {
	            if (book.name.equals(name)) {
	                if (book.stock == 0) {
	                    history = addHistory(history, History.reportMissing(book, "2020-01-01"));
	                } else {
	                    book.stock--;
	                    history = addHistory(history, History.logGetBook(book, "2020-01-01"));
	                }
	                return book;
	            }
	        }
	        return null;
	    }

	 public void updateBookStock(String name, int stock) {
	        for (Book book : books) {
	            if (book.name.equals(name)) {
	                book.stock = stock;
	                return;
	            }
	        }
	        books = addBook(books, new Book(books.length + 1, name, stock));
	    }

		 Book[] addBook(Book[] books, Book book) {
		        Book[] newBooks = new Book[books.length + 1];
		        for (int i = 0; i < books.length; i++) {
		            newBooks[i] = books[i];
		        }
		        newBooks[books.length] = book;
		        return newBooks;
		    }
		 
		 public void searchBook(String name) {
		    	for(Book book : books) {
		    		if(book.name.toUpperCase().contains(name.toUpperCase())) {
		    			System.out.println (book.id + " " + book.name + " " + book.stock);
		    		}
		    	}
		    	for(Newspaper newspaper : newspapers) {
		    		if(newspaper.newspaperName.toUpperCase().contains(name.toUpperCase())) {
		    			System.out.println (newspaper.newspaperId + " " + newspaper.newspaperName +
		    					" " + newspaper.language + " " + newspaper.newspaperStock);
		    		}
		    	}
		    }
		 
		 public void listAllBooksAndNewspaper(boolean haveStockInfo) {
			 
			 // books[], newpapaer[]
			 ArrayList<>
			 
			 
		        for (Book book : books) {
		            if (haveStockInfo) {
		            	new BookView().display(book);
		            } else {
		                System.out.println("Book ID: " + book.id);
		                System.out.println("Book Name: " + book.name);
		            }
		        }
		        
		        for (Newspaper newspaper : newspapers) {
		        	new Newspaper().display(newspaper);
		        }
		    }
	 
	 
}
