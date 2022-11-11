package _2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import utils.FileWriter;
import utils.IFileWriter;
import utils.StreamFileController;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Path userHomePath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = userHomePath.resolve("src\\_2\\output");

		Path outputPath = mainPath.resolve("output.txt");

		if (!Files.exists(outputPath))
			try {
				Files.createFile(outputPath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		StreamFileController<FileWriter> controller = new StreamFileController<FileWriter>(outputPath,
				new IFileWriter() {
					@Override
					public void write(FileOutputStream writer) throws IOException {
						for (int i = 0; i < 100; i += 3) {
							writer.write(String.valueOf(i).getBytes());
							writer.write('\n');
							System.out.print(i);
						}
					}
				});

		controller.exec();

		input.close();
	}
}
