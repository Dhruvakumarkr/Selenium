package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DhruvAcedemy.AbstractComponents.AbstractComponets;

public class LandingPage extends AbstractComponets {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="userEmail")
	WebElement usermail;
	
	@FindBy(id ="userPassword")
	WebElement userPass;
	
	@FindBy(id = "login")
	WebElement userLogin;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductsCatolog loginapp(String email, String Password)
	{
		usermail.sendKeys(email);
		userPass.sendKeys(Password);
		userLogin.click();
		ProductsCatolog productcat = new ProductsCatolog(driver);
        return productcat;
	}
	
	public String getErrorMessage()
	{
		waitingForWebElementAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void GoTo() 
	{
		driver.get("https://rahulshettyacademy.com/client");

	}
	

}
