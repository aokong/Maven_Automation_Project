package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_Mcalc_Scroll {
    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome windows
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");
        //for mac use "start-fullscreen"
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //navigate to mlcalc main page
        driver.navigate().to("https://www.mlcalc.com");
        //wait 3 seconds
        Thread.sleep(3000);
        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        //scroll down 800 pixels
//        jse.executeScript("scroll(0,800)");
//        //wait 2 seconds
//        Thread.sleep(2000);
//        //scroll up 400 pixels
//        jse.executeScript("scroll(0,-400)");
//        //wait 2 seconds
//        Thread.sleep(2000);

        //declare calculate button into webelement variable
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of the calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //wait 2 seconds
        Thread.sleep(2000);
        //quit chrome
        driver.quit();



    }
}
