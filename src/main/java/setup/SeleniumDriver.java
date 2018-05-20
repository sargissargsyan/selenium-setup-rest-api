package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class SeleniumDriver {
	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public static void initDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver-mac-64bit");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-fullscreen");
		driverThread.set(new ChromeDriver(options));
	}

	public static WebDriver getDriver() {
		return driverThread.get();
	}

}
