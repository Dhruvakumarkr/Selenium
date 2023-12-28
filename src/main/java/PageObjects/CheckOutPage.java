package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DhruvAcedemy.AbstractComponents.AbstractComponets;

public class CheckOutPage extends AbstractComponets {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//section/button[2]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitingForElement(results);
		selectCountry.click();
		
	}
	

	public ConfirmationPage submitOrder()
	{
		submit.click();
		ConfirmationPage confirmMessage = new ConfirmationPage(driver);
		return confirmMessage;
		
	}
	
	
	
	
	
	
}
