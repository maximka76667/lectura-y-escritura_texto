package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileWriter implements IFiler {
	protected IFileWriter controller;
	protected FileOutputStream writer;

	public FileWriter(Path outputPath, IFileWriter controller) {
		this.controller = controller;
		try {
			this.writer = new FileOutputStream(outputPath.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exec() throws IOException {
		controller.write(writer);
	}

}
