package com.selenium.start.WordpressAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardClass {

	WebDriver driver;
	public DashboardClass(WebDriver driver2) {
		driver=driver2;
	}
	public void post()
    {
    	 WebElement clickPost=  driver.findElement(By.xpath("//div[text()='Posts']"));
         clickPost.click();
    }
}
