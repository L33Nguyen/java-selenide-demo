package utils.helper;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class DriverFactory {
	
	 public static void initDriver(String browser) {
		Configuration.browser = System.getProperty("browser", browser);
		
	 }
	 
	 public static void quitDriver() {
	        closeWebDriver();
	}
	 
}
