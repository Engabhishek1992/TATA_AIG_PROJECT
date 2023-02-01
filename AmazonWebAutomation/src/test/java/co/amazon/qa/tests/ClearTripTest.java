package co.amazon.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;

public class ClearTripTest extends TestBase{
	
	public ClearTripTest(){
		super();
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@BeforeClass
	public void nevigateUrl(){
		TestBase.intitialzation();
	}
	
	@Test(description="To validate the search Product at amazon site ")
	public void tc_01() throws InterruptedException{
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div/div[3]/button")).click();
		List<WebElement> flightDetails=driver.findElements(By.xpath("//*[@class='makeFlex simpleow']/div/div/p[2]"));
		List<WebElement> price=driver.findElements(By.xpath("//*[@class='makeFlex simpleow']/div[4]/div/div/p"));

		String FlightName=null;
		String Flightprice=null;
		int count =0;
		for(int i=0 ;i<flightDetails.size() ;i++){
			FlightName=flightDetails.get(i).getText();
			Flightprice=price.get(i).getText();
			System.out.println("Flight Name Is "+ FlightName+ "Price is "+Flightprice);

			if(count==2){
			  break;
			}
			count++;
		}
	}


}
