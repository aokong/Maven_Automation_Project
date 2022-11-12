package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T4_GoogleSearch_DataDriven {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> cars = new ArrayList<>();
            cars.add("BMW");
            cars.add("Benz");
            cars.add("Audi");


        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for an automation
        WebDriver driver = new ChromeDriver();

        for (int i = 0; i<cars.size(); i++) {

            //navigate to the google site
            driver.navigate().to("https://www.google.com");

            //wait a few seconds
            Thread.sleep(700);

            //maximize my window
            //for mac: driver.manage().window().fullscreen();
            //for windows
            driver.manage().window().maximize();

            //sleep statement
            Thread.sleep(700);

            //search a keyword on the search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
            //hit submit on the google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //sleep statement
            Thread.sleep(700);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            String[] splitResult = result.split(" ");
            System.out.println("the search number for " + cars.get(i) + " is " + splitResult[1]);

        }//end of for loop

        //quit the driver to end the session
        driver.quit();



    }//end of main
}//end of java class
