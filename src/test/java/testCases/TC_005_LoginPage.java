package testCases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import utilities.WindowHandel;
import PageObjects.LoginPage;

public class TC_005_LoginPage extends BaseClass {
	@Test(priority=2,groups= {"regression", "master"})
	public void verifyLoginPage(){
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		logger.info("**** Starting TC_005_LoginPage ****");
		alist = new ArrayList<>();
		try {
			logger.info("Verifying loginPage");
			WindowHandel windowHandel = new WindowHandel(driver);
			windowHandel.windowNavigate("Sign in - Google Accounts");
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmailInput();
			loginPage.clickNextBtn();
			loginPage.getErrorMsg();
			alist.add(new BaseClass().screenshot("loginWithGoogle"));
		} catch (Exception e) {
			logger.info("LoginPage verification failed!!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_005_LoginPage ****");
	}
}
