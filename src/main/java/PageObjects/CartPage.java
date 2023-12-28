package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DhruvAcedemy.AbstractComponents.AbstractComponets;

public class CartPage extends AbstractComponets {

	WebDriver driver;

	@FindBy(css = ".cartSection h3")
	List<WebElement> cardProds;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement cardCheckOut;

	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public Boolean verifyProductDisplay(String productName) 
	{
		Boolean match = cardProds.stream().anyMatch(cardP -> cardP.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckOutPage GoToCheckOut() 
	{
		cardCheckOut.click();
		CheckOutPage cehckOut= new CheckOutPage(driver);
		return cehckOut;
		
	}

}
