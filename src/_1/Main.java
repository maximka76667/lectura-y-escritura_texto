package _1;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		try {

			Path userHomePath = Paths.get(System.getProperty("user.dir"));
			Path mainPath = userHomePath.resolve("src\\_1\\data");

			FileReader reader = new FileReader(mainPath.resolve("texto.txt").toString());
			FileWriter writer = new FileWriter(mainPath.resolve("texto-resultado.txt").toString());

			while (true) {
				int character = reader.read();
				if (character == -1)
					break;
				writer.write(character);
				System.out.print((char) character);
			}

			writer.close();
			reader.close();
			input.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
