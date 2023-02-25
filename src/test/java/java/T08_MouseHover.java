package java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class T08_MouseHover {

//    Don't apply Thread.sleep -> it is for you to see the execution ; remove it once you learn the script's purpose

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        //1- Define Bridge
        WebDriverManager.chromedriver().setup();

        // 2- Create new object from chromedriver
        driver = new ChromeDriver();

        // 3- Configuration
        //3.1- Maximize browser
        driver.manage().window().maximize();

        //3.2- Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 4- Navigate to website
        driver.get("https://the-internet.herokuapp.com/hovers");
    }


    @Test(priority = 1)
    public void HandlingTwoTabs() throws InterruptedException {

        // 1- Create object from Actions class (in Selenium)
        Actions action = new Actions(driver);

        WebElement image = driver.findElement(By.cssSelector("img[src=\"/img/avatar-blank.jpg\"]"));
        action.moveToElement(image).perform();

        Thread.sleep(4000);

        driver.findElement(By.cssSelector("a[href=\"/users/1\"]")).click();

    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
