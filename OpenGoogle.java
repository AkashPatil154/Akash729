package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gurock.testrail.APIException;
import com.qa.testrail.TestRailManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogle {
	
    public static WebDriver driver;
	
	public String testCaseId;
	
	@Test(priority = 1)
    public void Login()throws Exception {
		
		testCaseId = "1";

        WebDriver driver;
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();        
driver.get("https://app.ipos247.com/app2/#/");
		
		driver.manage().window().maximize();
		
		//Thread.sleep(10000);
	  	
		


		/*
		 * jsExecutor.
		 * executeScript("alert('1 :- Test case for login with valid user !')");
		 * Thread.sleep(5000);
		 */
		/*
		 * driver.switchTo().alert().accept(); Thread.sleep(10000);
		 */
	  	// Name Field

	  	driver.findElement(By.name("username")).click();

	  	driver.findElement(By.xpath("//*[@id=\"login-username\"]/input")).sendKeys("makbul");

	  	Thread.sleep(2000);

	  	// Password Field

	  	driver.findElement(By.name("password")).click();

	  	driver.findElement(By.xpath("//*[@id=\"login-password\"]/input")).sendKeys("makbul123");

	  	Thread.sleep(2000);

	  	// Restaurant Code 

	  	driver.findElement(By.name("hotelcode")).click();

	  	driver.findElement(By.xpath("//*[@id=\"login-hotelcode\"]/input")).sendKeys("14607");

	  	Thread.sleep(2000);

	  	// Login Button

	  	driver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();

	  	Thread.sleep(5000);

	  	// Select outlet

	  	driver.findElement(By.xpath("/html/body/ion-app/ng-component/ion-nav/page-terminal-outlet/ion-content/div[2]/div/form/ion-list/ion-item[1]")).click();

	  	Thread.sleep(2000);

	  	driver.findElement(By.xpath("/html/body/ion-app/ion-modal/div/eo-selectable/form/ion-content/div[2]/ion-list/div[2]/ion-item[4]")).click();
//	  	driver.findElement(By.xpath("/html/body/ion-app/ion-modal/div/eo-selectable/form/ion-content/div[2]/ion-list/div[2]/ion-item[3]")).click();

//	  	// Select terminal
//
//	  	driver.findElement(By.xpath("/html/body/ion-app/ng-component/ion-nav/page-terminal-outlet/ion-content/div[2]/div/form/ion-list/ion-item[2]")).click();
//
//	  	Thread.sleep(2000);
//
//	  	driver.findElement(By.xpath("/html/body/ion-app/ion-modal/div/eo-selectable/form/ion-content/div[2]/ion-list/div[2]/ion-item[2]")).click();
//
	  	Thread.sleep(3000);

	  	// Get Me In button

	  	driver.findElement(By.xpath("(//button[@id='login-btn']/span)[2]")).click();

	  	Thread.sleep(5000);
	}


         
 
	
	
	  @Test(priority = 2) 
	  public void Opentab()throws Exception {
	  
	  
	  testCaseId = "2";
	  
		WebDriver driver;
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	  }	
	
	  @AfterMethod
	  public void addResultsToTestRail(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			  TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS, "");
		  }else if(result.getStatus() == ITestResult.FAILURE) {
			  TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS, "Test Failed" + result.getTestName() +" : FAILED" );
		  }
		  
	  }
	
}
	


