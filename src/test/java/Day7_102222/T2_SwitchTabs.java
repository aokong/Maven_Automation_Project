package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_SwitchTabs {
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

        //navigate to fidelis main page
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(2000);

        //click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        //wait a bit
        Thread.sleep(2000);

        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text()='Medicaid Managed Care']")).click();
        //wait a bit
        Thread.sleep(2000);

        //click on find a doctor search icon
        driver.findElement(By.xpath("//*[@class = 'btn btn-outline-primary btn-external btn-show link-external']")).click();
        //wait a bit
        Thread.sleep(2000);

        //store the tabs in arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to the new tab
        driver.switchTo().window(tabs.get(1));

        //enter a zip code on the search field
        driver.findElement(By.xpath("//*[@id = 'searchLocation']")).sendKeys("11365");
        //wait a bit
        Thread.sleep(2000);
        //close the find a doctor tab
        driver.close();
        //switch to the initial tab (parent tab)
        driver.switchTo().window(tabs.get(0));

        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(2000);
        //click on get coverage
        driver.findElements(By.xpath("//*[@class = 'btn ng-binding btn-primary']")).get(0).click();
        Thread.sleep(2000);



    }//end of main
}//end of java class
