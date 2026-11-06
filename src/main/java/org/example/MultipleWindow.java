package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindow  {
    public static void main(String[] args) throws InterruptedException {
        WebDriver window = new ChromeDriver();
        window.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Thread.sleep(1000);
         // Single window
        String parentWindow= window.getWindowHandle();
        System.out.println("parent window handle"+parentWindow+window.getCurrentUrl());
        window.findElement(By.id("newWindowBtn")).click();
        Set<String> handles=window.getWindowHandles();
        for (String url : handles){
            if(!url.equals(parentWindow)){
            window.switchTo().window(url);
            window.manage().window().maximize();
            window.findElement(By.id("firstName")).sendKeys("Venkat");
            Thread.sleep(2000);
            window.close();// used to close present window or url
            }
            // System.out.println(url+window.getTitle());
        }
        window.switchTo().window(parentWindow);
        window.findElement(By.id("name")).sendKeys("venkata jaya praksha");
        Thread.sleep(2000);
        window.quit();// close the whole application
    }
}
