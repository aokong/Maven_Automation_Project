package ActionItemFinal;

import ReusableLibrary.ReusableActions;
import ReusableLibrary.ReusableActions_Loggers;
import ReusableLibrary.ReusableAnnotations;
import org.testng.annotations.Test;

public class ActionItem_6_MyTrips extends ReusableAnnotations {


    @Test (priority = 1)
    public void tc000_topBannerExpands() throws InterruptedException {
        //testing to see if clicking each tab expands an array of options
        //navigate to united airlines website
        driver.navigate().to("https://www.united.com/ual/en/us");
        Thread.sleep(2000);
        //using a for loop to click through each tab on top banner and grab the title underneath for each tab
        for (int i=0; i<6;i++){
            //clicking each tab by index i
            ReusableActions_Loggers.clickActionByIndex(driver,"//*[@class='app-components-GlobalHeader-globalHeader__tabHeader--2X8CE']", i, logger, "Top Banner");
            Thread.sleep(1000);
            //storing the title underneath the tab as a string
            String tabText = ReusableActions_Loggers.getTextAction(driver,"//*[@class='app-components-GlobalHeader-globalHeader__tabPanelHeaderContainer--2veWq']/div/h3", logger,"Tab Title Text");
            //print out the title
            System.out.println("Tab Title: " + tabText);
        }//end of for loop
    }//end of test 0
    @Test(priority = 2)
    public void tc001_clickTopBanner() {
        //navigate to united airlines website
        driver.navigate().to("https://www.united.com/ual/en/us");
        //click on My Trips tab
        ReusableActions_Loggers.clickActionByIndex(driver,"//*[@class='app-components-GlobalHeader-globalHeader__tabHeader--2X8CE']", 1, logger, "My Trips Tab");
        //click into My Trips
        ReusableActions_Loggers.clickAction(driver,"//*[@id='L2VuL3VzL21hbmFnZXJlcy9teXRyaXBzMQ']", logger,"My Trips Index");
        //store the title of the page as a string
        String textFromMyTrips = ReusableActions_Loggers.getTextAction(driver,"//*[@class='atm-c-page-header__title']", logger, "Title Text");
        //print the title
        System.out.println("User is able to click My Trips tab, click My Trips, and grab page title: ");
        System.out.println(textFromMyTrips);

    }//end of test 1

    @Test(dependsOnMethods = "tc001_clickTopBanner")
    public void tc002_checkFaq() {
        //scroll down to FAQ
        ReusableActions_Loggers.scrollByView(driver,"//*[@class='atm-c-section__title']",logger,"Scroll to FAQ");
        //store FAQ as string
        String faqText = ReusableActions_Loggers.getTextAction(driver,"//*[@class='atm-c-section__inner']",logger,"FAQ Text");
        //print out the FAQ text
        System.out.println("User is able to scroll to the bottom and grab FAQ information: ");
        System.out.println(faqText);
    }//end of test 2

    @Test(priority = 3)
    public void tc003_requestRefund() {
        //navigate to united airlines website
        driver.navigate().to("https://www.united.com/ual/en/us");
        //click on My Trips tab
        ReusableActions_Loggers.clickActionByIndex(driver,"//*[@class='app-components-GlobalHeader-globalHeader__tabHeader--2X8CE']", 1, logger, "My Trips Tab");
        //click into Request a refund
        ReusableActions_Loggers.clickAction(driver,"//*[@href='https://www.united.com/en/us/refunds']", logger,"Request a Refund");
        //close login popup
        ReusableActions_Loggers.clickAction(driver,"//*[@class='app-components-Modal-styles__closeIcon--2a-8F']", logger, "X out Login Pop up");
    }//end of test 3

    @Test(dependsOnMethods = "tc003_requestRefund")
        public void tc004_checkStatus() throws InterruptedException {
        Thread.sleep(2000);
        //click on check status tab
        ReusableActions_Loggers.clickActionByIndex(driver,"//*[@class='atm-c-tabs__link']", 4,logger,"Check Status Tab");
        Thread.sleep(2000);
        //input information
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@name='checkStatusModel.lastName']","KONG",logger,"Input Last Name");
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@name='checkStatusModel.statusNumber']","12345678",logger,"Input Ticket Number");
        Thread.sleep(2000);
        //click check status button
        ReusableActions_Loggers.clickActionByIndex(driver,"//*[@class='atm-c-btn__text']", 3, logger,"Check Status Button");
        Thread.sleep(2000);
        //get text for alert of wrong credentials
        String alertText = ReusableActions_Loggers.getTextAction(driver,"//*[@class='atm-c-alert__title']",logger,"Wrong Info Alert");
        String alertText2 = ReusableActions_Loggers.getTextAction(driver,"//*[@class='atm-c-text-passage atm-c-alert__description']",logger,"Wrong Info Alert 2");
        System.out.println("User should not be able to proceed with given information. Error message: ");
        System.out.println(alertText + alertText2);


    }//end of test 4

}//end of java class
