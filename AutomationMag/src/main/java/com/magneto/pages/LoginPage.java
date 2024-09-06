package com.magneto.pages;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	 WebDriver driver;
	 WebDriverWait wait;
     By emailField = By.xpath("(.//input[@class='input-text'])[2]");				
     By passwordField =By.name("password");
     By loginButton =By.xpath(".//input[@id='send2']");
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    public void openLoginPage()
    {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    public void enterCredentials(String email, String password) 
    {
    	WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);

    }

    public void submitLogin()
    {
    	WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

}

