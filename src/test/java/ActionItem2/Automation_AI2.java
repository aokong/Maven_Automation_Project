package ActionItem2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Automation_AI2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> nflStars = new ArrayList<>();
        nflStars.add("Cooper Kupp");
        nflStars.add("Saquon Barkley");
        nflStars.add("Patrick Mahomes");
        nflStars.add("Tom Brady");

        //define the web driver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for an automation
        WebDriver driver = new ChromeDriver();

        for (int i=0; i < nflStars.size(); i++) {

            //navigate to the google site
            driver.navigate().to("https://www.bing.com");

            //wait a few seconds
            Thread.sleep(1500);

            //maximize my window
            //for mac: driver.manage().window().fullscreen();
            //for windows
            //driver.manage().window().maximize();

            //sleep statement
            //Thread.sleep(1000);

            //search a keyword on the search field
            //relative xpath to locate the element
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(nflStars.get(i));
            //hit submit on the google search button
            driver.findElement(By.xpath("//*[@viewBox='0 0 25 25']")).click();

            //sleep statement
            Thread.sleep(1000);

            //capture the search result text
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            String[] splitResult = result.split(" ");
            System.out.println("The number of search results for " + nflStars.get(i) + " is " + splitResult[0] + ".");


        }//end of for loop

        //quit the driver to end the session
        driver.quit();


    }//end of main
}//end of java class
