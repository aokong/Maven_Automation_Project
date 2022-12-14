package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions_USPS {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the Chrome windows
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");
        //for mac use "start-fullscreen"
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver (browser) to use for automation
        WebDriver driver = new ChromeDriver(options);
        //navigate to website main page
        driver.navigate().to("https://www.usps.com");
        //wait 2s
        Thread.sleep(2000);

        //hover over to Send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        //declare mouse actions
        Actions actions = new Actions(driver);
        //always end with .perform()
        actions.moveToElement(sendTab).perform();

        Thread.sleep(1000);
        //click on calculate a price using mouse click
        WebElement calculatePrice = driver.findElement(By.xpath("//li[@class='tool-calc']"));
        actions.moveToElement(calculatePrice).click().perform();

        Thread.sleep(2000);
        //store usps home element as web element
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));
        //right-clicking on usps home logo
        actions.moveToElement(uspsHome).contextClick().perform();
        //double-clicking on usps home logo
        actions.moveToElement(uspsHome).doubleClick().perform();


    }//end of main
}//end of java class
