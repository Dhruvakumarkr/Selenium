package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DhruvAcedemy.AbstractComponents.AbstractComponets;

public class OrderPage extends AbstractComponets {
	WebDriver driver;
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(cardP -> cardP.getText().equalsIgnoreCase("ZARA COAT 3"));
		return match;
	}

}
