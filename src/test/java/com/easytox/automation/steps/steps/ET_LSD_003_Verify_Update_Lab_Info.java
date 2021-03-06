package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ET_LSD_003_Verify_Update_Lab_Info {
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PAGE_ID1 = "admin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String PAGE_PSWD1 ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	

	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_LSD_003_Verify_Update_Lab_Info(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
	}
	public static void credentials(WebDriver driver2)
	{
		
			WebElement user =  driver2.findElement(By.name(USER_NAME));
			user.clear();
			user.sendKeys(PAGE_ID);
			
			WebElement pwd = driver2.findElement(By.name(PASSWD));
			 pwd.clear();
			 pwd.sendKeys(PAGE_PSWD);		 
			 driver2.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
		
	}


	@Given("^Enter valid Username and Password click on \"([^\"]*)\" button$")
	public void Enter_valid_Username_and_Password_click_on_button(String arg1) throws Throwable {
	   
		driver.get("http://bmtechsol.com:8080/easytox/");		 
		
		 driver.manage().window().maximize();		 
		 credentials(driver);
		
		}

	@Then("^Lab admin user should be able to login successfully$")
	public void Lab_admin_user_should_be_able_to_login_successfully() throws Throwable {
		
			Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		   
	}

	@When("^Click on lab name$")
	public void Click_on_lab_name() throws Throwable {
	
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='editlink']")).click();
		
		
	}

	@Then("^\"([^\"]*)\" screen should be displayed$")
	public void screen_should_be_displayed(String arg1) throws Throwable {
	  
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);	
	    
	    driver.quit();
	  	
	}
	
	
	
	

}
