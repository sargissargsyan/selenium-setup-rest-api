package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.*;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class DiscoverPage extends BaseObjectPage<DiscoverPage> {
	@FindBy(name = "search")
	private WebElement searchField;

	public DiscoverPage() {
		super(getDriver());
	}

	@Override
	public String getPageUrl() {
		return "/discover";
	}

	public DiscoverPage open() {
		return new DiscoverPage().openPage(DiscoverPage.class);
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		PageLoadHelper.isLoaded().isElementIsVisible(By.name("search"));

	}
}
