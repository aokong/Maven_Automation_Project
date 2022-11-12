package ActionItem1;

public class AI_WhileLoop_LinearArray {
    public static void main(String[] args) {

        //declare and define linear array variables for region
        String[] region = new String[]{"New York", "Los Angeles", "Boston", "Texas"};
        //declare and define linear array variables for areaCode
        int[] areaCode = new int[]{123, 234, 345, 456};
        //set initializer
        int i = 0;
        //set condition for while loop
        //could also use (i < 4)
        while (i < region.length) {
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
            //incrementation
            i++;

        }//end of while loop


    }//end of main
}//end of java class
