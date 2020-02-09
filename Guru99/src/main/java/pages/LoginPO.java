package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import baseSetup.TestBase;
import interfaceManager.SelImplementation;
import utility.Log4jlogger;

public class LoginPO extends TestBase
{
	String actual= null;
	SelImplementation sel;

	
	
	@FindBy(xpath="//*[@type='text' and @name='uid']")
	private WebElement username;
	
	@FindBy(name="password")
    private WebElement password;
	
	@FindBy(name="btnLogin")
    private WebElement loginbtn;
	
	@FindBy(xpath="//*[@behavior='alternate']")
	private WebElement loginpagetitle;
	
	
	public LoginPO()
	{
		PageFactory.initElements(driver, this);
		sel= new SelImplementation();
		
	}
	
	// click on my Account link 
	
	SoftAssert softassert= new SoftAssert();
	
	
	public WebElement getUserId()
	{
		
		return this.username;
	}
	
	public WebElement getPass()
	{
		return this.password;
	}
	
	public WebElement getPagetitle()
	{
		return this.loginpagetitle;
	}
	
	
	public void validatelogin(WebDriver driver)
	{
		//sel.setText(getUserId(),driver,"sachin23");
		
		sel.setText(getUserId(), driver, "sachin");
		//Utility.TakescrenShot();
		
		Log4jlogger.info("User enter username ");
		
		
		sel.setText(getPass(), driver, "demo");
		//Utility.TakescrenShot();
		Log4jlogger.info("User enter password ");

		sel.clickOnElement(loginbtn, driver);
		Log4jlogger.info("User click on sign in button");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sel.getalerttext( driver);
		System.out.println("alert text "+SelImplementation.AlertText);
		Assert.assertEquals(SelImplementation.AlertText,"User or Password is not valid");
        
		
	
	}
	
	

	
	 public void enter_user_name(String strusername)
	
	{
		
		username.sendKeys(strusername); 
			 
	}
		
	
	public void enter_password(String pwd)
	{
		password.sendKeys(pwd);
		
	}
	
	public void click_on_signIN()
	{
		loginbtn.click();
	}
	
	public void verifypageTitle(String expected)
	{
		actual=loginpagetitle.getText();
		Assert.assertEquals(actual, expected);
	
		
	
		
	}

	

}
