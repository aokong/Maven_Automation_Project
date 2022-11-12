package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_mlcalc_forloop {
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


        //create sets of array list for purchase price, down payment, interest rate
        ArrayList<String> purchasePrice, downPayment, interestRate;
        purchasePrice = new ArrayList<>();
        purchasePrice.add("350000");
        purchasePrice.add("450000");
        purchasePrice.add("550000");

        downPayment = new ArrayList<>();
        downPayment.add("25");
        downPayment.add("30");
        downPayment.add("35");

        interestRate = new ArrayList<>();
        interestRate.add("3.5");
        interestRate.add("4.0");
        interestRate.add("4.5");

        for (int i = 0; i < purchasePrice.size(); i++) {


            //navigate to yahoo main page
            driver.navigate().to("https://www.mlcalc.com");

            Thread.sleep(3000);

            //clear and enter a new value on purchase price field
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys(purchasePrice.get(i));

            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys(downPayment.get(i));

            WebElement iRate = driver.findElement(By.xpath("//*[@name='ir']"));
            iRate.clear();
            iRate.sendKeys(interestRate.get(i));

            //click on calculate button
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();

            Thread.sleep(3000);

            //capture and print monthly payment value
            String mntPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment: " + mntPayment);

        }//end of for loop

        driver.quit();


    }//end of main
}//end of java class
