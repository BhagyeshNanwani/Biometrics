package Sample;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Biometrics {
	
	public static String userName = "BROWSERSTACK_USERNAME";
	public static String accessKey = "BROWSERSTACK_ACCESSKEY";
	public static AndroidDriver<AndroidElement> driver;
	public static String Biometric_Script = "browserstack_executor: {\"action\": \"biometric\", \"arguments\": {\"biometricMatch\":\"pass\"}}";
		
		
		@Before
		public void setup() throws MalformedURLException, InterruptedException  {
		DesiredCapabilities caps = new DesiredCapabilities();

	    caps.setCapability("device", "Samsung Galaxy S21 Plus");
	    caps.setCapability("os_version", "11.0");
	    caps.setCapability("project", "Biometrics Demo");
	    caps.setCapability("build", "Biometrics");
	    caps.setCapability("name", "Biometric Session");
	    caps.setCapability("app", "APP_URL");
	    caps.setCapability("browserstack.enableBiometric", "true");
	    
	    //Creating Driver Instance
	    driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
		
		}
		
		
		@Test
		public void main() throws InterruptedException {
	    
	    MobileElement el1 = (MobileElement) driver.findElementById("com.an.biometric.sample:id/btn_authenticate");
	    el1.click();
	    
	    //For Biometric Authentication
	    driver.executeScript(String.format(Biometric_Script));
	    Thread.sleep(15000);
	    
		}
		

		@After
	    public void tearDown() {
	    driver.quit();
	    }

	
}
