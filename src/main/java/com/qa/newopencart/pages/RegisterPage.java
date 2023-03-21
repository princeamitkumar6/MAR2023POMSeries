package com.qa.newopencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ElementUtils;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtils eutils;

	private By username = By.id("input-username");
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By select = By.xpath("//select[@id='input-country']");
	private By password = By.id("input-password");
	private By sucessMSG = By.xpath("//h3[text()='Register for OpenCart account']");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eutils = new ElementUtils(driver);
	}

	public boolean accountRegistration(String username, String firstName, String lastName, String email, String country,
			String password) throws InterruptedException {

		eutils.doSendKeys(this.username, username);
		eutils.doSendKeys(this.firstName, firstName);
		eutils.doSendKeys(this.lastName, lastName);
		eutils.doSendKeys(this.firstName, firstName);
		eutils.doSendKeys(this.email, email);
		eutils.doSelectByText(select, country);
		eutils.doSendKeys(this.password, password);

		if (eutils.getText(sucessMSG).contains(Constant.REGISTER_SUCESS_MESSAGE)) {

			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);

			return true;
		}

		return false;

	}

}
