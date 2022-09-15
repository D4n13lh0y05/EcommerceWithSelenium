package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
	
	By userNameLocator = By.id("user-name");
	By passwordLocator = By.id("password");
	By loginBtnLocator = By.id("login-button");
	
public LoginPage(WebDriver driver) {
	super(driver);
}

public void Login() {
	if(isDisplayed(userNameLocator)) {
		type("standard_user",userNameLocator);
		type("secret_sauce",passwordLocator);
		click(loginBtnLocator);
	}else {
		System.out.println("Login Page texbox was not present");
	}
}


}
