package Walmart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WalmartTesting {

        WebDriver driver;
        String walmartURL = "https://www.walmart.com/";

        @BeforeMethod
        public void setup()

        {

            String browserDriverPath = "Webdriver/mac/chromedriver";

            System.setProperty("webdriver.chrome.driver", browserDriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }
        @Test(enabled = false)
        public void checkTittle() throws InterruptedException {

            String expectedTittle = "Walmart.com | Save Money. Live Better.";
            String actualTittle = driver.getTitle();
            Assert.assertEquals(actualTittle, expectedTittle, "Test fail.Tittle does not match");
            Thread.sleep(5000);

        }


        @Test(enabled = false)
        public void searchBox() throws InterruptedException {
            driver.get(walmartURL);
            driver.findElement(By.id("global-search-input")).sendKeys("masks");
           Thread.sleep(3000);
           driver.findElement(By.xpath("//*[@id=\"global-search-submit\"]/span")).click();
           Thread.sleep(5000);
           String expectedTittle = "masks - Walmart.com";
           String actualTittle=driver.getTitle();
           Assert.assertEquals("","","Test fail");


        }

        @Test(enabled = false)
        public void searchBox1() throws InterruptedException {
            driver.get(walmartURL);
            driver.findElement(By.id("global-search-input")).sendKeys("shampoo");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"global-search-submit\"]/span")).click();
            Thread.sleep(6000);
            String expectedTittle = "shampoo - Walmart.com";
            String actualTittle= driver.getTitle();
            Assert.assertEquals("","","Test fail");
        }


    @Test(enabled = true)
    public void login(){
            driver.get(walmartURL);
            driver.findElement(By.xpath("//*[@id=\"hf-account-flyout\"]/span/span/span[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"vh-account-menu-root\"]/div[2]/div/a[1]/div/span/div")).click();
            driver.findElement(By.xpath("//*[@id=\"email\"]"));
            driver.findElement(By.xpath("//*[@id=\"password\"]"));


    }

        @AfterMethod
        public void tearDown(){
            //driver.close();
            driver.quit();
        }
}
