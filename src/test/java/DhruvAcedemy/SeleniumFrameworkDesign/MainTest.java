package DhruvAcedemy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentTest;

import DhruvAcedemy.BaseTest.LanuchingTest;
import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LandingPage;
import PageObjects.OrderPage;
import PageObjects.ProductsCatolog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainTest extends LanuchingTest
   {
	public static ExtentTest test;
	String prodName = "ZARA COAT 3";
    String testCaseName="Test";


	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws Exception {
		ProductsCatolog productcat = LandingPage.loginapp(input.get("email"), input.get("password"));

		List<WebElement> products = productcat.getProducts();
		productcat.addProducttoCart(input.get("prodName"));
		CartPage cart = productcat.goToCartPage();

		Boolean match = cart.verifyProductDisplay(input.get("prodName"));
		Assert.assertTrue(match);
		System.out.println("Item is successfully added to cart...Proceeding to checkout");
		CheckOutPage checkOut = cart.GoToCheckOut();
		checkOut.selectCountry("india");
		ConfirmationPage confirmMessage = checkOut.submitOrder();
		String validtext = confirmMessage.GetConfirmationMessage();

		Assert.assertEquals(validtext, "THANKYOU FOR THE ORDER.");
        
	}

	@Test(dependsOnMethods = "submitOrder")
	public void ordersItemsValidation()
	{
		ProductsCatolog productcat = LandingPage.loginapp("dhkr@gmail.com", "Dhruvad@17");
		OrderPage OrderPage=productcat.goToOrderPage();
		Boolean res=OrderPage.verifyOrderDisplay(prodName);
		Assert.assertTrue(res);
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		 HashMap<String, String> map1=new HashMap<String, String>();
		 map1.put("email", "dhkr@gmail.com");
		 map1.put("password", "Dhruvad@17");
		 map1.put("prodName", "ZARA COAT 3");
		 
		 HashMap<String, String> map2=new HashMap<String, String>();
		 map2.put("email", "krd@gmail.com");
		 map2.put("password", "Samarthd@17");
		 map2.put("prodName", "ADIDAS ORIGINAL");

	     return new Object[][] {{map1},{map2}};
	  
	}

	
	public String getScreenshot(String testCaseName, WebDriver driver) throws Exception
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File src= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png");
		FileUtils.copyFile(src,file );
		return System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png";
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//	     return new Object[][] {{"dhkr@gmail.com","Dhruvad@17","ZARA COAT 3"},{"krd@gmail.com","Samarthd@17","ADIDAS ORIGINAL"}};
//	  
//		
//	}
	
}
