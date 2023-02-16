package de.nebalus.zipper.utils;

import java.io.File;
import java.util.ArrayList;

public class FileHelper 
{
	public static ArrayList<File> getAllFilesFromDir(File directory) 
	{
		ArrayList<File> fileList = new ArrayList<File>();

		if(directory.isDirectory()) 
		{
			ArrayList<File> longTermCache = new ArrayList<File>();			
			longTermCache.add(directory);

			do 
			{
				ArrayList<File> shortTermCache = new ArrayList<File>();
				for (File i : longTermCache) 
				{
					if (i.isFile() || i.listFiles() == null || i.listFiles().length == 0) 
					{
						fileList.add(i);
					} 
					else 
					{
						for (File i1 : i.listFiles())
						{
							if (i1.isFile()) 
							{
								fileList.add(i1);
							} 
							else 
							{
								shortTermCache.add(i1);
							}
						}
					}
				}

				longTermCache = shortTermCache;
			} 
			while (!longTermCache.isEmpty());

		}
		return fileList;
	}
}
