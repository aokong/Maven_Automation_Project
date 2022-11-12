package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_ActionItem {
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

        //create array list of states
        ArrayList<String> states = new ArrayList<>();
        states.add("Minnesota");
        states.add("Mohegan Sun");
        states.add("Texas");
        //array list of adults
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);
        //array list of child age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("Under 1");
        childAge.add("1");
        childAge.add("2");


        for (int i=0;i<states.size();i++){
            //navigate to mortgage calculator website
            driver.navigate().to("https://hotels.com");
            //delay 2s
            Thread.sleep(1000);
            //set travelers adults to 1
            driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            Thread.sleep(1000);
            //click the minus button
            driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(0).click();
            Thread.sleep(1000);
            //click the done button
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();

            //find destination button
            driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
            //enter ith index of states into field
            driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(states.get(i));
            //delay 1s
            Thread.sleep(1000);
            //array list of search results
            ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='is-subText truncate']")));
            //click on the first search result
            searchResults.get(0).click();
            //click on travelers
            driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            Thread.sleep(1000);

            for (int j=0;j<(adults.get(i)-1);j++){
                driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(1).click();
            }//end of adults for loop
            //delay 1s
            Thread.sleep(1000);
            //increase child age to 1 only
            driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
            //web element of child age drop down
            WebElement childAgeDrop = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
            //delay 1s
            Thread.sleep(1000);
            //declare and define select
            Select childAgeDropDown = new Select(childAgeDrop);
            //select the ith index value
            childAgeDropDown.selectByVisibleText(childAge.get(i));
            Thread.sleep(1000);
            //click the done button
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            //click on search button
            driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            //delay 2s
            Thread.sleep(2000);
            //if statement for which link to click
            if (i==0){
                driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")).get(0).click();
            }else if(i==1){
                driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")).get(2).click();
            }else{
                driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")).get(1).click();
            }//end of if else
            //store the tabs in arraylist
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(2000);
            //stored the text for hotel name into a string
            String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
            //print hotel name
            System.out.println(hotelName);
            Thread.sleep(2000);

            //scroll to reserve room area of page
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement reserveRoom = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(1);
            jse.executeScript("arguments[0].scrollIntoView(true);", reserveRoom);

            //click on reserve a room to make page go down
            //driver.findElement(By.xpath("//*[@data-stid='navbar-quick-reserve-button']")).click();

            //store the text for first price per night into a string
            String pricePerNight = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
            //print price
            System.out.println("Price for one night: " + pricePerNight);
            //click reserve
            driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")).get(0).click();
            Thread.sleep(2000);
            //store the text for check in and check out as a string
            String checkInCheckOut = driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
            //print check in and check out text
            System.out.println(checkInCheckOut);
            System.out.println();
            //close the tab
            driver.close();
            //return to original page
            driver.switchTo().window(tabs.get(0));



        }//end of states for loop
        driver.quit();


    }//end of main
}//end of java class
