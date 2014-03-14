package com.demo.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.driver.InitializeDriver;
import com.demo.pages.HomePage;

public class testSearchFunctionality {
	private WebDriver driver;

	@BeforeTest
	public void setUp(){
		InitializeDriver initdriver = new InitializeDriver();
		driver = initdriver.GetAndroidDriver();
		driver.navigate().to("http://m.jabong.com");
	}

	@Test
	public void SearchForItem(){
		HomePage homePage = new HomePage(driver);
		homePage.search("Emporio Armani");
		Assert.assertTrue(driver.findElements(By.linkText("Emporio Armani")).get(0).getText().contains("Emporio Armani"));
	}

	@Test	
	public void ShopForItem(){
		 HomePage homePage = new HomePage(driver);
		 homePage.addToCart();
		 Assert.assertTrue(driver.findElement(By.cssSelector(".header-cart")).getText().equals("1"));
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}
}
