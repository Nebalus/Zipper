package de.nebalus.zipper;

public enum ZipMode 
{
	ZIP("zip"),
	UNZIP("unzip"),
	UNDEFINED();
	
	private final String[] aliases;
	
	ZipMode(String... aliases)
	{
		this.aliases = aliases;
	}
	
	public String[] getAliases()
	{
		return aliases;
	}
	
	public static ZipMode getFromAlias(String selAlias)
	{	
		for(ZipMode zipMode : ZipMode.values())
		{
			for(String alias : zipMode.aliases)
			{
				if(alias.equalsIgnoreCase(selAlias))
				{
					return zipMode;
				}
			}
		}	
		return UNDEFINED;
	}
}
