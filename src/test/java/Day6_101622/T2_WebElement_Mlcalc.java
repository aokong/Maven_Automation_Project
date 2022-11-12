package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Mlcalc {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome windows
        //options.addArguments("start-fullscreen", "incognito");
        //options.addArguments("headless");
        //for mac use "start-fullscreen"
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo main page
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(3000);

        //clear and enter a new value on puircahse pirce field
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        pPrice.clear();
        pPrice.sendKeys("450000");

        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
        dPayment.clear();
        dPayment.sendKeys("25");

        Thread.sleep(2000);
        driver.quit();

    }//end of main
}//end of java class
