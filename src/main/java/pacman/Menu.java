import imputOutput.Reader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;


public class Menu {
	private static Menu m = null;
	String fileName = "menu.txt";
	int mapNumber;
	 Reader reader;
	
// Singleton pattern
	private Menu(int mapNumber) throws IOException {
		readUsingScanner(fileName);
		mapNumber = chooseMap();
	}
	
	public Menu getInstance(int mapNumber) throws IOException {
	    if (m == null) m = new Menu(mapNumber);
	    return m;
	  }
	
// https://www.journaldev.com/867/java-read-text-file	
	 private static void readUsingScanner(String fileName) throws IOException {
	        Path path = Paths.get(fileName);
	        Scanner scanner = new Scanner(path);
	        System.out.println("Read text file using Scanner");
	        //read line by line
	        while(scanner.hasNextLine()){
	            //process each line
	            String line = scanner.nextLine();
	            System.out.println(line);
	        }
	        scanner.close();
	    }	

	 private int chooseMap() {
		 reader = reader.getInstance();
		 int i = Integer.parseInt(reader.readString());
		 return i;
	 }
}
