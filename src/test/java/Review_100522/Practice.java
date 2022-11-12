package Review_100522;

import java.util.ArrayList;

public class Practice {
    public static void main(String[] args) {
        // create a linear array of car brands (5)
        // print it out to the console using while loop

        String[] carBrands = new String[]{"BMW", "Benz", "Audi", "Rolls Royce", "Tesla"};
        for (int i = 0; i < carBrands.length; i++) {
            System.out.println(carBrands[i]);
        } //end of for loop

        // create an arraylist of phone numbers
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("3477536552");
        phoneNumbers.add("9177536553");
        phoneNumbers.add("5167536554");
        phoneNumbers.add("2127536555");
        phoneNumbers.add("9297536556");

        int i = 0;
        while (i < phoneNumbers.size()) {
            System.out.println(phoneNumbers.get(i));
            i++;
        }//end of while loop


    }//end of main
}//end of java class
