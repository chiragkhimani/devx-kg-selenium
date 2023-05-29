package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingFrame {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get("https://the-internet.herokuapp.com/iframe");


        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));

        // Switch to iframe
        driver.switchTo().frame(iFrame);

        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Phone");

        // Change focus from frame to browser
        driver.switchTo().defaultContent();

        WebElement element = driver.findElement(By.xpath("//h3"));
        System.out.println(element.getText());
    }
}
