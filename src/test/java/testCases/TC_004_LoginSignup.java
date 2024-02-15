package testCases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.LoginSignup;
import testBase.BaseClass;
import utilities.WindowHandel;

public class TC_004_LoginSignup extends BaseClass{
	
	@Test(priority=1, groups= {"master", "smoke"})
	public void verifyLoginSignPage() {
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		logger.info("**** Starting TC_004_LoginSignup ****");
		alist = new ArrayList<>();
		try {
			logger.info("Verifying login/SignUp");
			LoginSignup loginSignup = new LoginSignup(driver);
			loginSignup.clickLogoBtn();
			alist.add(new BaseClass().screenshot("loginHomepage"));
			loginSignup.clickLoginSignUp();
			
			alist.add(new BaseClass().screenshot("loginSignUpCard"));
			
			loginSignup.loginWithGoogle();
		} catch (Exception e) {
			logger.info("Verifying login/SignUp failed!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_004_LoginSignup ****");
	}
}
