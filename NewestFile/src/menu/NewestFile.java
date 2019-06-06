package menu;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class NewestFile {

  public static void main(String[] args) throws IOException {

    Path currentDir = Paths.get(System.getProperty("user.dir"));
    DirectoryStream<Path> dirStream = Files.newDirectoryStream(currentDir);

    long newest = 0L;
    long currentTimestamp = System.currentTimeMillis();

    for (Path path : dirStream) {
      BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
      System.out.println("Currently Iterating on" + path.toAbsolutePath());
      long createTime = attr.creationTime().toMillis();
      if (createTime > newest) {
        newest = createTime;
      }
    }

    Date date = new Date(newest);
    System.out.println("The newest file is :" + date.toString());


  }

}
