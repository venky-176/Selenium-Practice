package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPractice {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        int day=17;

        //First Calendar
        driver.findElement(By.xpath("//input[@id='first_date_picker']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()=12]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='first_date_picker']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+day+"]")).click();
        Thread.sleep(2000);


        //Second Calendar
        driver.findElement(By.xpath("//input[@id='second_date_picker']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' ui-datepicker-other-month '))]/a[text()=17]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='second_date_picker']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' ui-datepicker-other-month '))]/a[text()="+day+"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='second_date_picker']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")).click();
        Thread.sleep(2000);
    }
}
