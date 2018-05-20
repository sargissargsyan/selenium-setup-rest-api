package pageobjects;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.*;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class ProjectPage extends BaseObjectPage<ProjectPage> {

	@FindBy(css = ".track-button.like-button")
	private WebElement likeButton;

	@FindBy(css = ".track-button.watch-button")
	private WebElement trackButton;

	@FindBy(css = "#nav-timeline")
	private WebElement navTimelineIcon;

	private String name;
	private String id;
	private JsonObject project;

	public ProjectPage(JsonObject project) {
		super(getDriver());
		this.name = project.get("name").getAsString();
		this.id = project.get("id").getAsString();
		this.project = project;
	}

	public ProjectPage() {
		super(getDriver());
	}

	@Override
	public String getPageUrl() {
		return "/project/" + USERNAME + "-" + name.replace(" ", "-").toLowerCase();
	}
	public ProjectPage open() {
		return new ProjectPage(project).openPage(ProjectPage.class);
	}

	public boolean isLikeButtonVisible() {
		return isElementDisplayed(likeButton);
	}

	public boolean istrackButtonVisible() {
		return isElementDisplayed(trackButton);
	}

	public void clickTimeline() {
//		waitForElement(getDriver().findElement(By.cssSelector("#nav-timeline a"))).click();
		waitForElement(navTimelineIcon).click();
		PageLoadHelper.isLoaded().waitForPageLoaded();
	}

	public ProjectPage init() {
		return new ProjectPage().init(ProjectPage.class);
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		PageLoadHelper.isLoaded().waitForPageLoaded();
	}
}
