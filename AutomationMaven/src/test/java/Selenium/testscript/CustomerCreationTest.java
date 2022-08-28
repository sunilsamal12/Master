package Selenium.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Selenium.genericLib.BaseClass;
import Selenium.genericLib.CommonUtility;
import Selenium.genericLib.DataUtility;
@Listeners(Selenium.genericLib.ListenerImplementation.class)
public class CustomerCreationTest extends BaseClass {
	@Test
	public  void createCustomer() throws IOException {
		
		CommonUtility cu=new CommonUtility();
		int num=cu.getRandom();
	    driver.findElement(By.id("container_tasks")).click();
        driver.findElement(By.className("plusIcon")).click();
     
       driver.findElement(By.cssSelector(".item.createNewCustomer")).click();
       driver.findElement(By.xpath("//input[contains(@class,'inputNameField')]")).sendKeys(du.getDatafromExcelsheet("Sheet1",0,0)+num);
       driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
       //Reporter.log("customer created",true);
	}
	
		
		
		
	


}
