package _8;

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

	// Funcion que recibe un mensaje para mostrar y devuelve la cadena de entrada
	public static String input(String message) {
		System.out.print(message);
		return input.nextLine();
	}

	// Funcion que recibe path de entrada, path de salida y PrintWriter
	// y copia todo el contenido desde entrada a salida
	public static void pasteContent(Path inputPath, Path outputPath, PrintWriter printWriter) throws IOException {
		FileReader reader = new FileReader(inputPath.toString());
		BufferedReader bufferedReader = new BufferedReader(reader);

		while (true) {
			String line = bufferedReader.readLine();
			if (line == null)
				break;
			printWriter.println(line);
			System.out.println(line);
		}
		reader.close();

		printWriter.println();
		System.out.println();
	}

	public static void main(String[] args) {

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = projectPath.resolve("src\\_8");

		Path input1Path = mainPath.resolve(input("Fichero entrada 1: " + mainPath + "\\"));
		Path input2Path = mainPath.resolve(input("Fichero entrada 2: " + mainPath + "\\"));
		Path outputPath = mainPath.resolve(input("Fichero salida: " + mainPath + "\\"));

		if (!Files.exists(outputPath))
			try {
				Files.createFile(outputPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		try {
			FileWriter writer = new FileWriter(outputPath.toString());
			PrintWriter printWriter = new PrintWriter(writer);

			pasteContent(input1Path, outputPath, printWriter);
			pasteContent(input2Path, outputPath, printWriter);

			printWriter.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
