package Walmart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homepage {
    WebDriver driver;
    String walmartURL = "https://www.walmart.com/";

    @BeforeMethod
            public void setup()

    {

        String browserDriverPath = "Webdriver/mac/chromedriver";

        System.setProperty("webdriver.chrome.driver", browserDriverPath);
         driver = new ChromeDriver();
    }
    @Test
            public void checkTittle() throws InterruptedException {

        driver.get(walmartURL);
        String expectedTittle = "Walmart.com | Save Money. Live Better.";
        String actualTittle = driver.getTitle();
        Assert.assertEquals(actualTittle, expectedTittle, "Test fail.Tittle does not match");
        Thread.sleep(5000);

    }


    @AfterMethod
    public void tearDown(){
        //driver.close();
        driver.quit();
    }

}



