package _2;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {

			Path userHomePath = Paths.get(System.getProperty("user.dir"));
			Path mainPath = userHomePath.resolve("src\\_2\\output");

			Path outputPath = mainPath.resolve("output.txt");

			if (!Files.exists(outputPath))
				Files.createFile(outputPath);

			FileOutputStream writer = new FileOutputStream(outputPath.toString());

			for (int i = 0; i < 100; i += 2) {
				writer.write(String.valueOf(i).getBytes());
				writer.write('\n');
				System.out.print(i);
			}

			writer.close();
			input.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
