package PageObjects;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import utilities.ExcelUtility;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="identifierId")
	WebElement emailInputbox_loc;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement nextBtn_loc;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement errorMsg_loc;
	
	String path = "C:\\Users\\2303474\\eclipse-workspace\\Hackathon\\testData\\TestData.xlsx";
	ExcelUtility excelUtility = new ExcelUtility(path);
	
	public void setEmailInput() {
		emailInputbox_loc.sendKeys(randomString() + "@gmail.com");
	}
	
	public  void clickNextBtn() {
		nextBtn_loc.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getErrorMsg() throws IOException{
		String errorMsg = errorMsg_loc.getText();
		System.out.println("-----------------------------");
		System.out.println(errorMsg);
		excelUtility.setCellData("LoginPage", 0, 0, errorMsg);
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
}
