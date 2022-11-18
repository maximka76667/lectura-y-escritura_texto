package _5;

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

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = projectPath.resolve("src\\_5");

		System.out.print("Fichero entrada: " + mainPath + "\\");
		Path inputPath = mainPath.resolve(input.nextLine());

		System.out.print("Fichero salida: " + mainPath + "\\");
		Path outputPath = mainPath.resolve(input.nextLine());

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

			int i = 1;

			while (true) {
				String line = bufferedReader.readLine();
				if (line == null)
					break;
				String newLine = i + " " + line;
				printWriter.println(newLine);
				System.out.println(newLine);
				i++;
			}

			reader.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		input.close();
	}

}
