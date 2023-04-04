package com.qa.newopencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils eutils;

	private By emailTextField = By.id("input-email");
	private By passwordTextField = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	private By registration = By.linkText("REGISTER");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eutils = new ElementUtils(driver);
	}

	public String getLoginPageTitle() {

		return eutils.doGetPageTitleContains(Constant.LOGIN_PAGE_TITLE, Constant.DEFAULT_WAIT);
	}

	public String getLoginPageURL() {
		return eutils.waitForUrlContains(Constant.LOGIN_PAGE_URL_FRACTION, Constant.DEFAULT_WAIT);
	}

	public boolean isForgotPasswordLinkVisisble() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public RegisterPage goToRegistrationPage() {
		eutils.doClick(registration);
		return new RegisterPage(driver);
	}

	public AccountPage doLogin(String un, String pwd) {
		eutils.doSendKeys(emailTextField, un);
		eutils.doSendKeys(passwordTextField, pwd);
		eutils.doClick(loginButton);
		return new AccountPage(driver);
	}

}
