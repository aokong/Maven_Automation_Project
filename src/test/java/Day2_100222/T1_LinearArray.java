package Day2_100222;

public class T1_LinearArray {

    public static void main(String[] args) {

        //declare a String array variable.
        String[] zipCode, streetNumber;
        //defining zipcode values for the linear string array
        zipCode = new String[]{"11365", "11366", "11432", "11790"};
        //define streetNumber values for linear array
        streetNumber = new String[]{"123", "456", "789", "777"};
        //print a value from zipcode. Array always starts from 0 index
        System.out.println("Zipcode: " + zipCode[3] + " " + zipCode[0] + " & Street Number: " + streetNumber[0]);
        //System.out.println("Street Number: " + streetNumber[3]);

    }//end of main
}//end of java class
