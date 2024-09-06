package com.magneto.stepdefinitions;



import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.magneto.pages.LoginPage;
import com.magneto.pages.SignupPage;
import com.magneto.utils.BrowserUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps 
{
	WebDriver driver = BrowserUtils.initializeDriver();
    SignupPage signupPage = new SignupPage(driver);
    LoginPage loginPage = new LoginPage(driver); 
	 
  // Scenario1:
    
    @Given("User is on the Signup page")
    public void userIsOnTheSignupPage()  {
        signupPage.openSignupPage();
    }
    @When("User enters valid details")
    public void userEntersValidDetails() {
        signupPage.enterDetails("Kajal", "Karale", "kkworld206@gmail.com", "#Kajal@123","#Kajal@123");
    }
    @When("User submits the signup form")
    public void userSubmitsTheSignupForm() {
        signupPage.submitForm();
    }
    @Then("User should be redirected to the dashboard")
    public void userShouldBeRedirectedToTheDashboard(){
    	WebElement dashboard = driver.findElement(By.cssSelector(".dashboard-class"));
        Assert.assertTrue("User is not redirected to the dashboard", dashboard.isDisplayed());
    }
    
     
    //Scenario 2
    @Given("User is on the Login page")
    public void userIsOnLoginPage() {
        // Code to navigate to the login page
        loginPage.openLoginPage(); // Example method
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        loginPage.enterCredentials("kkworld206@gmail.com", "#Kajal@123");
    }
    @When("User submits the login form")
    public void userSubmitsTheLoginForm() {
        loginPage.submitLogin();
    }
    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        // Add assertion to check login success
        Assert.assertTrue(driver.findElement(By.xpath("(.//span(text()='My Account')")).isDisplayed());
    }
    
    //Scenarion 3 
    @When("User enters details with an already registered email")
    public void userEntersDetailsWithAnAlreadyRegisteredEmail() {
        signupPage.enterDetails("Kajal","Karale","kkworld206@gmail.com", "#Kajal@123","#Kajal@123");
    }
    @Then("An error message should be displayed indicating the email is already in use")
    public void anErrorMessageShouldBeDisplayedIndicatingTheEmailIsAlreadyInUse() {
        // Add assertion for duplicate email error
        Assert.assertTrue(driver.findElement(By.id("error-message")).getText().contains("Email already in use"));
    }
    
    //Scenario 4:
    
    @When("User enters valid details but with a weak password")
    public void userEntersValidDetailsButWithAWeakPassword() {
        signupPage.enterDetails("Kajal", "Karale", "kkworld206@gmail.com", "kajal12345","kajal2345");
        
    }
    @Then("An error message should be displayed indicating the password is too weak")
    public void anErrorMessageShouldBeDisplayedIndicatingThePasswordIsTooWeak() {
        // Add assertion for weak password error
        Assert.assertTrue(driver.findElement(By.id("error-message")).getText().contains("Password is too weak"));
    }
}



