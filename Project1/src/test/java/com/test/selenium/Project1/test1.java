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
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    //Open site and maximize
    driver.get("https://www.guerrillamail.com/");
    driver.manage().window().maximize();
    
    //Click on compose new email
    driver.findElement(By.id("nav-item-compose")).click(); 
    
    //Copy email link from email-widget
    driver.findElement(By.id("email-widget")).click();;
    String sendTo = driver.findElement(By.id("email-widget")).getAttribute("innerText");
   
    //Clear the to field and the emailID
     driver.findElement(By.name("to")).clear();
     driver.findElement(By.name("to")).sendKeys(sendTo);     
     driver.findElement(By.name("subject")).sendKeys(title);   
     driver.findElement(By.name("body")).sendKeys(body);   
     driver.findElement(By.name("send")).click();
     Thread.sleep(13000);
        
     //Verify the title and body of the sent email
     driver.findElement(By.xpath("//tbody[@id='email_list']/tr[1]/td[3]")).click();  
     String subjText = driver.findElement(By.className("email_subject")).getAttribute("innerText");
     String bodyText = driver.findElement(By.className("email_body")).getText();
     Assert.assertEquals(title, subjText);
     Assert.assertTrue(body, bodyText.contains(body));   
     driver.findElement(By.id("back_to_inbox_link")).click();

    //Delete the sent email
    driver.findElement(By.xpath("//tbody[@id='email_list']/tr[1]/td[1]")).click();
    Thread.sleep(1000);
    driver.quit();
  }
}
    
    
   
