package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome windows
        options.addArguments("start-fullscreen", "incognito");
        //options.addArguments("headless");
        //for mac use "start-fullscreen"
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo main page
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(3000);

        driver.findElements(By.xpath("//*[contains(@class, '_yb_sc88r')]")).get(1).click();
    }
}
