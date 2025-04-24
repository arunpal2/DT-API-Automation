package Common_Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	private static Properties properties;

	static{
		

		File file = new File("C:\\Users\\ArunPal\\eclipse-workspace\\API_Automation\\resource\\API.properties");
		// File file = new File("\\resource\\API.properties");
		               
		  
			FileInputStream fileInput = null;
			try 
			{
				fileInput = new FileInputStream(file);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			properties = new Properties();
			
			//load properties file
			try 
			{
				properties.load(fileInput);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
	
	public static String getProperty(String property)
	{		
		if(property != null)
		{
			return properties.getProperty(property);	
		}
		return null;
	}
}
