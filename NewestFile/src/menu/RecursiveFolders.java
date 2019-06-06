package menu;

import java.io.File;
import java.io.FileFilter;

public class RecursiveFolders {

  void listFolder(File dir) {
    File[] subDirs;
    subDirs = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory();
      }
    });

    System.out.println("\nDirectory of "+ dir.getAbsolutePath());
    listFile(dir);

    for (File folder: subDirs){
      listFolder(folder);
    }
  }


  private void listFile(File dir){
    File[] files= dir.listFiles();
    for (File file:files){
      System.out.println(file.getName());
    }
  }

  public static void main(String[] args) {
  new RecursiveFolders().listFolder(new File("d:\\!Documentary"));
  }
}
