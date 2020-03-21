package OfficeHours;

import java.util.HashMap;
import java.util.Map;

public class OH_Map {
    public static void main(String[] args) {


        // is map iterable no!!!


        Map<String , String> nameStatePair = new HashMap<>(); // or LinkedHashMap to keep order
        nameStatePair.put("Faitih", "Fl");
        nameStatePair.put("Zhibeckchach", "IL");
        nameStatePair.put("Vlad", "SC");
        nameStatePair.put("Hasan", "NY");
        nameStatePair.put("Omer", "TX");
        nameStatePair.put("Atakan", "Ga");




        // take home task : create a map of productNam, price
        // using selenium to get all the data and store it into Map.
    }
}
