package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver wb = new ChromeDriver();
        //WebDriver me = new EdgeDriver();
        //Till Selenium 4.6 we need to use separate Driver.executable for each web page
        // after 4.6, it is auto implemented using Selenium manager
        //
        wb.get("https://github.com/login");
        System.out.printf(wb.getTitle());
        Thread.sleep(3000);
        wb.findElement(By.id("login_field"));
        Thread.sleep(3000);
        wb.findElement(By.name("commit"));
        Thread.sleep(3000);
        wb.findElement(By.className("label-link position-absolute top-0 right-0"));
        Thread.sleep(3000);
        wb.findElement(By.linkText("Create an account"));

        wb.quit();
        //me.get("https://www.google.com/");


    }
}