package com.project.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.project.pom.CartPage;
import com.project.pom.CheckoutPage;
import com.project.pom.InventoryPage;
import com.project.pom.LoginPage;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class OrderProductWithHigherPrice extends BaseTest { 


  /*@BeforeMethod
  public void beforeMethod() {
	  loginPage = new LoginPage(driver);
	  //driver = loginPage.chromeDriverConnection();
	  driver = loginPage.firefoxDriverConnection();
	  loginPage.visit("https://www.saucedemo.com/index.html");
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }*/
  
  @Test
  public void test() throws InterruptedException {

	  LoginPage loginPage = new LoginPage(driver);
	  InventoryPage inventoryPage = new InventoryPage(driver);
	  CartPage cartPage = new CartPage(driver);
	  CheckoutPage checkoutPage = new CheckoutPage(driver);
	  
	  //Loguearse
	  loginPage.Login();
	  AssertJUnit.assertTrue(inventoryPage.isHomePageDisplayed());
	  
	  //Agregar al carrito el artículo con el precio más alto
	  inventoryPage.selectItemWithHigherPrice();
	  AssertJUnit.assertTrue(inventoryPage.isItemSelected());
	  inventoryPage.selectShoppingCartLink();
	  AssertJUnit.assertTrue(cartPage.isYourCartTitleDisplayed());
	  
	  //Dirigirse a Checkout y agregar un nombre, apellido, zip code
	  cartPage.checkout();
	  AssertJUnit.assertTrue(checkoutPage.isYourInformationTitleDisplayed());
	  checkoutPage.fillOutCheckoutForm();
	  
	  //Validar que la orden se complete con éxito
	  AssertJUnit.assertTrue(checkoutPage.isOverviewTitleDisplayed());
	  checkoutPage.finishCheckout();
	  AssertJUnit.assertTrue(checkoutPage.isCompleteHeaderDisplayed());
	  
  }

}
