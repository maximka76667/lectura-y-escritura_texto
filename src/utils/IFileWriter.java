package utils;

import java.io.FileOutputStream;
import java.io.IOException;

public interface IFileWriter {
	void write(FileOutputStream writer) throws IOException;
}
