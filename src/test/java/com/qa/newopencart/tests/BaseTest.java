package com.qa.newopencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.newopencart.factory.DriverFactory;
import com.qa.newopencart.pages.AccountPage;
import com.qa.newopencart.pages.LoginPage;
import com.qa.newopencart.pages.ProdInfoPage;
import com.qa.newopencart.pages.RegisterPage;
import com.qa.newopencart.pages.ResultsPage;
import com.qa.newopencart.utils.ElementUtils;

public class BaseTest {

	DriverFactory driverFactory;
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	ElementUtils eutils;
	AccountPage accPage;
	RegisterPage registerPage;
	ResultsPage resultsPage;
	ProdInfoPage prodInfoPage;
	
	SoftAssert softAssert;

	@BeforeTest
	public void setUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.prop();
		driver = driverFactory.init_driver(prop);
		eutils = new ElementUtils(driver);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
