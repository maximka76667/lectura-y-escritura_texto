package utils;

import java.nio.file.Path;

public class FileController<T, T2> {

	protected Path inputPath;
	protected Path outputPath;

	public FileController(Path outputPath) {
		this.outputPath = outputPath;
	}

	public FileController(Path inputPath, Path outputPath) {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}

}
