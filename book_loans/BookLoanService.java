package book_loans;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import models.Book;
import models.BookLoan;

public class BookLoanService {
	
	public static BookLoan createBookLoan(int userCode, int bookCode, Date dateLoan) {
		BookLoan bookLoan = new BookLoan(userCode, bookCode, dateLoan);
		return bookLoan;
	}
	

	public static BookLoan createBookLoan(int userCode, int bookCode, Date dateLoan, Date dateReturn) {
		BookLoan bookLoan = new BookLoan(userCode, bookCode, dateLoan, dateReturn);
		return bookLoan;
	}
	
	public static BookLoan updateBookLoan(int bookCode, BookLoan bookLoan, List<BookLoan> listBook) {

		for (BookLoan itemBook : listBook) {
			if (itemBook.getBookCode() == bookCode) {
				if (bookLoan.getUserCode() > 0) {
					itemBook.setUserCode(bookLoan.getUserCode());
				}
				if (bookLoan.getDateLoan() != null) {
					itemBook.setDateLoan(bookLoan.getDateLoan());
				}
				if (bookLoan.getDateReturn() != null) {
					itemBook.setDateReturn(bookLoan.getDateReturn());
				}
				return itemBook;
			}
		}

		return null;
	}
	
	public static Boolean deleteBookLoan(int userCode, List<BookLoan> listBook) {
		int index = -1;
		for (int i = 0; i < listBook.size(); i++) {
			BookLoan itemBook = listBook.get(i);
			if (itemBook.getUserCode() == userCode) {
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
	public static BookLoan searchBookLoan(int userCode, int bookCode, Date dateLoan, Date dateReturn, List<BookLoan> listBook) {
		BookLoan bookLoan = null;
		for (int i = 0; i < listBook.size(); i++) {
			BookLoan itemBook = listBook.get(i);
			if (userCode >= 0 && itemBook.getUserCode() == userCode) {
				bookLoan = itemBook;
				break;
			}
			if (bookCode >= 0 && itemBook.getBookCode() == bookCode) {
				bookLoan = itemBook;
				break;
			}
			if (dateLoan != null) {
				String dateLoanString = parsertoDate(dateLoan);
				String itemBookString = parsertoDate(itemBook.getDateLoan());
				if (dateLoanString.equals(itemBookString)) {
					bookLoan = itemBook;
					break;
				}
			}
			if (dateReturn != null) {
				String dateReturnString = parsertoDate(dateReturn);
				String itemBookString = parsertoDate(itemBook.getDateReturn());
				if(dateReturnString.equals(itemBookString)) {
				bookLoan = itemBook;
				break;
				}
			}
		}

		return bookLoan;
	}
	
	public static String parsertoDate(Date date) {
		String pattern = "MM/dd/yyyy HH:mm:ss";

		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date according to the chosen pattern
		DateFormat df = new SimpleDateFormat(pattern);
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String todayAsString = df.format(date);
		return todayAsString;

	}

}