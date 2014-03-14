package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	private WebDriver driver;

		public HomePage(WebDriver driver) {
			this.driver = driver;
		}

		public void search(String searchItem){
			WebElement searchBox = driver.findElement(By.id("searchInput"));
			searchBox.sendKeys(searchItem);
			searchBox.submit();
		}

		public void addToCart(){
			driver.findElements(By.linkText("Emporio Armani")).get(0).click();
			driver.findElement(By.id("AddToCart")).click();
		}
		
		
	}

