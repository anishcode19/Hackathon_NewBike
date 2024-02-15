package testCases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.UpcomingBike;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_UpcomingBike extends BaseClass{
	
	@Test(priority=1, groups= {"smoke","regression", "master"})
	public void verifyNewBike() throws InterruptedException {
		logger = LogManager.getLogger(this.getClass());
		//loading log4j2 file
		logger.info("**** Starting TC_002_UpcomingBike ****");
		alist = new ArrayList<>();
		try {
			logger.info("Verifing New Bike");
			HomePage homepage = new HomePage(driver);
			homepage.hoverNewBike();
			alist.add(screenshot("BeforeUpcomingBike"));
			homepage.clickUpcomingBike();
		} catch (Exception e) {
			logger.info("New Bike Verification Failed!!");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2, dependsOnMethods= {"verifyNewBike"}, groups={"regression", "master"},
			dataProvider="Manufacturer", dataProviderClass=DataProviders.class)
	public void verifyUpcomingBike(String manufacturer) {
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		alist = new ArrayList<>();
		try {
			logger.info("Verifing Upcoming Bike");
			UpcomingBike upcomingBike = new UpcomingBike(driver);
			upcomingBike.selectFromDropDown(manufacturer);
			upcomingBike.clickViewMoreButton();
			upcomingBike.getBikeDetails();
		} catch (Exception e) {
			logger.info("Verification of upcoming bike Failed!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_002_UpcomingBike ****");
	}
}
