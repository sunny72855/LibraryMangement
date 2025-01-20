import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import models.Book;
import models.BookLoan;
import models.User;

public class Global {
	public static List<Book> listBook = new ArrayList<Book>();
	public static List<User> listUser = new ArrayList<User>();
	public static List<BookLoan> listBookLoan = new ArrayList<BookLoan>();
	public static SimpleDateFormat parserDate = new SimpleDateFormat("dd/MM/yyyy");
}
