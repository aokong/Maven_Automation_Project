package Day12_110622;

import ReusableLibrary.ReusableActions_Loggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ReusableAnnotations extends ReusableAnnotations {

    @Test
    public void searchForBMW(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //hit submit on Google search button
        ReusableActions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBMW")
    public void captureSearchNumber(){
        //capture the search results text
        String results = ReusableActions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"");
        String[] arrayResults = results.split(" ");
        //print back to html by using log info
        logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResults[1]);
    }//end of test 2

}//end of class
