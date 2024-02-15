package testCases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.UsedCar;
import testBase.BaseClass;

public class TC_003_UsedCar extends BaseClass {
	
	@Test(groups= {"regression", "master"})
	public void verifyUsedBike() {
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		alist = new ArrayList<>();
		logger.info("**** Starting TC_003_UsedCar ****");
		try {
			logger.info("Verifying usedCar bike");
			UsedCar usedCar = new UsedCar(driver);
			usedCar.hoverUsedCar();
			usedCar.clickUsedCarLocation();
			usedCar.clickPopularModels();
		} catch (Exception e) {
			logger.info("Used Car Verification Failed!!!");
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("**** Finished TC_003_UsedCar ****");
	}
}
