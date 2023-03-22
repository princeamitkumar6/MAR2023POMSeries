package com.qa.newopencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constant {

	public static final String LOGIN_PAGE_TITLE = "OpenCart - Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "account/login";
	public static final int DEFAULT_WAIT = 10;

	public static final String ACCOUNT_PAGE_TITLE = "OpenCart - Your Account";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "account/account";
	public static final List<String> ACCOUNT_PAGE_SECTIONS_LIST = Arrays.asList("Account Details", "Change Password",
			"Payment Methods", "Showcase", "Partner Up", "Your Orders", "Your Downloads", "Your Stores",
			"Rate your Downloads", "Manage your Extensions", "Apply to become a seller");
	public static final String TEST_DATA_SHEET = "register";
	public static final String REGISTER_SUCESS_MESSAGE = "Register for OpenCart account";


}
