package com.amazon.qa.utility;

import java.util.concurrent.TimeUnit;

import org.apache.poi.util.Units;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.TestBase;

import dev.failsafe.Timeout;


public class UtileClass extends TestBase{
	static long PAGE_LOAD_TIMEOUT=10;
	static long IMPLICITE_WAIT=10;
//	WebDriverWait wait = new WebDriverWait(driver, 20) ;
	
	
//	public void waitTillWebElementLoad(WebElement element){
//		
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
//	
	public Timeouts waitTillPageLoad(){
		
		return driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
	}
	
//	public void fluewentWait(WebElement element){
//		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(5,TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);
//		
//	}


	
}
