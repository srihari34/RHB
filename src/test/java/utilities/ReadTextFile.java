package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
	
	public int getRowCount() throws IOException
	{
		String path = System.getProperty("user.dir");
		FileReader fis  =  new FileReader(path + "\\src\\test\\resources\\utilities\\Flash\\FLASH_CCSS_NOT_CA_ASB_20260224.txt");
		BufferedReader br = new BufferedReader(fis);
		System.out.println(br.lines());
		String line;
		int count=0;
	    while((line = br.readLine()) != null)
	    {
	    	if(line.startsWith("01"))
	    	{
	    	count++;
	    	//System.out.println(line);
	    	}
	    }
	    //System.out.println(count);
	    return count;

	}
	
	
}
