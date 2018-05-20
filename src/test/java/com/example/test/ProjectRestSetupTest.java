package com.example.test;

import api.ApiHelper;
import com.google.gson.JsonObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ProjectPage;
import setup.SeleniumBaseTest;

import static org.testng.Assert.*;

/**
 * Created by Sargis Sargyan on 4/22/18.
 */
public class ProjectRestSetupTest extends SeleniumBaseTest {
	JsonObject project;

	@BeforeMethod
	public void setUp() {
		login("sqa.days@yandex.ru", "Armenia2018");
		project = ApiHelper.createProject();
		ApiHelper.createIssue(project);
	}

	@AfterMethod
	public void tearDown() {
		ApiHelper.deleteProject(project);
	}

	@Test
	public void trackAndLikeButtonsVisibility() {
		ProjectPage projectPage = new ProjectPage(project);
		projectPage = projectPage.open();
		assertTrue(projectPage.isLikeButtonVisible(), "Like button should be visible!");
		assertTrue(projectPage.istrackButtonVisible(), "Track button should be visible!");
	}
}
