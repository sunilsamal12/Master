package Selenium.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot ts=(TakesScreenshot)BaseClass.Listenerdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./failedTC/f1.png");
		try {
			FileUtils.copyFile(src, trg);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
