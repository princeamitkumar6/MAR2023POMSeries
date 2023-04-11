package com.qa.newopencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ElementUtils;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtils eutils;

	private By prodInfoText = By.xpath("//h2[text()='Products meeting the search criteria']");
	private By prodlist = By.xpath("//div[@class='image']");
	private By prodName = By.xpath("//div[@class='caption']/h4/a");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eutils = new ElementUtils(driver);
	}

	public String prodConfirmatioText() {
		System.out.println(eutils.getText(prodInfoText));
		return eutils.getText(prodInfoText);
	}

	public int prodCount() {

		int prodCount = eutils.waitForAllElementVisible(prodlist, Constant.DEFAULT_LONG_TIME_OUT).size();
		System.out.println("totl search product: " + prodCount);
		return prodCount;
	}

	public ProdInfoPage selectProductName(String productName) {
		List<WebElement> prodList = eutils.waitForAllElementVisible(prodName, Constant.DEFAULT_LONG_TIME_OUT);

		for (WebElement e : prodList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(productName)) {
				e.click();
				break;
			}
		}
		return new ProdInfoPage(driver);
	}

}
