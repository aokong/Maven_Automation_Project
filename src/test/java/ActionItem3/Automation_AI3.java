package ActionItem3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI3 {
    public static void main(String[] args) throws InterruptedException {

        //create an array list for zip codes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11365");
        zipCode.add("11790");
        zipCode.add("10001");


        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing and incognito
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);


        //navigate to weight watchers website
        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
        //start of for loop
        for (int i = 0; i < zipCode.size(); i++){

            //sleep statement
            Thread.sleep(500);
            //Click on Find a Workshop
            driver.findElement(By.xpath("//*[text() = 'Find a Workshop']")).click();
            //click on In Person
            driver.findElement(By.xpath("//*[@class = 'iconWrapper-1dvW4']")).click();
            //sleep statement
            Thread.sleep(500);
            //store locator for searchZip as a web element variable
            WebElement searchZip = driver.findElement(By.xpath("//*[@id = 'location-search']"));
            //clear the field
            searchZip.clear();
            //enter zip code
            searchZip.sendKeys(zipCode.get(i));
            //click on search arrow
            driver.findElement(By.xpath("//*[@class = 'rightArrow-daPRP']")).click();
            //sleep statement
            Thread.sleep(500);

            //create array list web element for the links
            ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkUnderline-1_h4g']")));

            //if else statement for determining which link to click
            if (i==0){
                links.get(1).click();
            } else if (i==1){
                links.get(2).click();
            } else {
                links.get(0).click();
            }

            //sleep statement
            Thread.sleep(500);
            //used absolute because it was difficult to find a unique relative property
            //got the text for the element and stored as strings
            String addressLineOne = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[2]/div/div[2]/div[1]/div[1]")).getText();
            String addressLineTwo = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[2]/div/div[2]/div[1]/div[2]")).getText();
            //print out the address
            System.out.println("Weight Watchers address near " + zipCode.get(i) + " is: ");
            System.out.println(addressLineOne);
            System.out.println(addressLineTwo);
            System.out.println();

            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //find the schedule element and declare the schedule as a web element
            WebElement scheduleChart = driver.findElement(By.xpath("//*[@id = 'studioWorkshopSchedule']"));
            //scroll into view of the schedule
            jse.executeScript("arguments[0].scrollIntoView(true);",scheduleChart);
            //get text from schedule and store as string
            String scheduleText = scheduleChart.getText();
            //print out the schedule text
            System.out.println(scheduleText);
            System.out.println();



        }//end of for loop
        driver.quit();

    }//end of main
}//end of java class
