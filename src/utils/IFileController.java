package utils;

import java.io.FileOutputStream;
import java.io.IOException;

public interface IFileController {
	public void write(FileOutputStream writer) throws IOException;
}
