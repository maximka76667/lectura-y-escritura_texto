package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileReaderAndWriter implements IFiler {

	protected IFileReaderAndWriter controller;
	private FileInputStream reader;
	private FileOutputStream writer;

	public FileReaderAndWriter(Path inputPath, Path outputPath, IFileReaderAndWriter controller) {
		this.controller = controller;
		try {
			this.reader = new FileInputStream(inputPath.toString());
			this.writer = new FileOutputStream(outputPath.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exec() throws IOException {
		controller.write(reader, writer);
	}
}
