package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

public class genericMethods {
	
	static WebDriver dr;
	
	public static String getPropertyValue(String propFilePath,String key) throws FileNotFoundException, IOException
	{
		String value="";
		try {
		Properties p =new Properties();
		p.load(new FileInputStream(propFilePath));
		value=p.getProperty(key);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return value;
	}
	
	public static void getScreenShot(String Folder ,String FileName) throws IOException
	{
		Date d= new Date();
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		String date=format.format(d);
		
		String Destpath= Folder + FileName + date + ".png" ;
		
		TakesScreenshot ts =(TakesScreenshot) dr;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile =new File(Destpath);	
		FileUtils.copyFile(srcFile, destFile);	
	}
	
	@DataProvider(name="dataSearch")
	public static Object[][] getdata()
	{
		return new Object[][]
				{
			         {  "Apple" , "1" },
			         {  "Orange" ,"2" }               
				};         

	}

	
	
	public void connectToRemoteSystem() throws MalformedURLException
	{
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setBrowserName("Chrome");
		
		URL url =new URL(null);	
		dr=new RemoteWebDriver(url ,dc);
		
		dr.get("abc");
		
	}
}



















