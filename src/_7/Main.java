package _7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = projectPath.resolve("src\\_7");

		Path inputPath = mainPath.resolve(input("Fichero entrada: " + mainPath + "\\"));

		try {

			FileReader reader = new FileReader(inputPath.toString());
			BufferedReader bufferedReader = new BufferedReader(reader);

			String palabraBuscar = input("Palabra buscar: ");

			while (true) {
				String line = bufferedReader.readLine();
				if (line == null)
					break;
				if (!line.contains(palabraBuscar)) {
					continue;
				}
				System.out.println(line);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		input.close();
	}

	public static String input(String message) {
		System.out.print(message);
		return input.nextLine();
	}

}
