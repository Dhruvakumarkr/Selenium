package DhruvAcedemy.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LanuchingTest {

	public WebDriver driver;
	
	public LandingPage LandingPage;

	public WebDriver initializeDriver() throws IOException {
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\DhruvAcedemy\\Resources\\GlobalData.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		else
		{
			System.out.println("Browser is not initialized");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		LandingPage = new LandingPage(driver);
		LandingPage.GoTo();
		return LandingPage;
	}
	
//	@BeforeTest
//	public void testStarted()
//	{
//		System.out.println("Test Execution is started...");
//	}
	
	@AfterMethod
	public void closing() throws InterruptedException
	{
		System.out.println("Test execution is Completed..Please have look in results..Closing the browser");
		Thread.sleep(1000);
		driver.quit();
	}
}
