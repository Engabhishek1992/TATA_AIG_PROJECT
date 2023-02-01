package com.amazon.qa.pages;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.utility.UtileClass;

public class ProductDetailsPage extends TestBase {

	UtileClass utile = new UtileClass();

	@FindBy(css = "#title #productTitle")
	WebElement productTitle;
	
	@FindBy(css = "#inline-twister-expanded-dimension-text-size_name")
	WebElement productSize;

	@FindBy(xpath = "//*[@class='sc-item-content-group']//following-sibling::span[2]")
	List<WebElement> productDetails;

	@FindBy(css = "#add-to-cart-button")
	WebElement addToCart;

	@FindBy(css = "#nav-cart-count")
	WebElement navigateToCart;

	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProductTitle() {
		utile.waitTillPageLoad();

		return productTitle.getText();
	}

/*	public String getProductDeatails(String productSize) {
		utile.waitTillPageLoad();
		String productSpecification = null;
		if (productDetails.size() != 0) {
			for (WebElement element : productDetails) {

				if (element.getText().equals(productSize)) {
					productSpecification = element.getText();
					break;
				}
			}
		}
		return productSpecification;
	}
*/
		public String getProductDeatails() {
		utile.waitTillPageLoad();
		
		return productSize.getText();
	}
	 
	public void addToCart() {
		utile.waitTillPageLoad();
		try {
			addToCart.isDisplayed();
			addToCart.click();
		} catch (NoSuchFieldError e) {
			e.printStackTrace();
		}
	}

	public void navToCart() {
		utile.waitTillPageLoad();
		try{
			navigateToCart.isDisplayed();
			navigateToCart.click();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
	}

}
