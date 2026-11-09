package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

//We use ExplicitWait for the webdriver to findout for dynamic elements, unlike implicit if we declare once it will be applied to all
// Here it will for certain elements, not for all elements
// we can use 2 type of explicit like, WebDriverWait, FluentWait
public class ExplicitWait {
    public static void main(String[] args) throws Exception {
        WebDriver explicit = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(explicit, Duration.ofSeconds(10));

        explicit.get("https://testproject.io/");
        String parent = explicit.getWindowHandle();
        explicit.findElement(By.id("login")).click();
        Set<String> windows = explicit.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parent)) {
                explicit.switchTo().window(window);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

                Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.findElement(By.id("username")).isDisplayed();
                    }
                };
                wait.until(func);
                explicit.findElement(By.id("username")).sendKeys("Venkat");
            }
        }
    }
}
