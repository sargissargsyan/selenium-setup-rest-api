package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class LoginPage extends BaseObjectPage<LoginPage> {
	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(css = ".submit-button")
	private WebElement submitButton;

	public LoginPage() {
		super(getDriver());
	}

	@Override
	public String getPageUrl() {
		return "/login";
	}

	public void setUsername(String text) {
		usernameField.sendKeys(text);
	}

	public void setPassword(String text) {
		passwordField.sendKeys(text);
	}

	public HomePage clickSubmit() {
		submitButton.click();
		PageLoadHelper.isLoaded().isElementIsInvisible( By.cssSelector(".loading-bar"));
		return new HomePage();
	}

	public LoginPage open() {
		return new LoginPage().openPage(LoginPage.class);
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		PageLoadHelper.isLoaded().isElementIsVisible(By.cssSelector(".login-form"));
		PageLoadHelper.isLoaded().waitForPageLoaded();
	}
}
