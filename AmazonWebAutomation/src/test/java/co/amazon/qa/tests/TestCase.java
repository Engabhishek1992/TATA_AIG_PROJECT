package co.amazon.qa.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AddCartPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductDetailsPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.utility.UtileClass;

public class TestCase extends TestBase{
	
	public TestCase(){
		super();
	}
	HomePage homePage;
	ProductDetailsPage productDetaislPage;
	SearchResultPage searchPage;
	AddCartPage addTocartPage;
	UtileClass util=new UtileClass();
	@BeforeClass
	public void nevigateUrl(){
		logger =report.createTest("Naviaget the Amazon url");
		TestBase.intitialzation();
		logger =report.createTest("Url nevigated successfully");
		homePage=new  HomePage();
		productDetaislPage=new ProductDetailsPage();
		searchPage =new SearchResultPage();
		addTocartPage=new AddCartPage();
		
		String titleOfPage=driver.getTitle();
		System.out.println(titleOfPage);
		Assert.assertEquals(titleOfPage, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		logger =report.createTest("Title of page successfully validated..");
	}
	
	@Test(description="To validate the search Product at amazon site ")
	public void tc_01() throws InterruptedException{
		logger =report.createTest("To validate the search Product at amazon site");
		homePage.setInputToSearch("Samsung Galaxy");
		boolean result=homePage.getValidateSearchProduct("Samsung Galaxy");
		Assert.assertTrue(result);
		logger =report.createTest("Search product get validated successfully..");
		Thread.sleep(2000);
		
	}
	String productDetails;
	@Test(description="To validate the search Product after adding price filter ")
	public void tc_02() throws InterruptedException {
//		homePage.setInputToSearch("Samsung Galaxy S20 FE 5G");
		logger =report.createTest("To validate the search Product after adding price filter");
		searchPage.setLowPrice("25600");
		logger =report.createTest("Set the min price ");
		searchPage.setMaxPrice("54000");
		searchPage.ClickToFilter();
		logger =report.createTest("Set the max price ");
		String color =searchPage.setColour();
		logger =report.createTest("Set the color");		
		productDetails=homePage.clickToFilterProduct();
        logger =report.createTest("Navigated to successfully ..");
		
	}
		
	
	@Test(enabled=true,description="Add product to cart and validate color and price ")
	public void tc_03() throws InterruptedException {
        String ParentWindowId =driver.getWindowHandle();
        Set<String> childWindowId =driver.getWindowHandles();
        List<String> list= new ArrayList<String>(childWindowId);
        util.getWindowHandle(list,ParentWindowId);
		String productName =productDetaislPage.getProductTitle();
		System.out.println("Product name is "+productName+"====="+productDetails);
		Assert.assertTrue(productName.contains(productDetails));
		productDetaislPage.addToCart();	
		productDetaislPage.navToCart();
		
	}
	
	@Test(description="Checkout the product and fill the form")
	public void tc_05() throws InterruptedException {
        //addTocartPage.proceedToCheckOut();
        addTocartPage.enterEmail("8660803233","Abhishel@1234");
		
	}



	@AfterClass
	public void closeBrowser(){
		driver.close();
	}

}
