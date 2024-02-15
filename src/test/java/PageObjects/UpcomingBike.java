package PageObjects;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.JavaScriptManager;

public class UpcomingBike extends BasePage{

	public UpcomingBike(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="makeId")
	WebElement ManufacturersDropDown;
	
	@FindBy(css=".lnk-hvr.block.of-hid.h-height")
	List<WebElement> bikeName_loc;
	
	@FindBy(xpath="//li[contains(@class,'modelItem')]")
	List<WebElement> bikePrice_loc;
	
	@FindBy(css=".clr-try.fnt-14")
	List<WebElement> lunchDate_loc;
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement viewMoreButton;
	
	@FindBy(xpath="//a[normalize-space()='Latest Bikes']")
	WebElement latestBike_loc;
	
	JavaScriptManager javaScriptManager = new JavaScriptManager();
	String path = "C:\\Users\\2303474\\eclipse-workspace\\Hackathon\\testData\\TestData.xlsx";
	ExcelUtility excelUtility = new ExcelUtility(path);
	
	public void selectFromDropDown(String manufacturer) throws InterruptedException, IOException {
		ManufacturersDropDown.click();
		Thread.sleep(2000);
		Select select = new Select(ManufacturersDropDown);
		select.selectByVisibleText(manufacturer);
		BaseClass.alist.add(new BaseClass().screenshot("dropDown"));
		
	}
	
	public void clickViewMoreButton() throws IOException {
		
		javaScriptManager.scrollIntoView(driver, latestBike_loc);
		javaScriptManager.highlightElement(driver, viewMoreButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		BaseClass.alist.add(new BaseClass().screenshot("ViewMoreButton"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", viewMoreButton);
	}
	
	public void getBikeDetails() throws IOException {
		excelUtility.setCellData("UpcomingBike", 0, 0, "BikeName");
		excelUtility.setCellData("UpcomingBike", 0, 1, "Price");
		excelUtility.setCellData("UpcomingBike", 0, 2, "LunchDate");
		int row = 1;
		for(int i = 0; i < bikeName_loc.size(); i++) {
			String bikeName = bikeName_loc.get(i).getText();
			String lunchDate = lunchDate_loc.get(i).getText();
			int price = Integer.parseInt(bikePrice_loc.get(i).getAttribute("data-price"));
			if(price < 400000) {
				System.out.println(bikeName +"\n" + price + "\n" + lunchDate);
				System.out.println("--------------------------------");
				excelUtility.setCellData("UpcomingBike", row, 0, bikeName);
				excelUtility.setCellData("UpcomingBike", row, 1, price+"");
				excelUtility.setCellData("UpcomingBike", row, 2, lunchDate);
				row++;
			}
		}
	}
	
	public double extractNumber(String price) {
		Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
		Matcher matcher = pattern.matcher(price);
		if(matcher.find()) {
			return Double.parseDouble(matcher.group());
		}
		return 0.0;
	}
	
	
}
