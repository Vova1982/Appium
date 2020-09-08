package practise.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Check_amount_money  extends Start {
	@BeforeTest
	public void KillAllNode() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(4000);
	}
	
	@Test
public void totalValudation() throws IOException, InterruptedException {
		service=startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("orinallApp");
	

		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		     driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

		     driver.hideKeyboard();

		     driver.findElement(By.xpath("//*[@text='Female']")).click();

		     driver.findElement(By.id("android:id/text1")).click();

		     

		     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

		  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

		     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

		     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		     

		     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();

		    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(4000);

		String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
//ydalit znak $
		amount1 =amount1.substring(1);
		//convert from string to double
		double amount1Value=Double.parseDouble(amount1);
		
		String amount2= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		//covert from string to double
		amount2 =amount2.substring(1);
		double amount2Value=Double.parseDouble(amount2);
		
		
		//Suma
		double totalOfProducts=amount1Value+amount2Value;
		System.out.println(totalOfProducts+"sum of products");
		
		String total_amount= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total_amount =total_amount.substring(1);
		double totalValue=Double.parseDouble(total_amount);
		System.out.println(totalValue+"Total value of products");
		Assert.assertEquals(totalOfProducts, totalValue);
		service.stop();
		
		

	
	
	
	
	
	
	}
}
