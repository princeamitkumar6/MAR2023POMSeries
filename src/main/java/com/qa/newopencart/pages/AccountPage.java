package com.qa.newopencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ElementUtils;

public class AccountPage {

	private WebDriver driver;
	private ElementUtils eutils;

	private By elements = By.xpath("//div[@id='content']/h2");
	private By logout = By.linkText("Logout");
	private By account = By.linkText("Account");
	private By logo = By.xpath("//img[@title='naveenopencart']");
	

	public AccountPage(WebDriver driver) {
		
		eutils = new ElementUtils(driver);
	}

	public String getAccountPageTitle() {
		return eutils.doGetPageTitleContains(Constant.ACCOUNT_PAGE_TITLE, Constant.DEFAULT_WAIT);
	}

	public String getAccountPageURL() {
		return eutils.waitForUrlContains(Constant.ACCOUNT_PAGE_URL_FRACTION, Constant.DEFAULT_WAIT);
	}

	public boolean isLogOutLinkExist() {
		return eutils.doIsDisplayed(logout, Constant.DEFAULT_WAIT);
	}

	public boolean logout() {
		if (isLogOutLinkExist()) {
			eutils.doClick(logout);
			return true;
		}
		return false;
	}

	public boolean isLogoExist() {
		return eutils.doIsDisplayed(logo, Constant.DEFAULT_WAIT);
	}

	public boolean isAccountLinkExist() {
		return eutils.doIsDisplayed(account, Constant.DEFAULT_WAIT);
	}

	public boolean account() {
		if (isAccountLinkExist()) {
			eutils.doClick(account);
			return true;
		}
		return false;
	}

	public List<String> getAccountPageSections() {
		List<WebElement> eleList = eutils.waitsForElementsVisible(elements, Constant.DEFAULT_WAIT);
		List<String> list = new ArrayList<String>();
		for (WebElement e : eleList) {
			list.add(e.getText());
		}
		return list;
	}

}
