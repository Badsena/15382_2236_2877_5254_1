package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

        WebDriver driver = new ChromeDriver(options);

        try {
            
            driver.get("https://practicetestautomation.com/practice-test-login/");

        
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("student");

            
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password123");

            
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='submit']"));
            loginButton.click();

        
            Thread.sleep(3000);
            System.out.println(driver.getTitle());

        } catch (Exception e) {
            System.out.println("Login failed");
            e.printStackTrace();
        } finally {
            driver.quit();
            System.exit(0); 
        }
    }
}
