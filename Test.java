import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		String data = "Hello, this is some text to save in a file! 234234234234234";
		try (FileOutputStream fos = new FileOutputStream("example.txt")) {
			fos.write(data.getBytes());
			System.out.println("File saved successfully using FileOutputStream.");
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}

	}

}
