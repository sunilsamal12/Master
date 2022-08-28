package Selenium.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Selenium.elementRepository.LoginLocators;

public class BaseClass {
	public WebDriver driver;
	protected DataUtility du=new DataUtility();
	static WebDriver Listenerdriver;
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		    Listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	//@Parameters({"username","password"})
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException {
		driver.get(du.getDatafromProperties("URL"));
		//driver.findElement(By.className("textField")).sendKeys(du.getDatafromProperties("username"));
		//driver.findElement(By.name("pwd")).sendKeys(du.getDatafromProperties("password"));
		//driver.findElement(By.className("initial")).click();
	    //driver.findElement(By.id("container_tasks")).click();
		LoginLocators ll=new LoginLocators(driver);
		ll.loginApp(du.getDatafromProperties("username"),du.getDatafromProperties("password"));
	}
	@AfterMethod(alwaysRun=true)
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}

}
