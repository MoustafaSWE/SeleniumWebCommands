import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class T10_GestureFeature {

    WebDriver driver = null;
    JavascriptExecutor js = (JavascriptExecutor)driver;


    @Test
    public void scrollDown () throws AWTException {

        // Way 1: By using JavaScriptExecutor
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Way 2: By pressing ctrl+end
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        // Way 3: By using Java Robot class
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);


    }



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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // 4- Navigate to website
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

        // driver.quit  !=  driver.close
    }
}
