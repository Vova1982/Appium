package practise.AppiumFramework;

import org.testng.annotations.DataProvider;

public class DataProviderq {
	@DataProvider(name="InputData")
    public Object[][] getDataforField() {
		 Object[][] obj = new Object[][] {
				 {"Hello2"},{"!@#@#$#@5676"}
		 
		 };
		 return obj;
}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
