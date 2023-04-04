package com.qa.newopencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.newopencart.utils.Constant;

public class LoginTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.getLoginPageTitle(), Constant.LOGIN_PAGE_TITLE, "Page title is wrong amit");
	}

	@Test
	public void loginPageURLTest() {
		Assert.assertTrue(loginPage.getLoginPageURL().contains(Constant.LOGIN_PAGE_URL_FRACTION));
	}

	@Test
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkVisisble());
	}

	@Test
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoExist());
	}

}
