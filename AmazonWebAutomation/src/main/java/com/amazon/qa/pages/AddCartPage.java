package com.amazon.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.utility.UtileClass;

public class AddCartPage extends TestBase {

	UtileClass utile = new UtileClass();

	@FindBy(css = "#proceed-to-checkout-action")
	WebElement proceedToCheckOut;

	@FindBy(xpath = "//input[@type='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement conntine;

	@FindBy(xpath = "//*[@type='password']")
	WebElement password;
	
	@FindBy(css = "#signInSubmit")
	WebElement clickSign;

	public AddCartPage() {

		PageFactory.initElements(driver, this);
	}

	public void proceedToCheckOut() {
		utile.waitTillPageLoad();
		proceedToCheckOut.click();
	}

	public void enterEmail(String email, String inpassword) throws InterruptedException {

		enterEmail.sendKeys(email);
		;
		Thread.sleep(1000);
		conntine.click();
		Thread.sleep(1000);
		password.sendKeys(inpassword);
		clickSign.click();
		
	}

	public String getProductName(String productName) {

		try {
			String product = driver
					.findElement(By.xpath(
							"//span[@class='a-truncate-full a-offscreen'][contains(text(),'" + productName + "')]"))
					.getText();
			return product;

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}

	}

}
