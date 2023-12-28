package DhruvAcedemy.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// WebDriverManager.chromedriver().setup();
		String prodName = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		driver.findElement(By.id("userEmail")).sendKeys("dhkr@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dhruvad@17");
		driver.findElement(By.id("login")).click();

		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));

		for (int i = 0; i < items.size(); i++) 
		{
			String text = driver.findElements(By.cssSelector("b")).get(i).getText();

			if (text.contains(prodName)) 
			{
				driver.findElement(By.cssSelector("div[class='card-body'] button[class*='w-10']")).click();
				break;
			}
		}

//		WebElement prod = items.stream().filter(i -> i.findElement(By.cssSelector("b")).getText().equals(prodName))
//				.findFirst().orElse(null);


		driver.findElement(By.cssSelector("div[class='card-body'] button[class*='w-10']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cardProds = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cardProds.stream().anyMatch(cardP -> cardP.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
		System.out.println("Item is successfully added to cart...Proceeding to checkout");

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> autos = driver.findElements(By.cssSelector(".ta-results"));

		driver.findElement(By.xpath("//section/button[2]")).click();

		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

		String confirmMessage = driver.findElement(By.cssSelector("h1")).getText();
		Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
		System.out.println("Test is done");

	}

}
