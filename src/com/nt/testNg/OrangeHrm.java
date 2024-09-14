package com.nt.testNg;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//@Listeners(com.nt.testNg.MyListener.class)
public class OrangeHrm {
 WebDriver driver;
 
	 @BeforeClass
     public void openApplication() throws Exception{
    	 driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	driver.manage().window().maximize();
    	Thread.sleep(2000);
        }
	  
   public  void testLogo()throws Exception {
    	WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
    	boolean bol=logo.isDisplayed();
    	if(bol==true) {
    		System.out.println(" u r navigate to Corrent Appplication");
    		Thread.sleep(2000);
    	}
    	else {
    		System.out.println(" u r not navigate to Corrent Appplication");
    		driver.close();
    	   }
    }
       @Test(priority=1)
      public void verifyTittle() {
    	   String exp_title="OrangeHRMs";
    	     String actula_title=driver.getTitle();
    	  //if(exp_title.equals(actula_title)) {
    		/*  System.out.println("title is matched");
    	  }
    	  else
    	  {
    		  System.out.println("title is not matched");
    		  String actual_title=driver.getTitle();
    	  }
    	 *///In this there is no testFialis 
    		   //if u title is not matched then test fails then goe AssertMethods
    		 // Assert.assertEquals(actula_title,exp_title);
    	       SoftAssert sa=new SoftAssert();
    	       sa.assertEquals(actula_title,exp_title);
    		  System.out.println(driver.getTitle());
    		  sa.assertAll();
         }
	  @BeforeMethod
     public void loginApp()throws Exception {
       driver.findElement(By.name("username")).sendKeys("Admin");
       driver.findElement(By.name("password")).sendKeys("admin123");
       WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
       loginButton.click();  
       Thread.sleep(2000);
       System.out.println("login successfull");
      }
	  @AfterMethod
     public void logout()throws Exception {
    	driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
    	WebElement logout_link=driver.findElement(By.xpath("//a[text()='Logout']"));
    	Actions ac=new Actions(driver);
    	ac.moveToElement(logout_link);
    	logout_link.click();
    	Thread.sleep(2000);
    	System.out.println("logoutsuccessFull");
    }
	  @Test(priority=2,dependsOnMethods={"verifyTittle"})
	 public void addEmployee()throws Exception {
		  try {
		  driver.findElement(By.xpath("//span[text()='PIM']")).click();
		  Thread.sleep(2000);
		  System.out.println("moving to pim module");
		  }
		  catch(Exception e) {
			  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  File dest=new File("G:/WorkSpeace/seleniunm/suresh715/pratice/TestNGProject/vasu.png");
			 FileUtils.copyFile(file,dest);
		  }
		  
	  }
    @AfterClass
    public void closeApp() {
    	driver.close();
    }
  
}
