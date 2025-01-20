package books;

import java.util.ArrayList;
import java.util.List;

import models.Book;
import utils.FileUtil;

public class BookService {

	public static Book createBook(int bookCode, String bookName, String bookAuthor, String bookType, int bookQty) {
		Book book = new Book(bookCode, bookName, bookAuthor, bookType, bookQty);
		return book;
	}

	public static Book updateBook(int bookCode, Book book, List<Book> listBook) {

		for (Book itemBook : listBook) {
			if (itemBook.getBookCode() == bookCode) {
				if (book.getBookAuthor() != null) {
					itemBook.setBookAuthor(book.getBookAuthor());
				}
				if (book.getBookName() != null) {
					itemBook.setBookName(book.getBookName());
				}
				if (book.getBookType() != null) {
					itemBook.setBookType(book.getBookType());
				}
				if (book.getBookQty() >= 0) {
					itemBook.setBookQty(book.getBookQty());
				}
				return itemBook;
			}
		}

		return null;
	}

	public static Boolean deleteBook(int bookCode, List<Book> listBook) {
		int index = -1;
		for (int i = 0; i < listBook.size(); i++) {
			Book itemBook = listBook.get(i);
			if (itemBook.getBookCode() == bookCode) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			listBook.remove(index);
			return true;
		}

		return false;
	}
	
	public static Book searchBook(int bookCode, String name, String author,List<Book> listBook) {
		Book book = null;
		for (int i = 0; i < listBook.size(); i++) {
			Book itemBook = listBook.get(i);
			if (bookCode >= 0 && itemBook.getBookCode() == bookCode) {
				book = itemBook;
				break;
			}
			if (name != null && !name.isEmpty() && itemBook.getBookName().equals(name)) {
				book = itemBook;
				break;
			}
			if (author != null && !author.isEmpty() && itemBook.getBookAuthor().equals(author)) {
				book = itemBook;
				break;
			}
		}

		return book;
	}
	
	public static List<Book> searchAll(String fileName) {
		List<Book> books = new ArrayList<Book>();
		String data = FileUtil.readFile(fileName);
		String[] item = data.split("\n"); // | 
		for (String book : item) {
			Book bookItem = new Book();
//			System.out.println("Item: " + book);
			String[] propertys = book.split(",");
			for (String property : propertys) {
//				System.out.println(propertys);
				String[] keyVaule = property.split("=");
				if (keyVaule[0].equals("bookCode")) {
					bookItem.setBookCode(Integer.parseInt(keyVaule[1]));
				}
				if (keyVaule[0].equals("bookName")) {
					bookItem.setBookName(keyVaule[1]);
				}
				if (keyVaule[0].equals("bookAuthor")) {
					bookItem.setBookAuthor(keyVaule[1]);
				}
				if (keyVaule[0].equals("bookType")) {
					bookItem.setBookType(keyVaule[1]);
				}
				if (keyVaule[0].equals("bookQty")) {
					bookItem.setBookQty(Integer.parseInt(keyVaule[1]));
				}
			}
			books.add(bookItem);
		}
		return books;
	}

	public static void main(String[] args) {

	}

}
