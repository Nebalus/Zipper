package de.nebalus.zipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import de.nebalus.zipper.utils.FileHelper;

public class ZipLib 
{
	public static void zip(File inputFile, File outputFile) throws IOException
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
		System.out.println("Starting the ZIP procces");
		
		FileOutputStream fos = new FileOutputStream(outputFile);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
		
        int counter = 1;
        
        int subpath = inputFile.getAbsolutePath().length() + 1;
        
		for(File file : fileList)
		{
			if(file.isDirectory() && file.listFiles() == null)
			{
				System.out.println(counter + "/" + fileList.size() + " SKIPING: " + file.getAbsolutePath());
				continue;
			}
			
			System.out.println(counter + "/" + fileList.size() + " ZIPPING: " + file.getAbsolutePath());
			
			FileInputStream fis = new FileInputStream(file);
			ZipEntry zipEntry = new ZipEntry(file.getAbsolutePath().substring(subpath));
			zipOut.putNextEntry(zipEntry);
	        byte[] bytes = new byte[1024];
	        int length;
	        while ((length = fis.read(bytes)) >= 0) 
	        {
	            zipOut.write(bytes, 0, length);
	        }
	        fis.close();
	        
	        counter++;
		}
		
		zipOut.close();
		fos.close();
	}
}
