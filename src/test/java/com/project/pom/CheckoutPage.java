package com.project.pom;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends PageBase{
	

	WebDriverWait wait = null;
	By yourInformationTitle = By.xpath("//span[@class='title' and text()='Checkout: Your Information']");
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By continueBtn = By.id("continue");
	By overviewTitle = By.xpath("//span[@class='title' and text()='Checkout: Overview']");
	By finishBtn = By.id("finish");
	By completeHeader = By.xpath("//h2[@class='complete-header' and text()='THANK YOU FOR YOUR ORDER']");
	
public CheckoutPage(WebDriver driver) {
	super(driver);
	wait = new WebDriverWait(driver,30);
}


public boolean isYourInformationTitleDisplayed() {
	wait.until(ExpectedConditions.presenceOfElementLocated(yourInformationTitle));
	return isDisplayed(yourInformationTitle);
}

public void fillOutCheckoutForm() {
	type("standard",firstName);
	type("user",lastName);
	type("123456",postalCode);
	click(continueBtn);
}

public boolean isOverviewTitleDisplayed() {
	wait.until(ExpectedConditions.presenceOfElementLocated(overviewTitle));
	return isDisplayed(overviewTitle);
}

public void finishCheckout() {
	click(finishBtn);
}

public boolean isCompleteHeaderDisplayed() {
	wait.until(ExpectedConditions.presenceOfElementLocated(completeHeader));
	return isDisplayed(completeHeader);
}

}
