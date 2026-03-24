package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExistingFileDelete {
	
	public static void deleteFileIfExists(String filePath) throws IOException {
		Path p = Paths.get(filePath);
		if(Files.deleteIfExists(p))
		{
			System.out.println("Existing File Deleted");
		}
		else
		{
			System.out.println("No Existing File");
		}
	}

}
