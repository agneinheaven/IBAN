package fizzBuzz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Iban {
	public static void main(String[] args) throws IOException {
		Main iban = new Main();
		System.out.println();
		System.out.println("Insert 1 or 2 or q");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		switch (choice) {
		case "1":
			System.out.println("Insert IBAN: ");
			String ibanNumber = scan.nextLine();
			System.out.println(iban.ibanTest(ibanNumber));
			break;
		case "2":
			System.out.println("File");
			System.out.println("Enter file path");
			String filePath = scan.nextLine();
			System.out.println("Enter file name");
			String fileName = scan.nextLine();
			
			File file = new File(filePath+fileName+".out");
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
    		try
			  {
			    BufferedReader reader = new BufferedReader(new FileReader(filePath+fileName));
			    String line;
			    while ((line = reader.readLine()) != null)
			    {
			      boolean ib = iban.ibanTest(line);
			      String ib2 = Boolean.toString(ib);
			      ib2.trim();
			      bw.write(line.trim()+";"+ib2+'\n');
			    }
			    reader.close();
			    bw.close();
			  }
			  catch (Exception e)
			  {
			    System.err.format("Exception occurred trying to read '%s'.", file);
			    e.printStackTrace();
			  }
			  break;
		      case "q":; default:{
			  System.out.println("The game is over");
			  System.exit(0);
		}
		}
	}
}
