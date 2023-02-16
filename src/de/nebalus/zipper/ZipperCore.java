package de.nebalus.zipper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import de.nebalus.zipper.configuration.Config;
import de.nebalus.zipper.modules.ZipModule;

public class ZipperCore 
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
		System.out.println("BUILD: " + Config.BUILD_VERSION);
		System.out.println("BUILD-DATE: " + Config.BUILD_DATE);
		System.out.println("AUTHOR: " + Config.AUTHOR_NAME);
		System.out.println("GITHUB-REPO: " + Config.GITHUB_REPO_LINK);
		System.out.println(" ");
		System.out.println("Checking the Parameters...");
		
		//Init default variablen
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
		
		System.out.println("MODE: " + zipMode.name());
		System.out.println("FROMPATH: " + inputFile.getAbsolutePath());
		System.out.println("TOPATH: " + outputFile.getAbsolutePath() + (outputFile.getParentFile().exists() ? "" : " (The directory '" + outputFile.getParentFile().getAbsolutePath() + "' will be created)") );
		System.out.println(" ");
		System.out.println("The procces will start in " + Config.MODE_START_DELAY + " seconds...");
		
		TimeUnit.SECONDS.sleep(Config.MODE_START_DELAY);
	
		Thread instance = new ZipModule(inputFile, outputFile);
		instance.run();
		//ZipLib.zip(inputFile, outputFile);
	}
	
	
}
