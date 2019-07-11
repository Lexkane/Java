import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileVisitor {
	public static void main(String[] args) throws IOException {
		Path fileDir=Paths.get("files");
		FileWalker myfilewalker= new FileWalker();
		Files.walkFileTree(fileDir, myfilewalker);
	}

}
