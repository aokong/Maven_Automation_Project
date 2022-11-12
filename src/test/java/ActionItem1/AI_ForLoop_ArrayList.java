package ActionItem1;

import java.util.ArrayList;

public class AI_ForLoop_ArrayList {
    public static void main(String[] args) {
        //declare and define the array list for country
        ArrayList<String> country = new ArrayList<>();
        country.add("United States");
        country.add("Canada");
        country.add("China");
        country.add("Korea");
        //declare and define the array list for country code
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(11);
        countryCode.add(22);
        countryCode.add(33);
        countryCode.add(44);
        //call for loop to print out the countries and country codes from array list
        //could also use i < country.size();
        for(int i=0; i < 4; i++){
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of for loop

    }//end of main
}//end of java class
