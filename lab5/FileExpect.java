package lab5;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileExpect {
	public static void main(String[] args) {

		try {
			FileReader out = new FileReader (new File ("C:\\Users\\hjkkk\\eclipse-workspace\\lab5\\src\\lab5\\test_file.txt"));
			BufferedReader bufferedReader = new BufferedReader(out);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				}
			bufferedReader.close();
			}
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			}
		}
}
