package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SearchResultPage extends TestBase{
   
	@FindBy(css="#low-price")
	WebElement setLowPrice ;
	
//	@FindBy(id="high-price")
//	WebElement setMaxPrice ;
	
	@FindBy (id="high-price")
	WebElement setMaxPrice ;

	@FindBy(css="#a-autoid-1 [type='submit']")
	WebElement clickToGo ;
	
	@FindBy(xpath="//*[@id='filters']/ul[5]/li/span/a")
	List<WebElement> setColor ;
	
	public SearchResultPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void setLowPrice(String lowPrice) throws InterruptedException{
		Thread.sleep(1000);
		setLowPrice.clear();
		setLowPrice.sendKeys(lowPrice);
	}
	
	public void setMaxPrice(String highPrice) throws InterruptedException{
		setMaxPrice.clear();
		Thread.sleep(1000);
		setMaxPrice.sendKeys(highPrice);
	}
	
	// set the color and return rgba value 
	public String  setColour() throws InterruptedException{
		System.out.println("Size of list "+setColor.size());
		String selectedColor = null;
		if(setColor.size()==0){
			 return null;
		}else{
		for(WebElement color:setColor){
			Thread.sleep(1000);
			selectedColor =color.getCssValue("color");
			color.click();
			break;
		  }
		}
		return selectedColor;
	}

	public void ClickToFilter() throws InterruptedException{
		Thread.sleep(1000);
		clickToGo.click();
	}	

}
