package ActionItem4;

import ReusableLibrary.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_AI4 {
    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {driver = ReusableActions.setUpDriver();}
    //end of set driver method

    @AfterSuite
    public void quitTheSession() {driver.quit();}
    //end of after suite

    @Test(priority = 1)
    public void findDoctor(){
        driver.navigate().to("https://www.uhc.com");
        //click on Find a Doctor link
        ReusableActions.clickAction(driver,"//*[contains(@class,'position-relative bg-blueDark')]","Find a Doctor");
        //close pop up window if it shows up
        try {
            WebElement popUp = driver.findElement(By.xpath("//*[@id='layer-container-127097']"));
            if (popUp.isDisplayed()) {
                driver.findElement(By.xpath("//*[@id='ip-no']")).click();;
            }
        } catch (Exception e) {
            System.out.println("Unable to find popup window: " + e);
        }
        //scroll to view by Find a dentist
        ReusableActions.scrollByView(driver, "//*[@href = 'https://connect.werally.com/plans/uhc/375']","Scroll to Find a Dentist");
        //click on find a dentist
        ReusableActions.clickAction(driver,"//*[@href = 'https://connect.werally.com/plans/uhc/375']","Click find a dentist");
        //switch to the new tab
        ReusableActions.switchToTabByIndex(driver,1);
        //click on Employer and Individual Plan
        ReusableActions.clickActionByIndex(driver,"//*[@class = 'img']",0,"Employer and Individual Plans");
    }//end of test 1

    @Test(priority = 2)
    public void zipCodeClick() throws InterruptedException {
        //enter zip code
        ReusableActions.sendKeysAction(driver,"//*[@id = 'location']","11365","Enter Zip Code");
        Thread.sleep(3000);
        //click on continue
        ReusableActions.submitAction(driver,"//*[@cs-id = 'locationSubmit']","Continue Button");
        //click on national options ppo 30
        ReusableActions.clickAction(driver,"//*[@class = 'sc-jomqko TEkcT']","national options ppo 30");
        //click on general dentist
        ReusableActions.clickAction(driver,"//*[@data-testid = 'fpc-guest-experience-find-care']","Find Care Button");
        ReusableActions.clickAction(driver,"//*[@src = '/static/media/gs_icn_pro_generaldentist-5b5a552c.svg']","General Dentist");

    }//end of test 2

    @Test(priority = 3)
    public void chooseDoctor() {
        //select a mile from drop down
        ReusableActions.selectByText(driver,"//*[@class = 'radiusMiles ng-pristine ng-valid ng-not-empty ng-touched ally-focus-within']","Within 5 Miles","Drop Down");
        driver.navigate().refresh();
        //click on first doctor name
        ReusableActions.clickAction(driver,"//*[@data-test-id = 'provider-name-link']","Doctor Name");
        //click on save button
        ReusableActions.clickAction(driver,"//*[@data-test-id = 'saved-provider-button']","Save Button");
        //capture address, miles, and network type
        String address = ReusableActions.getTextAction(driver,"//*[@class = 'undefined adr']","Address Text");
        String distance = ReusableActions.getTextAction(driver,"//*[@data-test-id = 'distance-away']","Distance");
        String network = ReusableActions.getTextAction(driver,"//*[@class = 'status-label']","Status");
        //print the information
        System.out.println("Address: " + address + "Miles: " + distance + "Network: " + network);
        driver.close();
    }//end of test 3

    @Test(priority = 4)
    public void searchResults() {
        //switch back to default tab
        ReusableActions.switchToTabByIndex(driver,0);
        //enter keyword doctor on the search field on top right corner
        ReusableActions.sendKeysAction(driver,"//*[@id = 'search-desktop']","doctor","Type in search");
        //click search button
        ReusableActions.submitAction(driver,"//*[@id = 'search__button-desktop']","Search Button");
        //capture the search results
        String searchResult = ReusableActions.getTextAction(driver,"//*[@id = 'search-results-count__header']","Search Results");
        String[] splitSearchResult = searchResult.split("for");
        System.out.println(splitSearchResult[0]);
    }//end of test 4


}//end of class
