package practise.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Start {
	
	
	
	public static AppiumDriverLocalService service;
	
	public static AndroidDriver<AndroidElement>driver;
	
	public AppiumDriverLocalService startServer()
	{
		boolean flag=checkIfServerIsRunning(4723);
		if(!flag) {
	
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service; 

	
	}
	
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
			
		}catch(IOException e) {
			isServerRunning = true;
		}finally {
			serverSocket =null;
		}
		return isServerRunning;
	} 
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\localadmin\\eclipse-MavenProjectFromScreatchTwo\\AppiumFramework\\src\\main\\java\\status\\StartEmulator.bat");
		Thread.sleep(6000);
	}
	
	
	
	
	
	
	
	
	 public static AndroidDriver<AndroidElement> Capabilities(String appName) throws  IOException, InterruptedException{ 
			
		 
		 FileInputStream fils=new FileInputStream("C:\\Users\\localadmin\\eclipse-MavenProjectFromScreatchTwo\\AppiumFramework\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		 		  Properties prop = new Properties();
		 		  prop.load(fils);
		 		 prop.get(appName);
		  
	
	  
	
	File appDir= new File("src");
	File app = new File(appDir, (String) prop.get(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String device = (String) prop.get("device");
		
		if(device.contains("emulator")) {
			startEmulator();
		}
		
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		 driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	return driver;

}
	 public static void getScreenshot(String s) throws IOException {
		File scrfile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("C:\\Users\\localadmin\\Pictures\\Screenshots\\"+s+".png"));
		 
	 }


	    
}