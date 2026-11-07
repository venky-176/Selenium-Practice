package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver alert = new ChromeDriver();
        alert.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        Thread.sleep(1000);
        // Alert box
        System.out.println(alert.findElement(By.id("output")).getText());
        alert.findElement(By.id("alertBox")).click();
        Thread.sleep(1000);
        System.out.println(alert.switchTo().alert().getText());
        alert.switchTo().alert().accept();
        Thread.sleep(1000);
        System.out.println(alert.findElement(By.id("output")).getText());


        //Confirm Box
        Thread.sleep(1000);
        alert.findElement(By.id("confirmBox")).click();
        Thread.sleep(1000);
        System.out.println(alert.switchTo().alert().getText());
        alert.switchTo().alert().dismiss();
        Thread.sleep(1000);
        System.out.println(alert.findElement(By.id("output")).getText());
        //Confirm box accept
        Thread.sleep(1000);
        alert.findElement(By.id("confirmBox")).click();
        Thread.sleep(1000);
        System.out.println(alert.switchTo().alert().getText());
        alert.switchTo().alert().accept();
        Thread.sleep(1000);
        System.out.println(alert.findElement(By.id("output")).getText());


        //prompt box
        Thread.sleep(1000);
        alert.findElement(By.id("promptBox")).click();
        Thread.sleep(1000);
        System.out.println(alert.switchTo().alert().getText());
        alert.switchTo().alert().sendKeys("venkat");
        Thread.sleep(1000);
        alert.switchTo().alert().accept();
        Thread.sleep(1000);
        System.out.println(alert.findElement(By.id("output")).getText());

        alert.quit();
    }
}
