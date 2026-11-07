package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// the amount of time need for the selenium to find out the element, provided implicitly by us.
// We provide implicitly cause selenium driver will not check the element that much ut will actually throw an exception

public class ImplicitTimeWait {
    public static void main(String[] args) throws Exception {
        WebDriver implicit = new ChromeDriver();
        implicit.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        implicit.get("https://www.hyrtutorials.com/p/waits-demo.html");
        implicit.findElement(By.id("btn1")).click();
        implicit.findElement(By.id("txt1")).sendKeys("venkat");

        implicit.findElement(By.id("btn2")).click();
        implicit.findElement(By.id("txt2")).sendKeys("venkat2");
    }
}
