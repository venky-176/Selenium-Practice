package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class XPathPractice {
    public static WebDriver driver = new ChromeDriver();
    public static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    public static void main(String[] args) throws InterruptedException {
        driver.manage().window().maximize();
        //Atribute();
        //operator();
        //conditons();
        //indexes();
        //functions();
        axes();
    }

    public static void highlight(WebElement element) {
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
        highlight(driver.findElement(By.xpath("//label[normalize-space(text())='First Name']")));
        highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[last()]")));
    }

    //XPATH Axes Modifiers
    static void axes() throws InterruptedException {
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");

        //JavascriptExecutor js = (JavascriptExecutor) driver;

        jsExecutor.executeScript(
                "let div = document.querySelector('.container');" +
                        "let node = [...div.childNodes].find(n => " +
                        "n.nodeType === Node.TEXT_NODE && n.textContent.includes('Please fill in'));" +
                        "let span = document.createElement('span');" +
                        "span.textContent = node.textContent;" +
                        "span.style.backgroundColor = 'yellow';" +
                        "span.style.border = '2px solid red';" +
                        "node.parentNode.replaceChild(span, node);"
        );

        Thread.sleep(5000);

        driver.findElement(By.xpath("//label[text()='First Name ']/following-sibling:: input[@maxlength=10]")).sendKeys("Venkat");
        Thread.sleep(3000);
        highlight(driver.findElement(By.xpath("//label[text()='First Name ']/preceding-sibling::a[contains(text(),'in into')]")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Reset']/preceding-sibling::button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input")).click();
        Thread.sleep(3000);
        highlight(driver.findElement(By.xpath("//td[text()='Roland Mendel']/parent::tr")));
        Thread.sleep(3000);
        highlight(driver.findElement(By.xpath("//label[text()='Password']/parent::*/parent::*//label")));
        Thread.sleep(3000);
        highlight(driver.findElement(By.xpath("//label[text()='Password']/parent::div/parent::div/label[3]")));
        Thread.sleep(3000);
        highlight(driver.findElement(By.xpath("//div[@id='post-body-299858861183690484']/descendant::div[3]/child::label")));
        Thread.sleep(3000);
        highlight(driver.findElement(By.xpath("//button[text()='Clear']/following::table/child::tbody/child::tr[6]")));
        Thread.sleep(1000);
    }
}
