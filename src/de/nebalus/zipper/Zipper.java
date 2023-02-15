package de.nebalus.zipper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Zipper 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.out.println("::::::::: :::::::::::  :::::::::  :::::::::  :::::::::: :::::::::");
		System.out.println("    :+:       :+:     :+:    :+: :+:    :+: :+:        :+:    :+: ");
		System.out.println("   +:+        +:+     +:+    +:+ +:+    +:+ +:+        +:+    +:+");
		System.out.println("  +#+         +#+     +#++:++#+  +#++:++#+  +#++:++#   +#++:++#:");
		System.out.println(" +#+          +#+     +#+        +#+        +#+        +#+    +#+");
		System.out.println("#+#           #+#     #+#        #+#        #+#        #+#    #+#");
		System.out.println("######### ########### ###        ###        ########## ###    ###");
		System.out.println(" ");
		
		ZipMode zipMode = ZipMode.UNDEFINED;
		File inputFile = null;
		File outputFile = null;
		
		for(int i = 0; i < args.length; i++)
		{
			final String[] arg = args[i].split("=");
			
			if(arg.length != 2)
				continue;
			
			switch(arg[0].toLowerCase())
			{
				case "mode":
					zipMode = ZipMode.getFromAlias(arg[1]);
					break;
					
				case "from":
					final File demoInputFile = new File(arg[1]);
					if(!demoInputFile.exists())
					{
						System.err.println("The 'from' file does not exist!");
						continue;
					}
					
					inputFile = demoInputFile;
					break;
					
				case "to":
					outputFile = new File(arg[1]);
					break;
			}
		}
		
		if(zipMode == ZipMode.UNDEFINED || inputFile == null || outputFile == null)
		{
			System.err.println("Please use the right syntax... needed arguments (from, to, mode)");
			return;
		}

		System.out.println("BUILD: 0.1 BETA");
		System.out.println("AUTHOR: Nebalus");
		System.out.println("MODE: " + zipMode.name());
		System.out.println("FROMPATH: " + inputFile.getAbsolutePath());
		System.out.println("TOPATH: " + outputFile.getAbsolutePath() + (outputFile.getParentFile().exists() ? "" : " (The directory '" + outputFile.getParentFile().getAbsolutePath() + "' will be created)") );
		System.out.println(" ");
		System.out.println("The procces will start in 10 seconds...");
		
		TimeUnit.SECONDS.sleep(10);
		
		ZipLib.zip(inputFile, outputFile);
	}
}
