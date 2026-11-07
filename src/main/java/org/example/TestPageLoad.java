package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

// PageLoadTime: The time needed to open/load  a web page
// it depends on internet speed or size of the page or content of the pages
// we need pageloadtimeout cause to set the limit of time needed to load the page

public class TestPageLoad {
    public static void main(String[] args) throws Exception {
        WebDriver page = new ChromeDriver();

        page.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));// if we wanna set the timeout of our own choice

        Instant start = Instant.now();
        System.out.println(start.toString());
        page.get("https://www.google.com/");
        Instant end = Instant.now();
        System.out.println(end.toString());
        Duration duration = Duration.between(start, end);
        System.out.println("total duration to open the page: " + duration.toMillis());
        System.out.println(page.getTitle());
        page.quit();
    }
}
