package com.qa.newopencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.newopencart.utils.Constant;

public class AccountTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accountPageTitleTest() {
		Assert.assertEquals(accPage.getAccountPageTitle(), Constant.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accountPageUrlTest() {
		Assert.assertTrue(accPage.getAccountPageURL().contains(Constant.ACCOUNT_PAGE_URL_FRACTION));
	}

	@Test
	public void logoTest() {
		Assert.assertTrue(accPage.isLogoExist());
	}

	@Test
	public void logOutLinkTest() {
		Assert.assertTrue(accPage.isLogOutLinkExist());
	}

	@Test
	public void accPageSectionsTest() {
		List<String> accSectionsList = accPage.getAccountPageSections();
		Assert.assertEquals(accSectionsList, Constant.ACCOUNT_PAGE_SECTIONS_LIST);
	}

}
