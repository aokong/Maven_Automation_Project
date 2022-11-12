package Day2_100222;

import java.util.ArrayList;

public class T2_ArrayList {

    public static void main(String[] args) {

        //declare abd define an arrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        //now add the values for countries array
        countries.add("USA");
        countries.add("Canada");
        countries.add("China");
        countries.add("Bangladesh");

        //print usa from the countries list
        System.out.println("Country: " + countries.get(0));
        //print the number of countries in list
        System.out.println("Country count: " + countries.size());

        //call an integer array list for streetNumber
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(111);
        streetNumber.add(222);
        streetNumber.add(333);
        System.out.println("Third street number: " + streetNumber.get(2));

    }//end of main

}//end of java class
