package com.magneto.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	 private WebDriver driver;
	    private WebDriverWait wait;

	    // Locators
	    private By firstNameField = By.xpath(".//input[@id='firstname']");
	    private By lastNameField = By.id("lastname");
	    private By emailField = By.name("email"); 
	    private By passwordField = By.name("password");
	    private By confirmPassField = By.name("password_confirmation");
	    private By submitButton = By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]");
	    private By errorMessage = By.xpath(".//div[@class='message-error error message']");

	    // Constructor
	    public SignupPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
	    }

	    // Open Signup Page
	    public void openSignupPage() {
	        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)); // Wait for the page to load
	    }

	    // Enter Details
	    public void enterDetails(String firstName, String lastName, String email, String password, String confirmPass) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassField)).sendKeys(confirmPass);
	    }

	    // Submit Form
	    public void submitForm() {
	        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	    }
	    //Get error msg
        public String getErrorMessage()
        {
        return driver.findElement(errorMessage).getText();
    }
}



