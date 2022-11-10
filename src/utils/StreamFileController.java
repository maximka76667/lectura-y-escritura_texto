package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class StreamFileController extends FileController<FileInputStream, FileOutputStream> {
	Path outputPath;
	FileOutputStream writer;
	IFileController controller;

	public StreamFileController(Path outputPath) {
		this.outputPath = outputPath;
		try {
			this.writer = new FileOutputStream(outputPath.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void exec() {
		try {
			controller.write(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileOutputStream getWriter() {
		return writer;
	}

	public void setWriter(FileOutputStream writer) {
		this.writer = writer;
	}

	public IFileController getController() {
		return controller;
	}

	public void setController(IFileController controller) {
		this.controller = controller;
	}

}
