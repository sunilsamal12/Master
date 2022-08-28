package Selenium.testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Selenium.genericLib.BaseClass;
import Selenium.genericLib.CommonUtility;

public class AlertHandlingTest extends BaseClass {
	@Test()
	
	public void fetchAlert() {
		driver.findElement(By.xpath("//div[contains(@class,'button_settings')]")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//div[@class='i']")).click();
		driver.findElement(By.cssSelector("#name")).sendKeys("ss");
		driver.findElement(By.xpath("//input[@type='submit'] //following-sibling::input")).click();
		
		CommonUtility cu=new CommonUtility();
		String msg=cu.getAlertmsg(driver);
		System.out.println(msg);
		cu.alertAccept(driver);
}
}