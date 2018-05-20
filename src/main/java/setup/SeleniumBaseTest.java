package setup;


import api.HttpClient;
import com.google.gson.JsonParser;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pageobjects.LoginPage;

import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class SeleniumBaseTest {
	protected void login(String username, String password) {
		String loginResponse = HttpClient.login(username, password);
		new LoginPage().open();
		((JavascriptExecutor) getDriver()).executeScript("window.localStorage.setItem('token','" + new JsonParser().parse(loginResponse).getAsJsonObject().get("auth_token") + "');");
		((JavascriptExecutor) getDriver()).executeScript("window.localStorage.setItem('userInfo','" + loginResponse + "');");

	}

	@BeforeMethod
	public void setupBaseMethod() {
		SeleniumDriver.initDriver();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownBase() {
		getDriver().close();
	}
}
