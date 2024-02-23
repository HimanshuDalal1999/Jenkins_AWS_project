package executions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactorys.driverfactory;
//import driverconfig.DriverFactory;
//import driverfactorys.driverfactory;
import io.cucumber.java.After;
//import execution.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class apphooks {
	//jojoWebDriver driver;
	driverfactory df;
	WebDriver driver;

	@Before
	public void launchBrowser() throws IOException, InterruptedException 
	{
		Properties prop = new Properties();
		Thread.sleep(3000);
		String path = System.getProperty("user.dir") + "//src/test//resources//amaz.properties";
		System.out.println(path);

		
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		String MavenBrowser = System.getProperty("clibrowser");
		System.out.println("Browser Received from Maven is :"+MavenBrowser);
		
		if(MavenBrowser!=null)
		{
			BrowserName = MavenBrowser;
		}
		
		df = new driverfactory();
		driver = df.initBrowsers(BrowserName);
		driver.manage().window().maximize();
	}


	@After(order = 1)
	public void tearDown()
	{
		driver.quit();
	}

	@After(order = 2)
	public void TearDown(Scenario scenario)
	{
		boolean isFailed = scenario.isFailed();
		
		if(isFailed)
		{
			String scenarioName = scenario.getName();
			String name = scenarioName.replaceAll(" ", "_");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", name);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
