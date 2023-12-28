package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DhruvAcedemy.AbstractComponents.AbstractComponets;

public class ProductsCatolog extends AbstractComponets {

	WebDriver driver;

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector("div[class='card-body'] button[class*='w-10']");
	By toastmessage = By.cssSelector("#toast-container");

	public ProductsCatolog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProducts() {
		waitingForElement(productsBy);
		return products;

	}

	public WebElement getproductName(String prodName) {

		WebElement prod = getProducts().stream()
				.filter(i -> i.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);
		return prod;

	}

	public void addProducttoCart(String prodName) {

		WebElement prod = getproductName(prodName);
		waitingForElement(addToCart);
		prod.findElement(addToCart).click();
		// waitingForElement(toastmessage);
		waitingForElementinvisble(spinner);

	}

}
