package com.amazon.qa.utility;

import java.util.List;
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
	
	public Timeouts waitTillPageLoad(){
		
		return driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public void getWindowHandle(List<String> list,String parentWindowId ) throws InterruptedException{
	       for(String windowId:list){
	    	   if(!windowId.equals(parentWindowId)){
	    		   Thread.sleep(2000);
	    		   driver.switchTo().window(windowId);
	 
	    		   break;
	    	   }
	       }

		
	}


	
}
