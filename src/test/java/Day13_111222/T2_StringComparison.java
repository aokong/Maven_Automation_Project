package Day13_111222;

import ReusableLibrary.ReusableActions_Loggers;
import ReusableLibrary.ReusableAnnotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T2_StringComparison extends ReusableAnnotations {

    @Test(priority = 1)
    public void tc001_verifyYahooPageTitle() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String expectedTitle = "Yahoo..";
        //get page title
        String actualTitle = driver.getTitle();

//        System.out.println("My actual title is: " + actualTitle);
//
//        System.out.println("My expected title is: " + expectedTitle);

        if (actualTitle.equals(expectedTitle)){
            logger.log(LogStatus.PASS, "Expected Result matches with Actual Result");

        }
        else {
            logger.log(LogStatus.FAIL, "Expected Results does not match with Actual Result");
        }


    }//end of test 1

    //hello comment
    //new comment

    @Test(priority = 1)
    public void tc002_verifyYahooSignInText() {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //define our expected string variable
        String actualYahooSignInButtonText = ReusableActions_Loggers.getTextAction(driver,"//*[@class='_yb_18vjf']",logger,"Sign In Button");
        //define expected string text
        String expectedYahooSignInButtonText = "Signin";
        ReusableActions_Loggers.compareExpectedAndActualText(expectedYahooSignInButtonText,actualYahooSignInButtonText,logger);

    }//end of test 2


}//end of class
