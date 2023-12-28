package DhruvAcedemy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import DhruvAcedemy.BaseTest.LanuchingTest;
import PageObjects.CartPage;
import PageObjects.ProductsCatolog;

public class ErrorValidationTest extends LanuchingTest 
   {


	@Test
	public void logintErrorValidation() throws Exception {
		String prodName = "ZARA COAT 3";
		ProductsCatolog productcat = LandingPage.loginapp("dhshjsr@gmail.com", "Dhruvad@17");
		String mesg=LandingPage.getErrorMessage();
		
		Assert.assertEquals(mesg,"Incorrect email or password.");


	}
	
	@Test
	public void productErrorValidation() throws Exception {
		String prodName = "ZARA COAT 3";
		ProductsCatolog productcat = LandingPage.loginapp("dhkr@gmail.com", "Dhruvad@17");

		List<WebElement> products = productcat.getProducts();
		productcat.addProducttoCart(prodName);
		CartPage cart = productcat.goToCartPage();

		Boolean match = cart.verifyProductDisplay("ZARA COAT 33");
		Assert.assertTrue(match);


	}

}
