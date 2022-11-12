package Day3_100822;

public class T5_Return_Method_Example {

    public static void main(String[] args) {
        //the result of return method is equal to the value you stored in the new variable
        int value = Reusable_Class.returnAddTwoNumbers(5,2);
        //now you can set additional calculations to the value since you stored it as a variable
        System.out.println("New value is " + (value - 3));
    }//end of main
}//end of java class
