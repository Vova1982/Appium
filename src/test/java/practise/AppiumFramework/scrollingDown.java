package practise.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrollingDown extends Start{
	
	
	
	
	
@Test
public void apiDemo() throws IOException, InterruptedException {
	
	service=startServer();
			AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
						
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	   service.stop();
	}
}