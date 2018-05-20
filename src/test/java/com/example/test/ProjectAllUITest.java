package com.example.test;

import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProjectPage;
import pageobjects.ProjectsPage;
import setup.SeleniumBaseTest;

import static org.testng.Assert.*;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */
public class ProjectAllUITest extends SeleniumBaseTest {

	@Test
	public void buttonsVisibility() {
		//login
		LoginPage loginPage = new LoginPage().open();
		loginPage.setUsername("sqa.days@yandex.ru");
		loginPage.setPassword("Armenia2018");
		HomePage homePage = loginPage.clickSubmit();

		//naviagte
		homePage = homePage.init();
		ProjectsPage projectsPage = homePage.clickFolderIcon();

		//create project
		projectsPage = projectsPage.init();
		projectsPage.clickCreateProject();
		projectsPage.selectProjectType();
		projectsPage.setProjectName("Testing Project Name");
		projectsPage.setProjectDescription("Testing Project Description");
		projectsPage.submit();

		//navigate to Project page
		ProjectPage projectPage = new ProjectPage().init();
		projectPage.clickTimeline();

		//make an assertions
		assertTrue(projectPage.isLikeButtonVisible(), "Like button should be visible!");
		assertTrue(projectPage.istrackButtonVisible(), "Track button should be visible!");
	}
}
