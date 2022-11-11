package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public interface IFileReaderAndWriter {
	void write(FileInputStream reader, FileOutputStream writer) throws IOException;

}
