package com.magneto.utils;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserUtils
{
	public static WebDriver initializeDriver() {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/driver/chromedriver.exe");
       // return new ChromeDriver();
       WebDriver driver = new ChromeDriver();
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Adjust the timeout as needed
        
        return driver;
    }


}
