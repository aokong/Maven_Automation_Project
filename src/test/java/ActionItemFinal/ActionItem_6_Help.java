package ActionItemFinal;

import ReusableLibrary.ReusableActions_Loggers;
import ReusableLibrary.ReusableAnnotations;
import org.testng.annotations.Test;

public class ActionItem_6_Help extends ReusableAnnotations {

    @Test(priority = 1)
    public void tc001_helpCenterChat() throws InterruptedException {
        //navigate to united airlines website
        driver.navigate().to("https://www.united.com/ual/en/us");
        Thread.sleep(3000);
        //scroll down to click on help center
        ReusableActions_Loggers.scrollByView(driver,"//*[@href='https://www.united.com/ual/en/us/fly/customer-support.html']", logger,"Scroll to Help Center");
        ReusableActions_Loggers.clickAction(driver,"//*[@href='https://www.united.com/ual/en/us/fly/customer-support.html']",logger,"Help Center Bottom Page");
        //scroll down to click on chat
        ReusableActions_Loggers.scrollByView(driver,"//*[@class='liveChatButton']", logger,"Scroll to Chat with us");
        ReusableActions_Loggers.clickAction(driver,"//*[@class='liveChatButton']",logger,"Click Chat with us");
        Thread.sleep(2500);
        //store first chat bubble as a string and print it
        String agentText = ReusableActions_Loggers.getTextAction(driver,"//*[@data-lp-cust-id='transcript_bubble_agent_text']",logger,"First Chat Bubble");
        System.out.println("First Chat Bubble: " + agentText);
        Thread.sleep(3000);
        //click on Let's Chat
        ReusableActions_Loggers.clickAction(driver,"//*[@class='chips-item']",logger,"Click Let's Chat");
        Thread.sleep(10000);
        //store second chat bubble as a string and print it
        String agentText2 = ReusableActions_Loggers.getTextAction(driver,"//*[@class='lp-json-pollock-element-text lpc_card__text lpc_desktop']",logger,"Second Chat Bubble");
        System.out.println("Second Chat Bubble: " + agentText2);
        //click on login
        ReusableActions_Loggers.clickAction(driver,"//*[@class='lp-json-pollock-element-button lpc_card__button lpc_desktop']",logger,"Click Login With Mileage Plus");
        Thread.sleep(3000);

    }//end of test 1

    @Test(priority=2)
    public void tc002_typeInChat() throws InterruptedException {
        //navigate to united airlines website
//        driver.navigate().to("https://www.united.com/ual/en/us");
//        Thread.sleep(3000);
//        //scroll down to click on help center
//        ReusableActions_Loggers.scrollByView(driver,"//*[@href='https://www.united.com/ual/en/us/fly/customer-support.html']", logger,"Scroll to Help Center");
//        ReusableActions_Loggers.clickAction(driver,"//*[@href='https://www.united.com/ual/en/us/fly/customer-support.html']",logger,"Help Center Bottom Page");
//        //scroll down to click on chat
//        ReusableActions_Loggers.scrollByView(driver,"//*[@class='liveChatButton']", logger,"Scroll to Chat with us");
//        ReusableActions_Loggers.clickAction(driver,"//*[@class='liveChatButton']",logger,"Click Chat with us");
//        Thread.sleep(2500);
        //type hello in chat and send
        ReusableActions_Loggers.sendKeysAction(driver,"//*[@data-lp-cust-id='input_text']","Hello",logger,"Type in Chat");
        ReusableActions_Loggers.clickAction(driver,"//*[@class='lp_paper_plane_button lpc_composer__send-button lpc_desktop']",logger,"Press send message");
        Thread.sleep(15000);
        //store the response as a string and print it to know the chat works
        String agentResponse = ReusableActions_Loggers.getTextAction(driver,"//*[@class='lp-json-pollock-element-text lpc_card__text lpc_desktop']",logger,"Agent Response");
        System.out.println("Agent Response: " + agentResponse);

    }//end of test 2


}//end of java class
