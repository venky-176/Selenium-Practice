package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver navg = new ChromeDriver();
        navg.get("https://www.google.com/");
        Thread.sleep(2000);
        navg.findElement(By.name("q")).sendKeys("election");
        navg.findElement(By.name("q")).submit();
        Thread.sleep(2000);
        // we have navigate method in selenium to perform actions like to, back, forward page , refresh page
        //navigate is a method  to perform above functions.
        navg.navigate().to("https://www.facebook.com/");
        Thread.sleep(2000);
        navg.findElement(By.name("email")).sendKeys("test@gmail.com");
        Thread.sleep(2000);
        navg.navigate().refresh();
        Thread.sleep(2000);
        navg.navigate().back();
        Thread.sleep(2000);
        navg.navigate().forward();
        navg.quit();
    }
}
