package PageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import utilities.JavaScriptManager;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(xpath="//a[normalize-space()='New Bikes']")
	WebElement navNewBike_loc;
	
	@FindBy(xpath="//span[normalize-space()='Upcoming Bikes']")
	WebElement upcomingBike_loc;
	
	JavaScriptManager javaScriptManager = new JavaScriptManager();
	public boolean verifyTitle() {
		String expactedTitle = driver.getTitle();
		String actualTitle= "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com";
		if(expactedTitle.equals(actualTitle)) {
			System.out.println("Title: " + expactedTitle);
			return true;
		}else {
			System.out.println("Title: " + expactedTitle);
			return false;
		}
	}
	
	public void hoverNewBike() {
		Actions actions = new Actions(driver);
		actions.moveToElement(navNewBike_loc).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUpcomingBike() throws IOException {
		Actions actions = new Actions(driver);
		actions.moveToElement(upcomingBike_loc).perform();
		
		javaScriptManager.highlightElement(driver, upcomingBike_loc);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", upcomingBike_loc);
		BaseClass.alist.add(new BaseClass().screenshot("AfterClickingUpcomingBike"));
	}
}
