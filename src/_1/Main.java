package _1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import utils.IFileReaderAndWriter;
import utils.StreamFileController;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Path userHomePath = Paths.get(System.getProperty("user.dir"));
		Path mainPath = userHomePath.resolve("src\\_1\\data");

		StreamFileController<IFileReaderAndWriter> controller = new StreamFileController<IFileReaderAndWriter>(
				mainPath.resolve("texto.txt"), mainPath.resolve("texto-resultado.txt"), new IFileReaderAndWriter() {

					@Override
					public void write(FileInputStream reader, FileOutputStream writer) throws IOException {
						while (true) {
							int character = reader.read();
							if (character == -1)
								break;
							writer.write(character);
							System.out.print((char) character);
						}
					}
				});

		controller.exec();

		input.close();

	}
}
