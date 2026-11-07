package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//In these program we will practice how to handle links, radio buttons and checkboxes using selenium webdriver?

public class ButtonManagement {
    public static void main(String[] args) throws Exception {
        WebDriver but = new ChromeDriver();
        but.get("https://www.hyrtutorials.com/p/basic-controls.html");
        Thread.sleep(3000);
        but.findElement(By.id("femalerb")).click();
        Thread.sleep(3000);
        but.findElement(By.id("englishchbx")).click();
        Thread.sleep(3000);
        WebElement chink = but.findElement(By.id("chinesechbx"));
        chink.click();// checks
        Thread.sleep(3000);
        if (chink.isSelected()) {
            chink.click();
        }
        Thread.sleep(3000);
        but.findElement(By.id("registerbtn"));
        System.out.println(but.findElement(By.id("msg")).getText());
        Thread.sleep(3000);
        but.findElement(By.linkText("Click here to navigate to the home page")).click();


    }
}
