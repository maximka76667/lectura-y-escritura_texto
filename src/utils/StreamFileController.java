package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class StreamFileController<T> extends FileController<FileInputStream, FileOutputStream> {
	protected IFiler filer;

	public StreamFileController(Path outputPath, IFileWriter controller) {
		super(outputPath);
		this.filer = new FileWriter(outputPath, controller);
	}

	public StreamFileController(Path inputPath, Path outputPath, IFileReaderAndWriter controller) {
		super(inputPath, outputPath);
		this.filer = new FileReaderAndWriter(inputPath, outputPath, controller);
	}

	public void exec() {
		try {
			filer.exec();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
