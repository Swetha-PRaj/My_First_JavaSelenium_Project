package com.sat.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sat.testbase.TestBase;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/sat/config/config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}
	 public String getSelenium() {
		 String s1 = properties.getProperty("selenium");
		 if(s1 != null) {
			 return s1;
			 
		 }
		 else {
			 throw new RuntimeException("s1 not specified in the Configuration.properties file.");
		 }
	 }

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public void refresh() {
		TestBase.getDriver().navigate().refresh();
	}

	public String fileUpload(String fileName) {
		String file_Name = properties.getProperty(fileName);
		if (file_Name != null)
			return file_Name;
		else
			throw new RuntimeException("File path not Specified in the configuration path");
	}

	public String getResalePortalUrl1(String portal_url) {
		String url = properties.getProperty(portal_url);
		System.out.println(portal_url);
		System.out.println(url);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getResalePortaluserId(String user1) {
		String UserID = properties.getProperty(user1);
		System.out.println(user1);
		System.out.println(UserID);
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("UserID not specified in the Configuration.properties file");
	}
	
	

	public String getResalePortalpassword(String password) {
		String Password = properties.getProperty(password);
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getResalePortalUrl2() {
		String url = properties.getProperty("resale_portal_url2");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getResalePortaluserId2() {
		String UserID = properties.getProperty("resale_portal_userid2");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("UserID not specified in the Configuration.properties file");
	}

	public String getResalePortalpassword2() {
		String Password = properties.getProperty("resale_portal_password2");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getResaleAppUrl() {
		String url = properties.getProperty("resale_app_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("resale App url not specified in the Configuration.properties file.");
	}
	public String getResaleHomeAppUrl() {
		String url = properties.getProperty("resale_app_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("resale App url not specified in the Configuration.properties file.");
	}
	public String resaleAppUserId() {
		String UserID = properties.getProperty("resale_app_userid");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("Resale app UserID not specified in the Configuration.properties file");
	}

	public String resaleAppPassword() {
		String Password = properties.getProperty("resale_app_password");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("resale App Password not specified in the Configuration.properties file");
	}

	public String resaleAdminAppUserId() {
		String UserID = properties.getProperty("resale_admin_app_userid");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("Resale app UserID not specified in the Configuration.properties file");
	}
	

	public String resaleAdminAppPassword() {
		String Password = properties.getProperty("resale_admin_app_password");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("resale App Password not specified in the Configuration.properties file");
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("BookingAppUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Booking App url not specified in the Configuration.properties file.");
	}
	/*
	public String getPowerApplicationUrl() {
		String url = properties.getProperty("BookingAppUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Power App url not specified in the Configuration.properties file.");
	}*/
	public String getApplicationUrlNewAdminTool() {
		String url = properties.getProperty("New_AdminTool_URL");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Booking App url not specified in the Configuration.properties file.");
	}
	public String getPowerAppAdminCloudFlow() {
		String url = properties.getProperty("PowerAppsCloudFlow_AdminTool");
		if(url != null) return url;
		else throw new RuntimeException("powerApp cloud flow url not specified in the Configuration.properties file.");
	}
	public String AdminUserName(){
		String UserID =properties.getProperty("BookingAppAdminUserName");
		if(UserID!= null) return UserID;
		else throw new RuntimeException("Admin UserID not specified in the Configuration.properties file");
	}
	
	public String PowerAppUserName(){
		String UserID =properties.getProperty("PowerAppUserID");
		if(UserID!= null) return UserID;
		else throw new RuntimeException("PowerApp UserID not specified in the Configuration.properties file");
	}
	public String AdminUserPassword(){
		String Password =properties.getProperty("BookingAppAdminPassword");
		if(Password != null) return Password;
		else throw new RuntimeException("Admin Password not specified in the Configuration.properties file");
	}
	public String PowerUserPassword(){
		String Password =properties.getProperty("PowerAppPassword");
		if(Password != null) return Password;
		else throw new RuntimeException("Powerapp Password not specified in the Configuration.properties file");
	}
	public String TestUserName(){
		String UserID =properties.getProperty("BookingAppTestUserName");
		if(UserID!= null) return UserID;
		else throw new RuntimeException("Test UserID not specified in the Configuration.properties file");
	}
	public String TestUserPassword(){
		String Password =properties.getProperty("BookingAppTestPassword");
		if(Password != null) return Password;
		else throw new RuntimeException("Test Password not specified in the Configuration.properties file");
	}
	public String getEmailUrl() {
		String url = properties.getProperty("email_url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getEmailUserid() {
		String UserID = properties.getProperty("email_username");
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("UserID not specified in the Configuration.properties file");
	}

	public String getEmailPassword() {
		String Password = properties.getProperty("email_password");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}
	public String getGmailPassword(String GmailPassword) {
		System.out.println(GmailPassword);
		String Password = properties.getProperty(GmailPassword);
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Gmail Password not specified in the Configuration.properties file");
	}
	public String getGmailUserid(String GmailuserID) {
		System.out.println(GmailuserID);
		String UserID = properties.getProperty(GmailuserID);
		if (UserID != null)
			return UserID;
		else
			throw new RuntimeException("Gmail UserID not specified in the Configuration.properties file");
	}
	
	public String getShopperEmailID() {
		String Email = properties.getProperty("shopper_emailID");
		if (Email != null)
			return Email;
		else
			throw new RuntimeException("Shopper Email ID not specified in the Configuration.properties file");
	}
	public String getEmailid(String email_ID) {
		String Email = properties.getProperty(email_ID);
		if (Email != null)
			return Email;
		else
			throw new RuntimeException("Email ID not specified in the Configuration.properties file");
	}

	public String getIban(String iban) {
		String Password = properties.getProperty(iban);
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("IBANnumber not specified in the Configuration.properties file");
	}

	public String getTemporaryPassword() {
		String Password = properties.getProperty("temporaryPassword");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password not specified in the Configuration.properties file");
	}

	public String getPowerAppCloudFlow() {
		String url = properties.getProperty("PowerAppsCloudFlow");
		if (url != null)
			return url;
		else
			throw new RuntimeException("powerApp cloud flow url not specified in the Configuration.properties file.");
	}
	public String bookingportalUrlForAutomationServiceTest() {
		String gmailuderPassword =properties.getProperty("BookingPortalUrl_AutomationServiceTest");
		if(gmailuderPassword != null) return gmailuderPassword;
		else throw new RuntimeException("AutomationServiceTest url not specified in the Configuration.properties file");
	}
	public String bookingPortalUrl(String url) {
		String gmailuderPassword =properties.getProperty(url);
		if(gmailuderPassword != null) return gmailuderPassword;
		else throw new RuntimeException("Resell service url not specified in the Configuration.properties file");
	}
	public String ClickMeetForAutomationServiceTest(String url) {
		String gmailuderPassword =properties.getProperty(url);
		if(gmailuderPassword != null) return gmailuderPassword;
		else throw new RuntimeException("Resell service url not specified in the Configuration.properties file");
	}
}
