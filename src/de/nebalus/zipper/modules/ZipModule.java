package de.nebalus.zipper.modules;

import java.io.File;

public class ZipModule extends Thread
{
	private final File inputFile;
	private final File outputFile;
	
	public ZipModule(File inputFile, File outputFile)
	{
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}
	
	@Override
	public final void run()
	{
		System.out.println("Test");
	}
}
