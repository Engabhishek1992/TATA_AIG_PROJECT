package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.utility.UtileClass;

public class CreateAccountPage extends TestBase{
	UtileClass utile= new UtileClass();
	Select select;
	
	@FindBy(xpath="//*[@type='email']")
	WebElement enterMailId;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement clickToSubmit;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement clickToSubmi;

	
	@FindBy(css="#add-new-address-popover-link")
	WebElement addNewAddress;
	
	@FindBy(css="#address-ui-widgets-countryCode-dropdown-nativeId")
	WebElement selectCountry;
	
	@FindBy(css="#address-ui-widgets-enterAddressFullName")
	WebElement fullName;
	
	@FindBy(css="#address-ui-widgets-enterAddressPhoneNumber")
	WebElement mobileNum;

	@FindBy(css="#address-ui-widgets-enterAddressPostalCode")
	WebElement postalCode;

	@FindBy(css="#address-ui-widgets-enterAddressLine1")
	WebElement enterAddressLine1;
	
	@FindBy(css="#address-ui-widgets-enterAddressLine2")
	WebElement enterAddressLine2;

	@FindBy(css="#address-ui-widgets-landmark")
	WebElement enterAddressLine3;
	
	@FindBy(css="#address-ui-widgets-enterAddressCity")
	WebElement enterAddressCity;
	
	@FindBy(css="#address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
	WebElement selectState;
	
	@FindBy(xpath="//*[@id='address-ui-widgets-enterAddressFormContainer']/div[9]/div[4]/span/select")
	WebElement selectAddressType;

	public CreateAccountPage(){
		PageFactory.initElements(driver, this);
	}
    public void clickAddNewAddress(){
    	utile.waitTillPageLoad();
    	addNewAddress.click();
    }
	public void selectCounty(String inputCountry){
		select = new Select(selectCountry);
		select.selectByValue(inputCountry);
	}

	public void fullName(String inputFullName){
		utile.waitTillPageLoad();
		fullName.sendKeys(inputFullName);
	}
	public void fillMobile(String inputMob){
		utile.waitTillPageLoad();
		mobileNum.sendKeys(inputMob);
	}
	public void fillPostal(String inputPostal){
		utile.waitTillPageLoad();
		postalCode.sendKeys(inputPostal);
	}
	public void addressLine1(String inputAddress1){
		utile.waitTillPageLoad();
		enterAddressLine1.sendKeys(inputAddress1);
	}
	public void addressLine2(String inputAddress2){
		utile.waitTillPageLoad();
		enterAddressLine2.sendKeys(inputAddress2);
	}
	public void addressLine3(String inputAddress3){
		utile.waitTillPageLoad();
		enterAddressLine3.sendKeys(inputAddress3);
	}
	public void addressCity(String inputAddressCity){
		utile.waitTillPageLoad();
		enterAddressCity.sendKeys(inputAddressCity);
	}
	public void addressState(String inputAddressState){
		utile.waitTillPageLoad();
		select=new Select(selectState);
		select.selectByVisibleText(inputAddressState);
	}
	
	public void addressType(String inputAddressType){
		utile.waitTillPageLoad();
		select=new Select(selectAddressType);
		select.selectByVisibleText(inputAddressType);
	}




}
