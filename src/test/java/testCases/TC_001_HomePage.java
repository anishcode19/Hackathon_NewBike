package testCases;

import java.util.ArrayList;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_HomePage extends BaseClass {
	
	@Test(groups= {"sanity", "master"})
	public void verifyTitle() {
		alist = new ArrayList<>();
		logger.info("**** Starting TC_001_HomePage ****");
		try {			
			logger.info("Getting the title of zigwheels");
			HomePage homepage = new HomePage(driver);
			logger.info("Validating the title of zigwheels");
			boolean status = homepage.verifyTitle();
			alist.add(screenshot("HomePage"));
			Assert.assertEquals(status, true);
		} catch (Exception e) {
			logger.info("zigwheels Title verification Failed!!!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_001_HomePage ****");
	}
}
