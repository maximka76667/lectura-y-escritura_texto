package _6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = projectPath.resolve("src\\_6");

		Path inputPath = mainPath.resolve(input("Fichero entrada: " + mainPath + "\\"));
		Path outputPath = mainPath.resolve(input("Fichero salida: " + mainPath + "\\"));

		try {

			FileReader reader = new FileReader(inputPath.toString());
			FileWriter writer = new FileWriter(outputPath.toString());

			BufferedReader bufferedReader = new BufferedReader(reader);
			PrintWriter printWriter = new PrintWriter(writer);

			if (!Files.exists(outputPath))
				try {
					Files.createFile(outputPath);
				} catch (IOException e) {
					e.printStackTrace();
				}

			String palabraBuscar = input("Palabra buscar: ");
			String palabraReemplazar = input("Palabra reemplazar: ");

			while (true) {
				String line = bufferedReader.readLine();
				if (line == null)
					break;
				String newLine = line.replace(palabraBuscar, palabraReemplazar);
				printWriter.println(newLine);
				System.out.println(newLine);
			}

			reader.close();
			writer.close();

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
