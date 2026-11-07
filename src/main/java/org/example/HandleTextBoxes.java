package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTextBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver htp = new ChromeDriver();
        htp.get("https://github.com/login");
        Thread.sleep(2000);
        WebElement usern = htp.findElement(By.id("login_field"));
        if (usern.isDisplayed()) {
            if (usern.isEnabled()) {
                usern.sendKeys("venky-");
                String text = usern.getAttribute("value");
                System.out.println(text);
                Thread.sleep(3000);
                usern.clear();
            } else {
                System.err.println("is not diplayed");
            }
        } else {
            System.err.println("user box is not displayed");
        }
    }
}
