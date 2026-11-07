package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// here we generally use frames for putting html docs inside another html docs
public class FrameTest {
    public static void main(String[] args) throws InterruptedException{
        WebDriver framer = new ChromeDriver();
        framer.get("https://www.hyrtutorials.com/p/frames-practice.html");
        Thread.sleep(1000);
        framer.findElement(By.id("name")).sendKeys("Text1");
        System.out.println(framer.findElement(By.id("name")).getAttribute("value"));
        Thread.sleep(1000);

        //FRAME 1
        framer.switchTo().frame("frm1");// used to go to another html doc in main html doc
        Select coursename= new Select(framer.findElement(By.id("course")));
        coursename.selectByVisibleText("Java");
        System.out.println("course selected: "+coursename.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        framer.switchTo().defaultContent();// it fetches to original page or 1st page


        framer.findElement(By.id("name")).clear();// used to clear the previous text
        framer.findElement(By.id("name")).sendKeys("Text2");
        System.out.println(framer.findElement(By.id("name")).getAttribute("value"));

        // changing between the frames
        Thread.sleep(1000);
        framer.switchTo().frame("frm1");// used to go to another html doc in main html doc
        coursename.selectByVisibleText("Python");
        System.out.println("course selected: "+coursename.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        framer.switchTo().defaultContent();
        Thread.sleep(2000);

        framer.switchTo().frame("frm2");
        framer.findElement(By.id("firstName")).sendKeys("Gonugunta");
        System.out.println("frame 2 first name: "+ framer.findElement(By.id("firstName")).getAttribute("value"));
        Thread.sleep(2000);

        framer.switchTo().defaultContent();
        framer.switchTo().frame("frm1");// used to go to another html doc in main html doc
        coursename.selectByVisibleText("Dot Net");
        System.out.println("course selected: "+coursename.getFirstSelectedOption().getText());
        Thread.sleep(1000);


        framer.switchTo().defaultContent();
        framer.findElement(By.id("name")).clear();// used to clear the previous text
        framer.findElement(By.id("name")).sendKeys("Text3");
        System.out.println(framer.findElement(By.id("name")).getAttribute("value"));
        Thread.sleep(2000);

        //Frame 3 looped frames

        framer.switchTo().frame("frm3");
        Thread.sleep(1000);
        //framer.findElement(By.id("name")).clear();// used to clear the previous text
        framer.findElement(By.id("name")).sendKeys("Text4");
        System.out.println(framer.findElement(By.id("name")).getAttribute("value"));
        Thread.sleep(1000);



        framer.switchTo().frame("frm1");
        Select frm31= new Select(framer.findElement(By.id("course")));
        frm31.selectByVisibleText("Python");
        System.out.println("course selected: "+frm31.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        framer.switchTo().defaultContent();
        Thread.sleep(5000);
        framer.quit();

    }
}
