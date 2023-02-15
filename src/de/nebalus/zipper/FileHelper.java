package de.nebalus.zipper;

import java.io.File;
import java.util.ArrayList;

public class FileHelper 
{
	public static ArrayList<File> getAllFilesFromDir(File directory) 
	{
		ArrayList<File> fileList = new ArrayList<File>();

		if(directory.isDirectory()) {
			ArrayList<File> longCache = new ArrayList<File>();

			for (File i : directory.listFiles()) {
				if (i.isDirectory()) {
					System.out.println("TEST");
					if (i.listFiles() == null && i.listFiles().length == 0) {
						fileList.add(i);
					} else {
						longCache.add(i);
					}
				} else if (i.isFile()) {
					fileList.add(i);
				}
			}

			do {
				ArrayList<File> shortCache = new ArrayList<File>();
				for (File i : longCache) {
					if (i.listFiles() == null && i.listFiles().length == 0) {
						fileList.add(i);
					} else {
						for (File i1 : i.listFiles()) {
							if (i1.isFile()) {
								fileList.add(i1);
							} else {
								shortCache.add(i1);
							}
						}
					}
				}

				longCache.clear();
				longCache.addAll(shortCache);
			} 
			while (!longCache.isEmpty());

		}
		return fileList;
	}
}
