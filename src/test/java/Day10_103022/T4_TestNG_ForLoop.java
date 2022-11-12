package Day10_103022;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T4_TestNG_ForLoop {
    WebDriver driver;
    ArrayList<String> sports = new ArrayList<>();

    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void searchForSport() {
        //add sports to search criteria
        sports.add("Soccer");
        sports.add("Basketball");
        sports.add("Tennis");
        for (int i = 0; i < sports.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //enter a car on search field
            ReusableActions.sendKeysAction(driver, "//*[@name='q']", sports.get(i), "Search Field");
            //hit submit on the google search button
            ReusableActions.submitAction(driver, "//*[@name='btnK']", "Google Search Button");
            //capture result text
            String result = ReusableActions.getTextAction(driver, "//*[@id='result-stats']", "Search Results");
            //split number result
            String[] arrayResult = result.split(" ");
            //print number to console
            System.out.println("Result is: " + arrayResult[1]);
        }//end of for loop
    }//end of test 1
}//end of class
