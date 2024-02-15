package PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.JavaScriptManager;

public class UsedCar extends BasePage {

	public UsedCar(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[normalize-space()='Used Cars']")
	WebElement navUsedCar_loc;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement usedCarLocation_loc;
	
	@FindBy(xpath="//span[normalize-space()='Brand and Model']")
	WebElement BrandAndModel_loc;
	
	@FindBy(xpath="//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	WebElement logo_loc;
	
	@FindBy(xpath="//li[@id='mmvLi_21_314']")
	WebElement MahindraPopularBrand;
	
	@FindBy(xpath="//div[@class='gsc_thin_scroll']")
	WebElement popularModelBox;
	
	String path = "C:\\Users\\2303474\\eclipse-workspace\\Hackathon\\testData\\TestData.xlsx";
	ExcelUtility excelUtility = new ExcelUtility(path);
	JavaScriptManager javaScriptManager = new JavaScriptManager();
	public void hoverUsedCar() {
		javaScriptManager.scrollToTop(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(navUsedCar_loc).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickUsedCarLocation() throws IOException {
		javaScriptManager.highlightElement(driver, usedCarLocation_loc);
		BaseClass.alist.add(new BaseClass().screenshot("usedCarLocation"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", usedCarLocation_loc);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickPopularModels() throws IOException {
		List<WebElement> modelsList = driver.findElements(By.xpath("//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label"));
		javaScriptManager.highlightElement(driver, popularModelBox);
		System.out.println("Size of Popular model :"+ modelsList.size());
		excelUtility.setCellData("PopularModel", 0, 0, "PopularModel");
		System.out.println("-----------------------------");
		int row = 1;
		
		javaScriptManager.scrollInsideDiv(driver, modelsList.get(0));
		BaseClass.alist.add(new BaseClass().screenshot("popularModel"));
		List<String> popularModelList = new ArrayList<>();
		
		for(WebElement model : modelsList) {
			System.out.println(model.getText());
			popularModelList.add(model.getText());
			excelUtility.setCellData("PopularModel", row, 0, model.getText());
			row++;
		}
	}
}
