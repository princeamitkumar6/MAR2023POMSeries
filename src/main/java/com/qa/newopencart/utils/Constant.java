package com.qa.newopencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constant {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRACTION = "account/login";
	
	public static final int DEFAULT_WAIT = 10;
	public static final int DEFAULT_MEDIUM_TIME_OUT = 10;
	public static final int DEFAULT_SHORT_TIME_OUT = 5;
	public static final int DEFAULT_LONG_TIME_OUT = 20;

	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_URL_FRACTION = "account/account";
	public static final int ACCOUNTS_PAGE_HEADERS_COUNT = 4;
	
	public static final List<String> ACCOUNT_PAGE_SECTIONS_LIST = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	public static final String REGISTER_SUCESS_MESSAGE = "Your Account Has Been Created";
	
	
	public static final String TEST_DATA_SHEET = "register";

}
