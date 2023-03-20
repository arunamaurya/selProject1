package Generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest implements IAutoConstant{
	
	static
	{
		System.setProperty(chromeKey, chromePath);	
	}
	
	WebDriver dr= new ChromeDriver();
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException
	{
		String url=genericMethods.getPropertyValue(config_path, "URL");	
		dr.get("https://www.guru99.com/parameterization-using-xml-and-dataproviders-selenium.html");	
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void closeApp(ITestResult test)
	{
		int status =test.getStatus();
		if(status==1)
		{
			Reporter.log(test.getName() + "is passed" ,true);
		}
		else
		{
			Reporter.log(test.getName() + "is failed" ,true);
		}
		//I am doing it to check
		dr.close();
	}
	
	
	
	

}
