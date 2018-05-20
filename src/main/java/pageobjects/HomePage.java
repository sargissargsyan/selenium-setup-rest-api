package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.*;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class HomePage extends BaseObjectPage<HomePage> {
	@FindBy(css = "[tg-dropdown-project-list='tg-dropdown-project-list'] a")
	private WebElement folderIcon;

	@FindBy(css = ".navbar-dropdown.dropdown-project-list")
	private WebElement manageProjectButton;

	public HomePage() {
		super(getDriver());
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public HomePage open() {
		return new HomePage().openPage(HomePage.class);
	}

	public HomePage init() {
		return new HomePage().init(HomePage.class);
	}

	public ProjectsPage clickFolderIcon() {
		waitForElement(folderIcon).click();
		return new ProjectsPage();
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		PageLoadHelper.isLoaded().isElementIsVisible(By.cssSelector(".working-on-container"));
		PageLoadHelper.isLoaded().waitForPageLoaded();
	}
}
