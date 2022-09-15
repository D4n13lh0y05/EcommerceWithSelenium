package com.project.pom;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends PageBase{
	
	By inventoryPageLocator = By.xpath("//span[@class='title' and contains(text(),'Products')]");
	By inventoryItemPrice = By.className("inventory_item_price");
	By shoppingCartLink = By.className("shopping_cart_link");
	By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");
	By yourCartTitle = By.className("//span[@class='title']");
	WebDriverWait wait = null;
	
	
public InventoryPage(WebDriver driver) {
	super(driver);
	wait = new WebDriverWait(driver,30);
}

public boolean isHomePageDisplayed() {
	wait.until(ExpectedConditions.presenceOfElementLocated(inventoryPageLocator));
	return isDisplayed(inventoryPageLocator);
}

public void selectItemWithHigherPrice() {
	
	List<WebElement> elementItemPrice = findElements(inventoryItemPrice);
	
	List<Double> prices = new ArrayList<>();
	for (WebElement tag: elementItemPrice) {
	    prices.add(Double.parseDouble(tag.getText().replace("$", ""))); 
	}
	
	By InventoryHigherItemPrice = By.xpath("//div[@class='inventory_item_price' and text()='"+Collections.max(prices)+"']//parent::div[@class='pricebar']//following-sibling::button[@class='btn btn_primary btn_small btn_inventory']");
	click(InventoryHigherItemPrice);
	
}


public boolean isItemSelected() {
	wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartBadge));
	WebElement shoppingCart = findElement(shoppingCartBadge);
	if(Integer.parseInt(shoppingCart.getText()) == 1) {
		return true;
	}else{
		return false;
	}
}

public void selectShoppingCartLink() {
	click(shoppingCartLink);
}


}
