package _1;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Path projectPath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = projectPath.resolve("src\\_1");

		try {

			FileReader reader = new FileReader(mainPath.resolve(input.nextLine()).toString());

			while (true) {
				int character = reader.read();
				if (character == -1)
					break;
				System.out.print((char) character);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		input.close();

	}
}
