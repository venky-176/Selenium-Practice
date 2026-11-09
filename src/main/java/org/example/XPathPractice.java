package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class XPathPractice {
    public static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().window().maximize();
        //Atribute();
        //operator();
        //conditons();
        //indexes();
        functions();
    }

    public static void highlight(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    // XPath using Attributes
    public static void Atribute() {
        driver.get("https://www.geeksforgeeks.org/cpp/c-plus-plus/#practice");
        highlight(driver.findElement(By.xpath("//img[@class='gfgLogoImg normal']")));
        driver.findElement(By.xpath("//img[@alt='search icon']")).click();
    }

    //XPath Operators
    public static void operator() {
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("venkat");
        System.out.println(driver.findElement(By.xpath("//input[@maxlength=10]")).getAttribute("value"));
        List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength>0]"));
        for (WebElement element : elements) {
            highlight(element);
        }
    }

    //XPath Conditions
    public static void conditons() {
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        List<WebElement> cond = driver.findElements(By.xpath("//input[@maxlength>10 and @name='namee' or @type='tet']"));
        System.out.println(cond.size());
        List<WebElement> cond1 = driver.findElements(By.xpath("//input[@maxlength>0 and @name='name' or @type='te t']"));
        System.out.println(cond1.size());
    }

    // XPath with Index
    public static void indexes() {
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[15]")));
    }

    //XPath Functions
    static void functions() {
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        //highlight(driver.findElement(By.xpath("//a[text()='Sign in']")));
        highlight(driver.findElement(By.xpath("//a[contains(text(),'in into')]")));// usually the original text is Sign into account
        highlight(driver.findElement(By.xpath("//div[contains(@class ,'signin')]")));// here we used attribute for finding an element
        highlight(driver.findElement(By.xpath("//a[starts-with(text(),'Sign in ')]")));// starts with function


    }
}
