package Day3_100822;

import java.util.ArrayList;

public class T3_ArrayList_Loop_Conditions {
    public static void main(String[] args) {
        //<> refers to anchor
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Africa");
        countries.add("Australia");
        //using for loop to iterate through countries list and print out only if the country is USA or Australia
        for (int i = 0; i < countries.size(); i++) {
            //two equal signs will compare the value from right and left side
            //one equal sign used to set a value for a variable

            if (countries.get(i) == "USA") {
                System.out.println("Country is USA and index i is " + i);
            } else if (countries.get(i) == "Australia") {
                System.out.println("Country is Australia and index i is " + i);
            }

            //using OR (||) operator you can write both/multiple conditions on one if statement
            if (countries.get(i) == "USA" || countries.get(i) == "Australia") {
                System.out.println("Country is " + countries.get(i) + " and index i is " + i);
            }
        }//end of for loop


    }//end of main
}//end of java class
