package com.qa.newopencart.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@Test(dataProvider = "productData", enabled = false)
	public void productImageCountTest(String productName, String mainProductName, int imageCount) {
		resultsPage = accPage.searchText(productName);
		prodInfoPage = resultsPage.selectProductName(mainProductName);
		int noOfimages = prodInfoPage.getProdImageCount();
		Assert.assertEquals(noOfimages, imageCount);
	}

	@Test(enabled = false)
	public void productDataTest() {
		resultsPage = accPage.searchText("Macbook");
		prodInfoPage = resultsPage.selectProductName("Macbook Pro");
		Map<String, String> actProductInfoMap = prodInfoPage.getProdInfo();
		// actProductInfoMap.forEach((k,v) -> System.out.println(k+":"+v));
		softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softAssert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actProductInfoMap.get("Reward Points"), "800");
		softAssert.assertAll();
	}

//	@Test
//	public void addCartTest() throws InterruptedException {
//		resultsPage = accPage.searchText("Macbook");
//		prodInfoPage = resultsPage.selectProductName("Macbook Pro");
//		//prodInfoPage = resultsPage.selectProductName("Macbook Pro");
//		String text = prodInfoPage.addProductInCart("2");
//		Assert.assertEquals(text, "Success: You have added");
//
//	}
	
	@DataProvider
	public Object[][] getCartTestData() {
		return new Object[][] {
			{"Macbook", "MacBook Pro", 1},
			{"iMac", "iMac", 2},
		};
	}
	
	
	@Test(dataProvider = "getCartTestData")
	public void addtToCartTest(String searchKey, String productName, int quantity) {
		resultsPage = accPage.searchText(searchKey);
		prodInfoPage = resultsPage.selectProductName(productName);
		prodInfoPage.enterQuantity(quantity);
		String actCartMesg = prodInfoPage.addProductToCart();
		//Success: You have added MacBook Pro to your shopping cart!
		softAssert.assertTrue(actCartMesg.indexOf("Success")>=0);
		softAssert.assertTrue(actCartMesg.indexOf(productName)>=0);
		softAssert.assertEquals(actCartMesg, "Success: You have added "+productName+" to your shopping cart!");
		
		
		
//		//new code: checking cart details as well:
//		viewCartPopUpPage = productInfoPage.openCart();
//		List<String> cartProdList = viewCartPopUpPage.getProductsValueListInCart();
//		
//		Object[][] data = getCartTestData();
//		expProdListInCart = new ArrayList<String>();
//		for(int i=0; i< data.length; i++) {
//			expProdListInCart.add(data[i][1].toString());
//		}
//		
//		System.out.println(expProdListInCart);
//		softAssert.assertTrue(expProdListInCart.containsAll(cartProdList));
		
		
		softAssert.assertAll();

	}

}
