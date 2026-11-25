import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {
    WebDriver driver = new ChromeDriver();
    @Test
    public void testGoogle()throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.findElement(By.className("gLFyf")).sendKeys("facebook", Keys.ENTER);
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        //driver.quit();
    }

    @Test
    public void testFacebook(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@id='_R_c9l6neappb6amH1_']")).sendKeys("leetcode",Keys.ENTER);
        String output="The password you've entered is incorrect.";
        Assert.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'entered is incorrect.')]")).getText(),output,"enter the password");
    }
}
