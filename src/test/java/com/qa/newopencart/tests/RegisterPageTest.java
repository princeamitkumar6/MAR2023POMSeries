package com.qa.newopencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.newopencart.utils.Constant;
import com.qa.newopencart.utils.ExcelUtils;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registrationPageSetUp() {
		registerPage = loginPage.goToRegistrationPage();
	}

	public String randomEmail() {
		Random random = new Random();
		int num = random.nextInt(1000);
		String email = "testautomation" + num + "yopmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegisterData() {
		Object[][] data = ExcelUtils.getTextData(Constant.TEST_DATA_SHEET);
		return data;
	}

	@Test(dataProvider = "getRegisterData")
	public void registrationTest(String username, String firstName, String lastName, String country, String password)
			throws InterruptedException {

		try {
			Assert.assertTrue(
					registerPage.accountRegistration(username, firstName, lastName, randomEmail(), country, password));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
