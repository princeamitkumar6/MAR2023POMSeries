package com.qa.newopencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.newopencart.utils.Constant;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void prodInfoSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] products() {
		return new Object[][] { { "Macbook", "MacBook Pro" }, { "iMac", "iMac" } };
	}

	@Test(dataProvider = "products", enabled = false)
	public void productHeaderTest(String product, String productName) {
		resultsPage = accPage.searchText(product);
		prodInfoPage = resultsPage.selectProductName(productName);
		Assert.assertEquals(prodInfoPage.getProductHeaderName(), productName);
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "Macbook", "MacBook Pro", Constant.MACBOOK_IMAGES_COUNT },
				{ "Macbook", "MacBook Air", Constant.MACBOOK_IMAGES_COUNT },

				{ "iMac", "iMac", Constant.IMAC_IMAGES_COUNT }

		};
	}

	@Test(dataProvider = "productData")
	public void productImageCountTest(String productName, String mainProductName, int imageCount) {
		resultsPage = accPage.searchText(productName);
		prodInfoPage = resultsPage.selectProductName(mainProductName);
		int noOfimages = prodInfoPage.getProdImageCount();
		Assert.assertEquals(noOfimages, imageCount);
	}

}
