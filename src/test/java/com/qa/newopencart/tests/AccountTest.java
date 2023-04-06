package com.qa.newopencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

	@Test
	public void seacrhProdTest() {
		resultsPage = accPage.searchText(Constant.SEARCH_PRODUCT_NAME);
		Assert.assertEquals(resultsPage.prodConfirmatioText(), Constant.PROD_INFO_PAGE_TEXT);
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "Macbook" }, { "iMac" }, { "Samsung" }, { "Apple" } };
	}

	@Test(dataProvider = "productData")
	public void searchProductTest(String product) {
		resultsPage = accPage.searchText(product);
		Assert.assertTrue(resultsPage.prodCount() > 0, "No data Found");
	}

	@DataProvider
	public Object[][] productSelectData() {
		return new Object[][] { { "Macbook", "MacBook Air" }, { "MacBook", "MacBook Pro" }, { "iMac", "iMac" },
				{ "Samsung", "Samsung Galaxy Tab 10.1" } };
	}

	@Test(dataProvider = "productSelectData")
	public void selectProductTest(String product, String productName) {
		resultsPage = accPage.searchText(product);
		prodInfoPage = resultsPage.selectProductName(productName);
		Assert.assertEquals(prodInfoPage.getProductHeaderName(), productName);
	}

}
