package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import stepDefinitions.Steps;

public class ConfigFileReader {

	static Properties prop = new Properties();

	public static void ConfigFile() throws IOException{
		
		String projectpath = System.getProperty("user.dir");
		FileInputStream reader =  new FileInputStream(projectpath+"\\src\\test\\java\\utilities\\Configuration.properties");	
		prop.load(reader);
		Steps.browsername = prop.getProperty("Browser");

	}	

	public static String applicationurl(){
		String appurl = prop.getProperty("Url");
		return appurl;
	}
	
	public static String getchromepath() {
		String chromepath = prop.getProperty("Chromepath");
		return chromepath;
	}
	
	public static String getedgepath() {
		String edgepath = prop.getProperty("Edgepath");
		return edgepath;
	}



}


