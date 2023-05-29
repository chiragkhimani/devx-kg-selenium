package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Wait for each command to get success response till 60 sec maximum
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //  1. Open Website
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement inputBox = driver.findElement(By.id("file-upload"));
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));

        String currentDir = System.getProperty("user.dir");

        inputBox.sendKeys(currentDir + "/cat-no.gif");
        uploadBtn.click();

        driver.get("https://the-internet.herokuapp.com/download");

        WebElement fileDownload = driver.findElement(By.xpath("//a[text()='cat-no.gif']"));
        System.out.println(fileDownload.isDisplayed());
        fileDownload.click();
    }
}
