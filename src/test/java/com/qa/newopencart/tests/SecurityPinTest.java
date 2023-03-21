package com.qa.newopencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecurityPinTest extends BaseTest {
	@BeforeClass
	public void securityPageSetUP() {
		pinPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void pinVisibilityTest() {
		Assert.assertTrue(pinPage.isPinDisplayed());
	}

	@Test(priority = 2)
	public void pinTest() {
		pinPage.pin(prop.getProperty("pin").trim());
	}
}
