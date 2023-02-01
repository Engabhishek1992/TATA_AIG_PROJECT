package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.utility.UtileClass;

import bsh.org.objectweb.asm.Type;

public class HomePage extends TestBase{
	UtileClass util= new UtileClass();
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement clickToSearch;
	
	@FindBy(css="#nav-flyout-searchAjax [role='button']")
	List<WebElement> selectSuggestedValue;
	
	@FindBy(css="[data-component-type=s-search-result] h2 span")
	List<WebElement> searchedPoductName;
	
	@FindBy(css="#add-to-cart-button")
	WebElement clickToAddCart;
	
	@FindBy(css="#nav-cart-count")
	WebElement navToAddCart;
	
	
	public HomePage(){
		System.out.println("======="+driver);
		PageFactory.initElements(driver, this);
	}
	public void setInputToSearch(String productToSearch) throws InterruptedException{
		System.out.println(searchBox);
		searchBox.sendKeys(productToSearch);
		Thread.sleep(4000);
		util.waitTillPageLoad();
		clickToSearch.click();
	}
	public boolean getValidateSearchProduct(String productToSelect) throws InterruptedException{
		boolean result =false;
		for(WebElement productName:searchedPoductName){
			Thread.sleep(2000);
			System.out.println(productName.getText());
			if(productName.getText().contains(productToSelect)){
				result=true;
				break;
				
			}else{
				
			}
		}
		return result;
	}
	public String clickToFilterProduct() throws InterruptedException{
		String selectProduct = null;
		for(WebElement productName:searchedPoductName){
			Thread.sleep(2000);
			selectProduct=productName.getText();
			if(productName !=null){
				productName.click();
				break;
			}else{
				
			}
		}
		return selectProduct;
		
	}

		
}
