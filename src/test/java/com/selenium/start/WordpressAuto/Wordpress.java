package com.selenium.start.WordpressAuto;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Wordpress {
	WebDriver driver;

	@Test
	public void f() {

		LoginClass log = new LoginClass(driver);
		log.login();

		DashboardClass das = new DashboardClass(driver);
		das.post();
	}

	@Parameters({"bro"})
	@BeforeTest
	public void b(String xyz) {
		String browser=xyz;
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new RuntimeException("browser that has been specified is not available or incorrely spelled") ;
		}
		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void c() {
		driver.quit();
	}

}
