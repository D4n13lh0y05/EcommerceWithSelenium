package com.project.pom;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBase{
	
	By yourCartTitle = By.xpath("//span[@class='title' and text()='Your Cart']");
	By checkoutBtn = By.id("checkout");
	WebDriverWait wait = null;

	
public CartPage(WebDriver driver) {
	super(driver);
	wait = new WebDriverWait(driver,30);
}


public boolean isYourCartTitleDisplayed() {
	wait.until(ExpectedConditions.presenceOfElementLocated(yourCartTitle));
	return isDisplayed(yourCartTitle);
}


public void checkout() {
	click(checkoutBtn);
	
}

}
