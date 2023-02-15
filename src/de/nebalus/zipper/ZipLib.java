package de.nebalus.zipper;

import java.io.File;
import java.util.ArrayList;

public class ZipLib 
{
	public static void zip(File inputFile, File outputFile)
	{
		final ArrayList<File> fileList = new ArrayList<>();
		
		System.out.println("Looking up the file structure...");
		
		if(inputFile.isDirectory())
		{
			fileList.addAll(FileHelper.getAllFilesFromDir(inputFile));
		}
		else
		{
			fileList.add(inputFile);
		}
		
		System.out.println(fileList.size() + " files found!");
	}
}
