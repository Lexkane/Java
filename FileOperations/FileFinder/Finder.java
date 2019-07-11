package com.company.lexkane;

import java.io.IOException;

public class Finder{

	public static void main(String[] args) throws IOException{
		Path fileDir=Paths.get("files");
		FileFinder finder = new FileFinder("file*.txt");
		Files.walkFileTree(fileDir,finder);

		ArrayList<Path> foundFiles= finder.foundPaths;

		if (foundFiles.size()>0){
			for (Path path: foundFiles){
				System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS))
			}
		}
		else{
			System.out.println("No files where found");
		}
	}
}