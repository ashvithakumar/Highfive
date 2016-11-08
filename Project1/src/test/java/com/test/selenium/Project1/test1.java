package com.test.selenium.Project1;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class test1 {

  
  
  public static void main(String[] args) throws InterruptedException {
   
	  String title = "hello";
	  String body = "welcome";
  
    System.setProperty("webdriver.chrome.driver", "/Users/ashvithavenkateshkumar/Downloads/chromedriver");
    WebDriver driver = new ChromeDriver();              
   
    //open site and maximize
    driver.get("https://www.guerrillamail.com/");
    driver.manage().window().maximize();
    
    //click on compose new email and click button copy to clipboard
//    driver.findElement(By.id("copy_to_clip")).click();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("nav-item-compose")).click(); 
    
 
    
    //copy text from email-widget
    Actions actions= new Actions(driver);
    WebElement copy = driver.findElement(By.id("email-widget"));
    copy.click();
    String result = driver.findElement(By.id("email-widget")).getAttribute("innerText");
//    System.out.println(result);
  //actions.contextClick(copy).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "c")).build().perform();
  //driver.findElement(By.className("outline")).sendKeys(Keys.chord(Keys.COMMAND, "c"));
  
//  actions.contextClick(copy).sendKeys(Keys.chord(Keys.COMMAND, "c")).build().perform();
//  Thread.sleep(3000);
//  actions.contextClick(copy).sendKeys(Keys.chord(Keys.CONTROL, "c")).build().perform();
//  Thread.sleep(3000);
 // actions.contextClick(copy).sendKeys(Keys.chord(Keys.COMMAND, "c")).build().perform();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    
    //clear the to field and paste text from clipboard
    driver.findElement(By.name("to")).clear();
    WebElement element2 = driver.findElement(By.name("to"));
    // element2.click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    actions.contextClick( driver.findElement(By.name("to"))).sendKeys(Keys.chord(Keys.COMMAND, "v")); 
//     Thread.sleep(1000);
      driver.findElement(By.name("to")).sendKeys(result);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
     driver.findElement(By.name("subject")).sendKeys(title);
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     driver.findElement(By.name("body")).sendKeys(body); 
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     driver.findElement(By.name("send")).click();
     Thread.sleep(15000);
    
     
     //Verify the title and  body of the sent email
     driver.findElement(By.xpath(".//*[@id='email_list']/tr[1]/td[3]")).click();
     String bodyText = driver.findElement(By.name("body")).getText();
     Assert.assertTrue(body, bodyText.contains(body));
//     
     
     
     //Delete
//    driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div[2]/form/table/tbody/tr[1]/td[1]/input")).click();
//     Thread.sleep(1000);
//    driver.findElement(By.id("del_button")).click();
//    Thread.sleep(1000);
//    driver.quit();
  }
}
    
    
    ////////////////////////////////////////////////////////////////////
//  
//    driver.findElement(By.id("Email")).sendKeys("Ashvitha.13");
//    driver.findElement(By.id("next")).click();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    driver.findElement(By.id("Passwd")).sendKeys("gmailpwd@8");
//    driver.findElement(By.id("signIn")).click();
//    driver.findElement(By.xpath("//div[@class='z0']/div")).click();
//    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    
//    driver.findElement(By.cssSelector("html.aAX body.aAU div div.nH.a4O div.nH div.nH.w-asV.aiw div.nH.oy8Mbf.qp div#gb.gb_rf.gb_X.gb_T div.gb_we.gb_wf div.gb_ib.gb_wf.gb_R.gb_vf.gb_X.gb_T div.gb_ic.gb_wf.gb_R div.gb_fb.gb_Ic.gb_wf.gb_R div.gb_tc.gb_hb.gb_wf.gb_R a.gb_b.gb_db.gb_R")).click();
//    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//    driver.findElement(By.xpath("//*[@id='gb_71']")).click();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  