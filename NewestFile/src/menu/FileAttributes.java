package menu;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        DirectoryStream<Path> paths = null;


        try {
            paths= Files.newDirectoryStream(currentPath);

            for (Path path:paths){
                System.out.println(path.getFileName());
                BasicFileAttributes attr = Files.readAttributes(path,BasicFileAttributes.class);
                System.out.println("  ->" +(attr.size()/1000)+" kb");
                System.out.println("  -> is directory " + attr.isDirectory());
                System.out.println("  -> is file" +attr.isRegularFile());
                System.out.println("  -> is symlink" + attr.isSymbolicLink());
                System.out.println("  -> created"+ attr.creationTime());
                System.out.println("  -> modified"+ attr.lastModifiedTime());
                System.out.println();
            }
        } catch(IOException e){
            System.err.println(e);
        }


    }
}
