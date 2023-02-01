package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.utility.UtileClass;

public class ProductDetailsPage extends TestBase {

	UtileClass utile = new UtileClass();
	Actions action = new Actions(driver);
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

	public String getProductDeatails() {
		utile.waitTillPageLoad();

		return productSize.getText();
	}

	public void addToCart() {
		utile.waitTillPageLoad();
		try {
			if (addToCart.isDisplayed())
				;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
			addToCart.click();

		} catch (NoSuchFieldError e) {
			e.printStackTrace();
		}
	}

	public void navToCart() throws InterruptedException {
		utile.waitTillPageLoad();
		try {
			Thread.sleep(1000);
			if (navigateToCart.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", navigateToCart);
				navigateToCart.click();
			} else {
				driver.switchTo().frame(1);
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("#attach-sidesheet-checkout-button")).click();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

}
