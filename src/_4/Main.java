package _4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = projectPath.resolve("src\\_4");

		System.out.print("Fichero entrada: " + mainPath + "\\");
		Path inputPath = mainPath.resolve(input.nextLine());

		System.out.print("Fichero salida: " + mainPath + "\\");
		Path outputPath = mainPath.resolve(input.nextLine());

		try {

			FileReader reader = new FileReader(inputPath.toString());
			FileWriter writer = new FileWriter(outputPath.toString());

			if (!Files.exists(outputPath))
				try {
					Files.createFile(outputPath);
				} catch (IOException e) {
					e.printStackTrace();
				}

			while (true) {
				int character = reader.read();
				if (character == -1)
					break;
				if (character == (byte) 'a') {
					character = (byte) 'X';
				}
				writer.write(character);
				System.out.print((char) character);
			}

			reader.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		input.close();

	}

}
