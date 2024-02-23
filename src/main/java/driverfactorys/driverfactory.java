package driverfactorys;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class driverfactory {

	static  WebDriver driver;

	public WebDriver initBrowsers(String browsername) throws MalformedURLException
	{
		Capabilities Capable;
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			Capable = new ChromeOptions();
		}
		else 
		{
			Capable = new FirefoxOptions();
		}
		
		driver = new RemoteWebDriver(new URL("http://192.168.141.31:4444/wd/hub"), Capable);

		return driver;
	}
	public static WebDriver getDriver()
	{
		return driver;
	}
	
}



