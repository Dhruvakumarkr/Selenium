package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DhruvAcedemy.AbstractComponents.AbstractComponets;

public class ConfirmationPage extends AbstractComponets {
	WebDriver driver;
	
	@FindBy(css = "h1")
	WebElement confirmText;
	
	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public String GetConfirmationMessage()
	{
		return confirmText.getText();
		 
	}
	
	
	
}
