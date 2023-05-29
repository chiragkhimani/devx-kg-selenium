package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DemoClass5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Wait for each command to get success response till 60 sec maximum
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //  1. Open Website
        driver.get("https://www.ebay.com/");

        // Create web element using select tag
        WebElement dropdown = driver.findElement(By.id("gh-cat"));

        // Wrap that web element using select class methods
        Select catDropdown = new Select(dropdown);

        // Select the option by using text
        catDropdown.selectByVisibleText("Baby");
        catDropdown.selectByIndex(12);
        catDropdown.selectByValue("58058");

        List<WebElement> allOption = catDropdown.getOptions();

        for(WebElement option : allOption){
            System.out.println(option.getText());
        }
    }
}
