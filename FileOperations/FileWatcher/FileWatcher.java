package com.company.lexkane;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEvenetKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.nio.file.Map;

public class Main{
	public static void main(String[] args){
		try(WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey,Path> keyMap= new HashMap<>();
			Path path = Paths.get("files");
			keyMap.put(path.register(service,StandardWatchEvenetKinds.ENTRY_CREATE,
				StandardWatchEvenetKinds.ENTRY_DELETE,
				StandardWatchEvenetKinds.ENTRY_MODIFY),
			path);
			WatchKey watchKey;
			do { 
				watchKey=service.take();
				Path eventDir=keyMap.get(watchKey);

				for (WatchEvent<?> event: watchKey.pollEvents()){
					WatchEvent.Kind<?> kind =event.kind();
					Path eventPath= (Path)event.context();
					System.out.println(eventDir+":" +kind+":"+eventPath);
				}


			} while( watchKey.reset())
		} catch (Execption e){
			e.printStackTrace();
		}
	}
}