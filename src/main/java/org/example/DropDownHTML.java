package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHTML {
    public static void main(String[] args) throws InterruptedException {
        WebDriver drpdwn= new ChromeDriver();
        drpdwn.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        Thread.sleep(3000);
        WebElement course=drpdwn.findElement(By.id("course"));
        Select corsel = new Select(course);// here we used this because  we wanna test the web on dropdown options
        corsel.selectByValue("java");
        Thread.sleep(2000);
        corsel.selectByIndex(3);
        Thread.sleep(2000);
        corsel.selectByVisibleText("Javascript");
        Thread.sleep(2000);

        WebElement ide = drpdwn.findElement(By.id("ide"));
        Select idel= new Select(ide);
        idel.selectByIndex(1);
        Thread.sleep(1000);
        idel.selectByValue("vs");
        Thread.sleep(1000);
        idel.deselectByValue("ij");

    }
}
