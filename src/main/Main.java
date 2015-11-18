package main;
import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import  validator.Messages;
import validator.SudokuValidator;


public class Main {
	public static void main(String[] args) throws JAXBException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Messages.INPUT_FILE);
		String sudokuFile = scanner.nextLine();
		File file = new File("./test/" + sudokuFile);
		if (!file.exists()) {
			System.err.println(Messages.INVALID_FILE_ERROR);
			System.exit(1);
		}

		SudokuValidator validator = new SudokuValidator();
		validator.validate(file);
	}

}
