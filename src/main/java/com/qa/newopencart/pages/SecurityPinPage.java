package com.qa.newopencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ElementUtils;

public class SecurityPinPage {

	private WebDriver driver;
	private ElementUtils eutils;

	private By pin = By.id("input-pin");
	private By continueButton = By.xpath("//button[@type='submit']");

	public SecurityPinPage(WebDriver driver) {
		this.driver = driver;
		eutils = new ElementUtils(driver);
	}

	public boolean isPinDisplayed() {
		return eutils.doIsDisplayed(pin, Constant.DEFAULT_WAIT);
	}

	public AccountPage pin(String pinCode) {
		if (isPinDisplayed()) {
			eutils.doSendKeys(pin, pinCode);
			eutils.doClick(continueButton);

			return new AccountPage(driver);
		}
		return null;
	}

}
