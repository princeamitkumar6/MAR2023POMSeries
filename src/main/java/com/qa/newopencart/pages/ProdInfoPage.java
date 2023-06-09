package com.qa.newopencart.pages;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ElementUtils;

public class ProdInfoPage {

	Map<String, String> map;

	private ElementUtils eutils;
	private WebDriver driver;

	private By prodName = By.tagName("h1");
	private By imageCount = By.xpath("//li[@class='image-additional']//img");
	private By productMetaData = By.xpath("(//div[@class='col-sm-4']/ul)[1]/li");
	private By productPriceData = By.xpath("(//div[@class='col-sm-4']/ul)[2]/li");

	private By addCartSucessMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
	private By quantityTextBox = By.name("quantity");
	private By addToCartButton = By.id("button-cart");
	private By cartSuccessMessg = By.cssSelector("div.alert.alert-success");
	

	public ProdInfoPage(WebDriver driver) {
		this.driver = driver;
		eutils = new ElementUtils(driver);
	}

	public String getProductHeaderName() {
		return eutils.getText(prodName);
	}
	
	public void enterQuantity(int qty) {
		System.out.println("Product Quantity: " + qty);
		eutils.doSendKeys(quantityTextBox, String.valueOf(qty));
	}

	public int getProdImageCount() {
		return eutils.getElements(imageCount).size();
	}

	public Map<String, String> getProdInfo() {
		map = new TreeMap<String, String>();
		map.put("Name", getProductHeaderName());
		map.put("Totalimage", String.valueOf(getProdImageCount()));
		getProductMetaData();
		getProductPriceData();
		return map;
	}

//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock

	public void getProductMetaData() {
		List<WebElement> metaData = eutils.getElements(productMetaData);
		for (WebElement e : metaData) {
			String metaText = e.getText();
			String[] text = metaText.split(":");
			String key = text[0].trim();
			String value = text[1].trim();
			map.put(key, value);
		}
	}

//	$2,000.00
//	Ex Tax: $2,000.00

	public void getProductPriceData() {
		List<WebElement> priceData = eutils.getElements(productPriceData);
		String price = priceData.get(0).getText().trim();
		String exTax = priceData.get(1).getText().trim();
		String exTaxPrice = exTax.split(":")[1].trim();

		map.put("productprice", price);
		map.put("Ex Tax", exTaxPrice);
	}

//	public String addProductInCart(String quantity) {
//		eutils.doSendKeys(quantityTextBox, quantity);
//		eutils.doClick(addToCartButton);
//		return eutils.getText(addCartSucessMessage);
//	}
	
	public String addProductToCart() {
		eutils.doClick(addToCartButton);
		String successMessg = eutils.waitForElementVisible(cartSuccessMessg, Constant.DEFAULT_MEDIUM_TIME_OUT).getText();
		//StringBuilder sb = new StringBuilder(successMessg);
		//String mesg = sb.substring(0, successMessg.length()-1).replace("\n", "").toString();
		
		String mesg = successMessg.substring(0, successMessg.length()-1).replace("\n", "").toString();
		
		System.out.println("Cart Success Mesg: " + mesg);
		return mesg;
	}
}
