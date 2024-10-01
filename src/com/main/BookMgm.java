package com.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.controllers.LibraryController;
import com.models.Book;
import com.models.History;

// Create the following methods in the TestLibrary class. Test all the functionalities.

public class BookMgm {
    public static void main(String[] args) {
        Book[] books = new Book[0];
        History[] history = new History[0];
        LibraryController library = new LibraryController(books, history);
        
        addBooks(library);
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create a new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Update the stock of a book");
            System.out.println("5. List all books");
            System.out.println("6. List all history");
            System.out.println("7. List all history between two dates");
            System.out.println("8. Enter the book name you want to search");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the book: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the stock of the book: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    library.updateBookStock(name, stock);
                    System.out.println("______________________________");
                    System.out.println("Book created successfully");
                    System.out.println("______________________________");
                    break;
                case 2:
                    System.out.print("Enter the name of the book: ");
                    name = scanner.nextLine();
                    Book book = library.borrowBook(name);
                    if (book == null) {
                        System.out.println("______________________________");
                        System.out.println("Book not found");
                    } else {
                        System.out.println("______________________________");
                        System.out.println("Book borrowed");
                    }
                    System.out.println("______________________________");
                    break;
                case 3:
                    System.out.print("Enter the name of the book: ");
                    name = scanner.nextLine();
                    System.out.print("Enter the stock of the book: ");
                    stock = scanner.nextInt();
                    scanner.nextLine();
                    book = new Book(0, name, stock);
                    book = library.returnBook(book);
                    if (book == null) {
                        System.out.println("______________________________");
                        System.out.println("Book not found");
                    } else {
                        System.out.println("______________________________");
                        System.out.println("Book returned");
                    }
                    System.out.println("______________________________");
                    break;
                case 4:
                    System.out.print("Enter the name of the book: ");
                    name = scanner.nextLine();
                    System.out.print("Enter the stock of the book: ");
                    stock = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("______________________________");
                    library.updateBookStock(name, stock);
                    System.out.println("Stock updated successfully");
                    System.out.println("______________________________");
                    break;
                case 5:
                    System.out.print("Do you want to see the stock information? (y/n): ");
                    String answer = scanner.nextLine();
                    boolean haveStockInfo = answer.equals("y");
                    System.out.println("______________________________");
                    library.listAllBooks(haveStockInfo);
                    System.out.println("______________________________");
                    break;
                case 6:
                    System.out.println("______________________________");
                    library.listAllHistory("2020-01-01", "2020-12-31");
                    System.out.println("______________________________");
                    break;
                case 7:
                    System.out.print("Enter the start date (yyyy-mm-dd): ");
                    String fromDate = scanner.nextLine();
                    System.out.print("Enter the end date (yyyy-mm-dd): ");
                    String toDate = scanner.nextLine();
                    System.out.println("______________________________");
                    library.listAllHistory(fromDate, toDate);
                    System.out.println("______________________________");
                    break;
                case 8:
                	 System.out.println("Enter the book name you want to search");
                	 String bookName = scanner.nextLine();
                	 library.searchBook(bookName);
                	 break;
                case 9:
                    System.exit(0);
            }
        }
    }
    
    public static void addBooks(LibraryController library) {
    	library.updateBookStock("JAVA", 1);
        library.updateBookStock("OOPS", 4);
        library.updateBookStock("JAVA For Beginners", 2);
    }
}
