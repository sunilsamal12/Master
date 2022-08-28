package Selenium.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Selenium.genericLib.BaseClass;
import Selenium.genericLib.CommonUtility;

public class DropdownHandling extends BaseClass {
	@Test()
	public void handleDropdown() {
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Manage system settings')]/..")).click();
		WebElement dropdown=driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
		//dropdown.click();

		CommonUtility cu=new CommonUtility();
		cu.getSelectByVisibleText(dropdown,"Product");
		String text=driver.findElement(By.cssSelector(".modified")).getText();
		System.out.println(text);
	}

}
