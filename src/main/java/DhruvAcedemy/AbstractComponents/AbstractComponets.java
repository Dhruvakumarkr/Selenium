package DhruvAcedemy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPage;
import PageObjects.OrderPage;

public class AbstractComponets {

	WebDriver driver;
	 public AbstractComponets(WebDriver driver) {

	       this.driver=driver;
			PageFactory.initElements(driver, this);

	 }
	 @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
		WebElement cartheader;

	 @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
		WebElement orderHeader;
	 
	public void waitingForElement(By findBy) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
			
		 
	 }
	
	public void waitingForWebElementAppear(WebElement findBy) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			wait.until(ExpectedConditions.visibilityOf(findBy));
			
		 
	 }
	
	public void waitingForElementinvisble(WebElement ele) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			wait.until(ExpectedConditions.invisibilityOf(ele));
		 
	 }
	
	public CartPage goToCartPage()
	{
		cartheader.click();
		CartPage cart = new CartPage(driver);
        return cart;
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage OrderPage = new OrderPage(driver);
        return OrderPage;
	}
	
}
