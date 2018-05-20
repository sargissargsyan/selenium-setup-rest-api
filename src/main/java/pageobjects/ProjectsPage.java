package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.PageLoadHelper;

import static setup.SeleniumDriver.*;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */

public class ProjectsPage extends BaseObjectPage<ProjectsPage> {
	@FindBy(css = ".create-options")
	private WebElement createProjectButton;

	@FindBy(css = ".create-project-action-submit")
	private WebElement createProjectSubmitButton;

	@FindBy(name = "project-name")
	private WebElement projectNameField;

	@FindBy(css = "[name='projectForm'] textarea")
	private WebElement projectDescriptionField;

	public ProjectsPage() {
		super(getDriver());
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public ProjectsPage open() {
		return new ProjectsPage().openPage(ProjectsPage.class);
	}

	public ProjectsPage init() {
		return new ProjectsPage().init(ProjectsPage.class);
	}

	public void clickCreateProject() {
		waitForElement(createProjectButton).click();
		PageLoadHelper.isLoaded().waitForPageLoaded();
	}

	public void selectProjectType() {
		PageLoadHelper.isLoaded().isElementIsClickable(By.cssSelector(".create-project-selector"));
		getDriver().findElements(By.cssSelector(".create-project-selector li")).get(0).click();
	}

	public void setProjectName(String projectName) {
		projectNameField.sendKeys(projectName);
	}

	public void setProjectDescription(String projectdescription) {
		projectDescriptionField.sendKeys(projectdescription);
	}

	public void submit(){
		createProjectSubmitButton.click();
		PageLoadHelper.isLoaded().isElementIsVisible(By.cssSelector("div.summary"));
	}

	@Override
	protected void load() {

	}

	@Override
	protected void isLoaded() throws Error {
		PageLoadHelper.isLoaded().isElementIsVisible(By.cssSelector(".project-list-title"));
		PageLoadHelper.isLoaded().waitForPageLoaded();
	}
}
