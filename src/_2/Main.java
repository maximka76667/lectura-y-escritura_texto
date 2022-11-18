package _2;

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

		Path userHomePath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = userHomePath.resolve("src\\_2");

		Path outputPath = mainPath.resolve("output.txt");

		if (!Files.exists(outputPath))
			try {
				Files.createFile(outputPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		try {
			FileWriter writer = new FileWriter(outputPath.toString());
			PrintWriter printWriter = new PrintWriter(writer);

			for (int i = 0; i < 100; i += 3) {
				printWriter.println(i);
			}

			printWriter.close();
			System.out.println("Listo");

		} catch (IOException e) {
			e.printStackTrace();
		}

		input.close();
	}
}
