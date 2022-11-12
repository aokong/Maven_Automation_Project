package Day3_100822;

public class Reusable_Class {
    public static void addTwoNumbers(int a, int b){
        int result = a + b;
        System.out.println("The result is " + result);
    }//end of addTwoNumbers


    //create a return method that will add two numbers and return the result from the print statement
    public static int returnAddTwoNumbers(int a, int b){
        int result = a + b;
        System.out.println("The return result is " + result);
        return result;
    }//end of returnAddTwoNumbers


}//end of java class
