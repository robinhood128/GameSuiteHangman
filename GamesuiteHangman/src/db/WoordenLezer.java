package db;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {
	private String pad;
	
	public WoordenLezer(String pad)
	{
		setPad(pad);
	}
	
	private void setPad(String pad)
	{
		this.pad = pad;
	}
	
	public ArrayList<String> leesWoorden()
	{
		File woordenFile = new File(pad);
		ArrayList<String> woorden = new ArrayList<String>();
		
		try
		{
			Scanner scannerFile = new Scanner(woordenFile);
			
			while(scannerFile.hasNextLine())
			{
				woorden.add(scannerFile.nextLine());
			}
			
			scannerFile.close();
		}
		
		catch (Exception e)
		{
			throw new DBException("Fout bij inlezen.");
		}
		
		return woorden;
	}
}
